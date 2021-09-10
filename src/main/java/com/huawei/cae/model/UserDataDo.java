package com.huawei.cae.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDataDo implements Serializable {
    private static final long serialVersionUID = 3531805912578317266L;
    private Integer id;
    private String userName;
    private Integer scanNum;

    public UserDataDo(String userName) {
        this.userName = userName;
        this.scanNum = 0;
    }

}
