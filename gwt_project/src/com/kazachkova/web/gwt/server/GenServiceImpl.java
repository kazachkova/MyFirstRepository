package com.kazachkova.web.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.kazachkova.web.gwt.client.GenService;
import com.kazachkova.web.gwt.shared.Enrollee;
import com.kazachkova.web.gwt.shared.FieldVerifier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;


public class GenServiceImpl extends RemoteServiceServlet implements GenService {
    @Override
    public Integer generate() {
        return (int) (Math.random()*1000);
    }

    @Override
    public Boolean isUserValid(String login, String password) {
        DataBaseHelper dbh = new DataBaseHelper();
        return dbh.isUserValid(escapeHtml(login), escapeHtml(password));
    }

    @Override
    public ArrayList<String> getDepList() {
        DataBaseHelper dbh = new DataBaseHelper();
        return dbh.getDepList();
    }
    @Override
    public ArrayList<String> getSubjectList() {
        DataBaseHelper dbh = new DataBaseHelper();
        return dbh.getSubList();
    }
    @Override
    public void setApp(String login, String nameDep, Integer sub_1,
                       Integer sub_2, Integer sub_3, Double average) {
        DataBaseHelper dbh = new DataBaseHelper();
        dbh.addApplication(escapeHtml(login), escapeHtml(nameDep), sub_1, sub_2, sub_3, average);
    }
    @Override
    public void sendEnrollee(String login, String password, String name, String surname) {
        DataBaseHelper dbh = new DataBaseHelper();
        dbh.addEnrollee(escapeHtml(login), escapeHtml(password), escapeHtml(name), escapeHtml(surname));
    }
    @Override
    public ArrayList<String> getDepartmentSubjects(String depName) {
        DataBaseHelper dbh = new DataBaseHelper();
        return dbh.getDepSub(escapeHtml(depName));
    }
    @Override
    public void logout() {
        deleteUserfromSession();
    }
    @Override
    public String loginFromSessionServer() {
        return getUserAlreadyFromSession();
    }
    @Override
    public String loginServer(String name) {
        createSession(name);
        return name;
    }
    @Override
    public Enrollee getInformation(String login) {
        DataBaseHelper dbh = new DataBaseHelper();
        return dbh.getInformation(escapeHtml(login));
    }
    @Override
    public Boolean isApplicationExist(String login) {
        DataBaseHelper dbh = new DataBaseHelper();
        return dbh.isEnrolExist(escapeHtml(login));
    }
    @Override
    public ArrayList<Enrollee> getAllDepartmentEnrollee(String departmentName) {
        DataBaseHelper dbh = new DataBaseHelper();
        return dbh.getAllDepEnrol(escapeHtml(departmentName));
    }


    private String escapeHtml(String html) {
        if (html == null) {
            return null;
        }
        return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }
    private void createSession(String user) {
        HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
        HttpSession session = httpServletRequest.getSession(true);
        session.setAttribute("user", user);
    }
    private void deleteUserfromSession() {
        HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
        HttpSession session = httpServletRequest.getSession();
        session.removeAttribute("user");
    }
    private String getUserAlreadyFromSession() {
        String user = null;
        HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
        HttpSession session = httpServletRequest.getSession();
        Object userObj = session.getAttribute("user");
        if (userObj != null && userObj instanceof String) {
            user = (String) userObj;
        }
        return user;
    }
}