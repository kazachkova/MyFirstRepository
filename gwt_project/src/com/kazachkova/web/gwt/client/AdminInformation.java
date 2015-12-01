package com.kazachkova.web.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.kazachkova.web.gwt.shared.Enrollee;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AdminInformation implements EntryPoint {
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";
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

        final ListBox departmentList = getDepListFromServer();
        final Label depListLabel = new Label("Please chose department");
        RootPanel.get("depLabelContainer").add(depListLabel);
        RootPanel.get("depFieldContainer").add(departmentList);

        final FlexTable table = new FlexTable();
        table.setTitle("Information about students");
        table.setText(0, 0, "StudentID");
        table.setText(0, 1, "Average Mark");
        table.setText(0, 2, "Sum Score");
        table.setText(0, 3, "Status");
        table.setText(0, 4, "Result");
        final ArrayList<Enrollee> enrollees = new ArrayList<>();
        departmentList.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                RootPanel.get("tableContainer").clear();
                GenService.App.getInstance().getAllDepartmentEnrollee(departmentList.getSelectedItemText(),
                        new AsyncCallback<ArrayList<Enrollee>>() {
                            @Override
                            public void onFailure(Throwable caught) {
                                Logger logger = Logger.getLogger("Server Log");
                                logger.log(Level.WARNING, SERVER_ERROR);
                            }

                            @Override
                            public void onSuccess(ArrayList<Enrollee> result) {

                                for (int i = 0; i < result.size(); i++) {
                                    table.setText(i + 1, 0, result.get(i).getLogin());
                                    table.setText(i + 1, 1, result.get(i).getAverage() + "");
                                    table.setText(i + 1, 2, result.get(i).getSumScore() + "");
                                    table.setText(i + 1, 3, result.get(i).getStatus());
                                    table.setText(i + 1, 4, result.get(i).getResult());
                                }

                            }
                        });
                RootPanel.get("tableContainer").add(table);
            }
        });


    }
}
