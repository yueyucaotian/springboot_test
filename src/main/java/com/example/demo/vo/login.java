package com.example.demo.vo;

import java.io.Serializable;

public class login implements Serializable {
    /**
     * 登陆
     */
    private static final long serialVersionUID = 4420260525137459546L;


    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
