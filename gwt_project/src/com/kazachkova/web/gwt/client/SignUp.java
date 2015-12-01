package com.kazachkova.web.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.logging.Level;
import java.util.logging.Logger;


public class SignUp implements EntryPoint {
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";

    private void sendEnrolleeToServer(String login, String password, String name,
                                      String surname) {
        GenService.App.getInstance().sendEnrollee(login, password, name,
                surname, new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        Logger logger = Logger.getLogger("Server Log");
                        logger.log(Level.WARNING, SERVER_ERROR);
                    }

                    @Override
                    public void onSuccess(Void result) {
                        Logger logger = Logger.getLogger("Send To Server");
                        logger.log(Level.INFO, "Send enrollee to server");
                    }
                });
    }
    public void onModuleLoad() {
        final Label loginLabelSU = new Label("Please enter your login:");
        final TextBox loginBoxSU = new TextBox();
        RootPanel.get("loginLabelContainer").add(loginLabelSU);
        RootPanel.get("loginFieldContainer").add(loginBoxSU);
        loginBoxSU.setFocus(true);
        loginBoxSU.selectAll();

        final Label passwordLabelSU = new Label("Please enter your password:");
        final PasswordTextBox pswdBoxSU = new PasswordTextBox();
        RootPanel.get("passwordLabelContainer").add(passwordLabelSU);
        RootPanel.get("passwordFieldContainer").add(pswdBoxSU);


        final Label nameLabelSU = new Label("Please enter your name");
        final TextBox nameBoxSU = new TextBox();
        RootPanel.get("nameLabelContainer").add(nameLabelSU);
        RootPanel.get("nameFieldContainer").add(nameBoxSU);


        final Label surnameLabelSU = new Label("Please enter your surname");
        final TextBox surnameBoxSU = new TextBox();
        RootPanel.get("surnameLabelContainer").add(surnameLabelSU);
        RootPanel.get("surnameFieldContainer").add(surnameBoxSU);

        final Button submitButtonSU = new Button("Submit");
        submitButtonSU.addStyleName("sendButton");
        RootPanel.get("submitButtonContainer").add(submitButtonSU);
        submitButtonSU.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                sendEnrolleeToServer(loginBoxSU.getText(), pswdBoxSU.getText(),
                        nameBoxSU.getText(), surnameBoxSU.getText());
                loginBoxSU.setEnabled(false);
                pswdBoxSU.setEnabled(false);
                nameBoxSU.setEnabled(false);
                surnameBoxSU.setEnabled(false);
                submitButtonSU.setEnabled(false);
                Window.Location.assign("http://localhost:8080/Application.html");
            }
        });
    }
}
