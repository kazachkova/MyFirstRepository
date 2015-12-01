package com.kazachkova.web.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Example implements EntryPoint {

    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";

    private Boolean boolResultApp;
    private Boolean boolResultUser;
    private String login;



    private final GenServiceAsync greetingService = GWT.create(GenService.class);

    private Boolean isApplicationExistToServer(String login) {
        GenService.App.getInstance().isApplicationExist(login, new AsyncCallback<Boolean>() {
            @Override
            public void onFailure(Throwable caught) {
                Logger logger = Logger.getLogger("Server Log");
                logger.log(Level.WARNING, SERVER_ERROR);
            }

            @Override
            public void onSuccess(Boolean result) {
                boolResultApp = result;
            }
        });
        return boolResultApp;
    }

    private Boolean isUserValidToServer(String login, String password) {
        GenService.App.getInstance().isUserValid(login, password, new AsyncCallback<Boolean>() {
            @Override
            public void onFailure(Throwable caught) {
                Logger logger = Logger.getLogger("Server Log");
                logger.log(Level.WARNING, SERVER_ERROR);

            }

            @Override
            public void onSuccess(Boolean result) {
                boolResultUser = result;
            }
        });
        return boolResultUser;
    }

    public void onModuleLoad() {

        final Label loginLabel = new Label("Please enter your login:");
        final Label passwordLabel = new Label("Please enter your password:");
        final TextBox loginBox = new TextBox();
        final PasswordTextBox pswdBox = new PasswordTextBox();
        final Button signInButton = new Button("SignIn");
        final Button signUpButton = new Button("SignUp");
        final Label errorLabel = new Label();
        final Label serverLabel = new Label();
        final Button submitButton = new Button("Submit");
        final Button adminButton = new Button("Admin");


        signInButton.addStyleName("sendButton");
        signUpButton.addStyleName("sendButton");
        submitButton.addStyleName("sendButton");

        RootPanel.get().clear();
        RootPanel.get().add(loginLabel);
        RootPanel.get().add(loginBox);
        RootPanel.get().add(passwordLabel);
        RootPanel.get().add(pswdBox);
        RootPanel.get().add(signInButton);
        RootPanel.get().add(signUpButton);
        RootPanel.get().add(errorLabel);
        RootPanel.get().add(serverLabel);
        RootPanel.get().add(adminButton);

        loginBox.setFocus(true);
        loginBox.selectAll();

        signUpButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String sessionID = login;
                //final long DURATION = 1000 * 60 * 60 * 24 * 1;
                //Date expires = new Date(System.currentTimeMillis() + DURATION);
                Cookies.setCookie("cook", sessionID);
                Window.Location.assign("http://localhost:8080/sign_up.html");
            }
        });


        signInButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                // AsyncCallback - класс обрабатывающий ответ с сервера
                Boolean resultUserValid = isUserValidToServer(loginBox.getText(), pswdBox.getText());
                Boolean resultApplicationExist = isApplicationExistToServer(loginBox.getText());
                if (resultUserValid) {
                    login = loginBox.getText();
                    String sessionID = login;
                    //final long DURATION = 1000 * 60 * 60 * 24 * 1;
                    //Date expires = new Date(System.currentTimeMillis() + DURATION);
                    Cookies.setCookie("cook", sessionID);
                    if (resultApplicationExist) {
                        Window.Location.assign("http://localhost:8080/Information.html");
                    } else {
                        Window.Location.assign("http://localhost:8080/Application.html");
                    }
                } else {
                    errorLabel.setText("Access Denied. Check your login and password.");
                }
            }
        });

        adminButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.Location.assign("http://localhost:8080/AdminStart.html");
            }
        });
    }
}
