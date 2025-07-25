package com.motorph.util;

import com.motorph.model.Employee;

public class LoginSessionManager {

    private static Employee currentUser;

    public static void login(Employee employee) {
        currentUser = employee;
    }

    public static void logout() {
        currentUser = null;
    }

    public static Employee getLoggedInUser() {
        return currentUser;
    }

    public static boolean isLoggedIn() {
        return currentUser != null;
    }
}
