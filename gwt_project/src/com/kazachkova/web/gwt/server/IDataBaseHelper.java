package com.kazachkova.web.gwt.server;

import java.util.ArrayList;

public interface IDataBaseHelper {
    public void getAllEnrol();
    public void addEnrollee(String login, String password, String name, String surname);
    public boolean isUserValid(String login, String password);
    public ArrayList<String> getSubjectList();
    public ArrayList<String> getDepList();

}
