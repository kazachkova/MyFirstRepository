import java.sql.*;


public class Students {

    private Statement st = null;
    private ResultSet rs = null;
    private Connection connection = null;

    public static void main(String[] args) throws ClassNotFoundException, SQLException, ConnectionPoolException {
        Students students = new Students();
        ConnectionPool conPool = new ConnectionPool();
        conPool.initPoolData();
        students.getStudents(conPool);
        students.getStudents(conPool);
        students.getStudents(conPool);
        students.updateRating(conPool, 69, 98.0);
        students.getStudents(conPool);
        students.getStudRating(conPool, 69);
        students.getStudents(conPool);
        conPool.dispose();
    }

    public void getStudents(ConnectionPool cp) throws SQLException, ConnectionPoolException {
        try {
            connection = cp.takeConnection();
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM STUDENTS");
            while (rs.next()) {
                System.out.println(rs.getInt("ID") + " " + rs.getString("NAME") + " "
                        + rs.getString("SURNAME") + " " + rs.getDouble("RATING"));
            }
            cp.closeConnection(connection, st, rs);
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }
    public void getStudRating(ConnectionPool cp, int id) throws SQLException, ConnectionPoolException {
        try {
            connection = cp.takeConnection();
            st = connection.createStatement();
            rs = st.executeQuery("SELECT NAME, SURNAME, RATING FROM STUDENTS WHERE ID = "+id);
            while (rs.next()) {
                System.out.println("Student " + rs.getString("NAME") + " "
                        + rs.getString("SURNAME") + " has rating " + rs.getDouble("RATING"));
            }
            cp.closeConnection(connection, st, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRating(ConnectionPool cp, int id, double rating)
            throws SQLException, ConnectionPoolException {
        try {
            connection = cp.takeConnection();
            String query = "UPDATE Students SET RATING = " + rating + " WHERE ID = " + id;
            PreparedStatement pst = connection.prepareStatement(query);
            pst.execute();
            cp.closeConnection(connection, pst);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteStudent(ConnectionPool cp, int id) throws SQLException, ConnectionPoolException {
        try {
            connection = cp.takeConnection();
            String query = "delete from STUDENTS" + " where ID = " + id;
            PreparedStatement pst = connection.prepareStatement(query);
            pst.execute();
            cp.closeConnection(connection, pst);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAllStudents(ConnectionPool cp) throws SQLException, ConnectionPoolException {
        try {
            connection = cp.takeConnection();
            String query = "delete from STUDENTS";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.execute();
            cp.closeConnection(connection, pst);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(ConnectionPool cp, String name, String surname, double rating)
            throws SQLException, ConnectionPoolException {
        try {
            connection = cp.takeConnection();
            String query = "insert into Students (NAME, SURNAME, RATING)" + " values (?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, surname);
            pst.setDouble(3, rating);
            pst.execute();
            cp.closeConnection(connection, pst);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
