package com.maventutorials.util;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;

import javax.servlet.http.HttpServletRequest;

public class BaseMethods {

    public static String getErrorMessage(HttpServletRequest request, String key) {

        Exception exception = (Exception) request.getSession().getAttribute(key);

        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username or password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else if (exception instanceof DisabledException) {
            error = "Account is Deactivated, Please contact to Admin!";
        } else {
            error = "Invalid username or password!";
        }

        return error;
    }
}
