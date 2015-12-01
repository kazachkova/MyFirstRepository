package com.kazachkova.web.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.kazachkova.web.gwt.client.GenService;
import com.kazachkova.web.gwt.shared.Enrollee;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Information implements EntryPoint {
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";

    public void onModuleLoad() {
        final String login  = Cookies.getCookie("cook");

        GenService.App.getInstance().getInformation(login, new AsyncCallback<Enrollee>() {
            @Override
            public void onFailure(Throwable caught) {
                Logger logger = Logger.getLogger("Server Log");
                logger.log(Level.WARNING, SERVER_ERROR);
            }

            @Override
            public void onSuccess(Enrollee result) {
                final Label nameLabel = new Label("Name: "+result.getName());
                RootPanel.get("nameLabelContainer").add(nameLabel);

                final Label surnameLabel = new Label("Surname: "+result.getSurname());
                RootPanel.get("surnameLabelContainer").add(surnameLabel);

                final Label departmentLabel = new Label("Department: "+result.getDepName());
                RootPanel.get("depNameLabelContainer").add(departmentLabel);

                final Label averageLabel = new Label("Average mark: "+result.getAverage());
                RootPanel.get("averageLabelContainer").add(averageLabel);

                final Label scoreLabel = new Label("Score: "+result.getSumScore());
                RootPanel.get("scoreLabelContainer").add(scoreLabel);

                final Label statusLabel = new Label("Status: "+result.getStatus());
                RootPanel.get("statusLabelContainer").add(statusLabel);

                final Label resultLabel = new Label("Result: "+result.getResult());
                RootPanel.get("resultLabelContainer").add(resultLabel);

                final Button refreshButton = new Button("Refresh");
                RootPanel.get().add(refreshButton);
                refreshButton.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        Window.Location.reload();
                    }
                });
            }
        });
    }
}
