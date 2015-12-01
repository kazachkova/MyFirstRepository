package com.kazachkova.web.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application implements EntryPoint {
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";
    private void sendApplicationToServer(String login, String department,
                                            Integer subject_1, Integer subject_2,
                                            Integer subject_3, Double averageMark) {
        GenService.App.getInstance().setApp(login, department, subject_1,
                subject_2, subject_3, averageMark, new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        Logger logger = Logger.getLogger("Server Log");
                        logger.log(Level.WARNING, SERVER_ERROR);
                    }

                    @Override
                    public void onSuccess(Void result) {
                        Logger logger = Logger.getLogger("Send To Server");
                        logger.log(Level.INFO, "Send application to server");
                    }
                });
    }
    private ListBox getSubListFromServer() {
        final ListBox subList = new ListBox();
        GenService.App.getInstance().getSubjectList(new AsyncCallback<ArrayList<String>>() {
            @Override
            public void onFailure(Throwable caught) {
                Logger logger = Logger.getLogger("Server Log");
                logger.log(Level.WARNING, SERVER_ERROR);
            }

            @Override
            public void onSuccess(ArrayList<String> result) {
                for (String i : result) {
                    subList.addItem(i);
                }
            }
        });
        return subList;
    }
    private ListBox getDepListFromServer() {
        final ListBox departmentList = new ListBox();
        GenService.App.getInstance().getDepList(new AsyncCallback<ArrayList<String>>() {
            @Override
            public void onFailure(Throwable caught) {
                Logger logger = Logger.getLogger("Server Log");
                logger.log(Level.WARNING, SERVER_ERROR);
            }

            @Override
            public void onSuccess(ArrayList<String> result) {
                for (String i : result) {
                    departmentList.addItem(i);
                }
            }
        });
        return departmentList;
    }

    public void onModuleLoad() {
        final String login = Cookies.getCookie("cook");
        final TextBox averageBox = new TextBox();
        final Label averageLabel = new Label("Please enter your average mark");
        RootPanel.get("averageLabelContainer").add(averageLabel);
        RootPanel.get("averageFieldContainer").add(averageBox);
        averageBox.setFocus(true);

        final ListBox departmentList = getDepListFromServer();
        final Label depListLabel = new Label("Please chose department");
        RootPanel.get("depLabelContainer").add(depListLabel);
        RootPanel.get("depListContainer").add(departmentList);

        final Label subLabel_1 = new Label();
        final TextBox subScoreBox_1 = new TextBox();

        final Label subLabel_2 = new Label();
        final TextBox subScoreBox_2 = new TextBox();


        final Label subLabel_3 = new Label();
        final TextBox subScoreBox_3 = new TextBox();

        departmentList.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {

                GenService.App.getInstance().getDepartmentSubjects(departmentList.getSelectedItemText(),
                        new AsyncCallback<ArrayList<String>>() {
                            @Override
                            public void onFailure(Throwable caught) {
                                Logger logger = Logger.getLogger("Server Log");
                                logger.log(Level.WARNING, SERVER_ERROR);
                            }

                            @Override
                            public void onSuccess(ArrayList<String> result) {
                                subLabel_1.setText("Enter your "+result.get(0)+" score");
                                subLabel_2.setText("Enter your "+result.get(1)+" score");
                                subLabel_3.setText("Enter your "+result.get(2)+" score");
                            }
                        });

                RootPanel.get("subLabelContainer1").add(subLabel_1);
                RootPanel.get("subListContainer1").add(subScoreBox_1);

                RootPanel.get("subLabelContainer2").add(subLabel_2);
                RootPanel.get("subListContainer2").add(subScoreBox_2);

                RootPanel.get("subLabelContainer3").add(subLabel_3);
                RootPanel.get("subListContainer3").add(subScoreBox_3);

                final Button submitButton = new Button("Submit");
                submitButton.addStyleName("sendButton");
                RootPanel.get("submitButtonContainer").add(submitButton);

                submitButton.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        sendApplicationToServer(login, departmentList.getSelectedItemText(),
                                Integer.parseInt(subScoreBox_1.getText()),
                                Integer.parseInt(subScoreBox_2.getText()),
                                Integer.parseInt(subScoreBox_3.getText()),
                                Double.parseDouble(averageBox.getText())
                        );
                        Window.Location.assign("http://localhost:8080/Information.html");
                    }
                });

            }
        });
    }
}
