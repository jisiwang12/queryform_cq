package cn.gsq.queryform.controller;

import cn.gsq.queryform.domain.WXTNInfo;
import cn.gsq.queryform.service.WXTNInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author diao 2021/2/25
 */
@RestController
@RequestMapping("/wxtn")

public class WXTNInfoController {
    @Autowired
    WXTNInfoService wxtnInfoService;

    @RequestMapping("/findAll")
    public List<WXTNInfo> findAll() {
        return wxtnInfoService.findAll();
    }
}
