package com.huawei.cae.mapper;

import com.huawei.cae.model.UserDataDo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataMapper {
    UserDataDo query(String userName);

    void insert(String userName, Integer scanNum);

    void updateTotal(String userName, Integer scanNum);

    Integer getTotalScanNum();
}
