package com.kazachkova.web.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

public class AdminStart implements EntryPoint {
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";
    public void onModuleLoad() {

        final Label pswdLabel = new Label("Please enter your admin password");
        RootPanel.get("passwordLabelContainer").add(pswdLabel);

        final PasswordTextBox pswdBox = new PasswordTextBox();
        RootPanel.get("passwordFieldContainer").add(pswdBox);

        final String truePswd = "root";

        final Button submitButton = new Button("Submit");
        RootPanel.get("submitButtonContainer").add(submitButton);

        final Label errorLabel = new Label();
        RootPanel.get("errorLabelContainer").add(errorLabel);

        submitButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String pswd = pswdBox.getText();
                if (pswd.equals(truePswd)) {
                    Window.Location.assign("http://localhost:8080/AdminInformation.html");
                } else {
                    //errorLabel.setText("Access Denied. Check your login.");
                    errorLabel.setText(pswd);
                }
            }
        });

    }
}
