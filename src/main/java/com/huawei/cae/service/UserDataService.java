package com.huawei.cae.service;


import com.huawei.cae.model.UserDataDo;

public interface UserDataService {


    UserDataDo getData(String userName);

    void insert(String userName,Integer total);

    void updateTotal(String userName,Integer total);

    Integer getTotalScanNum();

}
