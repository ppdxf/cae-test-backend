package com.huawei.cae.controller;

import com.huawei.cae.model.UserDataDo;
import com.huawei.cae.service.UserDataService;
import com.huawei.cae.vo.UserDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1")
public class UserDataController {
    @Autowired
    private UserDataService dataService;

    @CrossOrigin
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public UserDataVo getData(@RequestParam(value = "user_name") String userName) {
        UserDataDo data = dataService.getData(userName);
        if (data == null) {
            data = new UserDataDo(userName);
        }
        data.setScanNum(data.getScanNum() + 1);
        if (data.getScanNum() <= 1) {
            dataService.insert(data.getUserName(), data.getScanNum());
        } else {
            dataService.updateTotal(data.getUserName(), data.getScanNum());
        }
        return new UserDataVo().setUserName(data.getUserName()).setScanNum(data.getScanNum());
    }

    @CrossOrigin
    @RequestMapping(value = "/total_scan_num", method = RequestMethod.GET)
    public Integer getTotalScanNum() {
        return dataService.getTotalScanNum();
    }

    @CrossOrigin
    @RequestMapping(value = "/consume_cpu", method = RequestMethod.POST)
    public Integer clientTest() {
        // 消耗CPU 的计算
        for (int i = 0; i <= 10; i++) {
            MyThread thread = new MyThread();
            thread.start();
        }
        return 1;
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            for (int index = 0; index <= 100000000; index++) {
                Math.pow(100, 1 / 3);
            }
        }
    }

}
