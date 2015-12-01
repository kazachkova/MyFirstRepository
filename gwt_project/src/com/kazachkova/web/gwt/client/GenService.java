package com.kazachkova.web.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.core.client.GWT;
import com.kazachkova.web.gwt.shared.Enrollee;

import java.util.ArrayList;

@RemoteServiceRelativePath("generator")
public interface GenService extends RemoteService {
    Integer generate();
    Boolean isUserValid(String login, String password);
    ArrayList<String> getDepList();
    ArrayList<String> getSubjectList();
    void setApp(String login, String nameDep, Integer sub_1,
                Integer sub_2, Integer sub_3, Double average);
    void sendEnrollee(String login, String password, String name, String surname);
    ArrayList<String> getDepartmentSubjects(String depName);

    void logout();

    String loginFromSessionServer();

    String loginServer(String name);

    Enrollee getInformation(String login);

    Boolean isApplicationExist(String login);

    ArrayList<Enrollee> getAllDepartmentEnrollee(String departmentName);

    public static class App {
        private static final GenServiceAsync ourInstance = (GenServiceAsync) GWT.create(GenService.class);

        public static GenServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
