package com.kazachkova.web.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.kazachkova.web.gwt.shared.Enrollee;

import java.util.ArrayList;

public interface GenServiceAsync {

    void generate(AsyncCallback<Integer> async);

    void isUserValid(String login, String password, AsyncCallback<Boolean> async);

    void getDepList(AsyncCallback<ArrayList<String>> async);

    void getSubjectList(AsyncCallback<ArrayList<String>> async);

    void setApp(String login, String nameDep, Integer sub_1,
                Integer sub_2, Integer sub_3, Double average, AsyncCallback<Void> async);

    void sendEnrollee(String login, String password, String name, String surname, AsyncCallback<Void> async);

    void getDepartmentSubjects(String depName, AsyncCallback<ArrayList<String>> async);

    void logout(AsyncCallback<Void> async);

    void loginFromSessionServer(AsyncCallback<String> async);

    void loginServer(String name, AsyncCallback<String> async);

    void getInformation(String login, AsyncCallback<Enrollee> async);

    void isApplicationExist(String login, AsyncCallback<Boolean> async);

    void getAllDepartmentEnrollee(String departmentName, AsyncCallback<ArrayList<Enrollee>> async);
}
