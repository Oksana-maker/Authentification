package org.itstep;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;

    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return "User{" +
                "log='" + login + '\'' +
                ", pass='" + password + '\'' +
                '}';
    }

}
