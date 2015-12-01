package com.kazachkova.web.gwt.shared;

public class FieldVerifier {
    public static boolean isValidName(String field) {
        if (field == null) {
            return false;
        }
        return field.length() > 3;
    }
}
