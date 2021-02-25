package cn.gsq.queryform.controller;

import cn.gsq.queryform.domain.TimeOut;
import cn.gsq.queryform.service.TimeOutService;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.List;

/**
 * @author diao 2021/2/22
 */
@RestController
@RequestMapping("/timeout")
public class TimeOutController {
    @Autowired
    TimeOutService timeOutService;

    @RequestMapping("/findAll")
    public List<TimeOut> findAll() {
        return timeOutService.findAll();

    }
}
