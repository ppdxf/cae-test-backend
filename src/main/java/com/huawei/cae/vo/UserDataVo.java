package com.huawei.cae.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDataVo {
    private String userName;
    private Integer scanNum;

    public UserDataVo setScanNum(Integer scanNum) {
        this.scanNum = scanNum;
        return this;
    }

    public UserDataVo setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    @Override
    public String toString() {
        return "UserDataVo{" +
                "userName='" + userName + '\'' +
                ", scanNum=" + scanNum +
                '}';
    }
}
