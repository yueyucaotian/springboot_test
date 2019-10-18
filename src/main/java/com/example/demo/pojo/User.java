package com.example.demo.pojo;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Setter
@Getter
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private int lockVersion;

    private String loginName;

    private String loginEmail;

    private String loginPhone;

    private String nickName;

    private String pwd;

    private long createPerson;

    private String createTime;

    private String enableState;

    private String aType;

    private String lastLoginTime;

    private String lastLoginIp;

    private String orderby;

    private String singleLogin;

    private String activationTime;

    private String token;

}
