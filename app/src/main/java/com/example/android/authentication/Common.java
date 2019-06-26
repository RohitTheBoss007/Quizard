package com.example.android.authentication;

import com.example.android.authentication.Model.User;

public class Common {
    public static User currentUser;

    public Common() {
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Common.currentUser = currentUser;
    }
}
