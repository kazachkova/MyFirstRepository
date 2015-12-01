package com.kazachkova.web.gwt.server;

import com.kazachkova.web.gwt.shared.Enrollee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DataBaseHelper {
    DBResourceManager dbResourceManager = DBResourceManager.getInstance();
    final String driver = dbResourceManager.getValue(DBParameter.DB_DRIVER);
    final String url = dbResourceManager.getValue(DBParameter.DB_URL);
    final String user = dbResourceManager.getValue(DBParameter.DB_USER);
    final String password = dbResourceManager.getValue(DBParameter.DB_PASSWORD);


    private Statement st = null;
    private ResultSet rs = null;
    private Connection connection = null;

    private void openConn() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, user, password);
    }
    public Enrollee getInformation(String login) {
        Enrollee enrol = null;
        String name = null;
        String surname = null;
        String department = null;
        Integer score = null;
        Double averageMark = null;
        String status = null;
        String result = null;

        try {
            openConn();
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM INFORMATION WHERE STUDENT_ID = '"+login+"'");
            while (rs.next()) {
                name = rs.getString("NAME");
                surname = rs.getString("SURNAME");
                department = rs.getString("NAME_DEP");
                score = rs.getInt("(T1.SUBJECT_1 + T1.SUBJECT_2) + T1.SUBJECT_3");
                averageMark = rs.getDouble("AVERAGE_MARK");
                status = rs.getString("STATUS");
                result = rs.getString("RESULT");
                enrol = new Enrollee(name, surname, department, score, averageMark,
                        status, result);
            }
            rs.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrol;
    }
    public ArrayList<Enrollee> getAllDepEnrol(String depName) {
        ArrayList<Enrollee> enrolList = new ArrayList<>();
        String login = null;
        Integer score = null;
        Double averageMark = null;
        String status = null;
        String result = null;
        try {
            openConn();
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM INFORMATION WHERE NAME_DEP = '"+depName+"'");
            while (rs.next()) {
                login = rs.getString("STUDENT_ID");
                score = rs.getInt("(T1.SUBJECT_1 + T1.SUBJECT_2) + T1.SUBJECT_3");
                averageMark = rs.getDouble("AVERAGE_MARK");
                status = rs.getString("STATUS");
                result = rs.getString("RESULT");
                enrolList.add(new Enrollee(login, averageMark, score, status, result));
            }
            rs.close();
            Collections.sort(enrolList, new SortedByScoreThenAverage());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return enrolList;
    }
    public Boolean isEnrolExist(String login) {
        int count = 0;
        try {
            openConn();
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM APPLICATION WHERE STUDENT_ID = '"+login+"'");
            while (rs.next()) {
                count = rs.getRow();
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return count != 0;
    }

    public void addEnrollee(String login, String password, String name, String surname) {
        try {
            openConn();
            String query = "INSERT INTO ENROLLEE (LOGIN, PASSWORD, NAME, SURNAME)" + " VALUES (?, ?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, login);
            pst.setString(2, password);
            pst.setString(3, name);
            pst.setString(4, surname);
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isUserValid(String login, String password) {
        String passwordFromDB = null;

        try {
            openConn();
            st = connection.createStatement();
            //rs = st.executeQuery("SELECT * FROM ENROLLEE");
            rs = st.executeQuery("SELECT PASSWORD FROM ENROLLEE WHERE LOGIN = '"+login+"'");
            while (rs.next()) {
                passwordFromDB = rs.getString("PASSWORD");
                //int count = rs.getRow();
                //System.out.println(count);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return password.equals(passwordFromDB);
    }

    public ArrayList<String> getDepList() {
        ArrayList<String> depList = new ArrayList<>();
        try {
            openConn();
            st = connection.createStatement();
            rs = st.executeQuery("SELECT NAME FROM DEPARTMENT");
            while (rs.next()) {
                depList.add(rs.getString("NAME"));
            }
            rs.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return depList;
    }
    public ArrayList<String> getSubList() {
        ArrayList<String> subList = new ArrayList<>();
        try {
            openConn();
            st = connection.createStatement();
            rs = st.executeQuery("SELECT NAME FROM SUBJECT");
            while (rs.next()) {
                subList.add(rs.getString("NAME"));
            }
            rs.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subList;
    }
    public void addApplication(String login, String nameDep, Integer sub_1,
                               Integer sub_2, Integer sub_3, Double average) {
        try {
            openConn();
            String query = "INSERT INTO APPLICATION (STUDENT_ID, NAME_DEP, SUBJECT_1," +
                    " SUBJECT_2, SUBJECT_3, AVERAGE_MARK)" +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, login);
            pst.setString(2, nameDep);
            pst.setInt(3, sub_1);
            pst.setInt(4, sub_2);
            pst.setInt(5, sub_3);
            pst.setDouble(6, average);
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> getDepSub(String depName) {
        ArrayList<String> subList = new ArrayList<>();
        try {
            openConn();
            st = connection.createStatement();
            String query = "SELECT NAME FROM SUBJECT WHERE ID = " +
                    "(SELECT SUBJECT_1 FROM DEPARTMENT WHERE " +
                    "NAME = '" + depName+"') OR ID = " +
                    "(SELECT SUBJECT_2 FROM DEPARTMENT WHERE " +
                    "NAME = '" + depName+"') OR ID = " +
                    "(SELECT SUBJECT_3 FROM DEPARTMENT WHERE " +
                    "NAME = '" + depName+"')";
            rs = st.executeQuery(query);
            String subName;
            while (rs.next()) {
                subName = rs.getString("NAME");
                subList.add(subName);
            }
            rs.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subList;
    }
}
class SortedByScore implements Comparator<Enrollee> {
    @Override
    public int compare(Enrollee o1, Enrollee o2) {
        int score1 = o1.getSumScore();
        int score2 = o2.getSumScore();
        return (score1 > score2 ? -1 : (score1 == score2 ? 0 : 1));
    }
}
class SortedByAverage implements Comparator<Enrollee> {

    @Override
    public int compare(Enrollee o1, Enrollee o2) {
        double average1 = o1.getAverage();
        double average2 = o2.getAverage();
        return (average1 > average2 ? -1 : (average1 == average2 ? 0 : 1));
    }
}
class SortedByScoreThenAverage implements Comparator<Enrollee> {

    @Override
    public int compare(Enrollee o1, Enrollee o2) {
        SortedByScore sortedByScore = new SortedByScore();
        SortedByAverage sortedByAverage = new SortedByAverage();
        return ((sortedByScore.compare(o1, o2) != 0) ?
                sortedByScore.compare(o1, o2) : sortedByAverage.compare(o1, o2));
    }
}