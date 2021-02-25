package cn.gsq.queryform.controller;

import cn.gsq.queryform.domain.YCTimeOut;
import cn.gsq.queryform.service.YCTimeOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author diao 2021/2/24
 */
@RequestMapping("/yctimeout")
@RestController
public class YCController {

    @Autowired
    YCTimeOutService ycTimeOutService;

    @RequestMapping("/findAll")
    public List<YCTimeOut> findAll() {
        List<YCTimeOut> all = ycTimeOutService.findAll();
        System.out.println(all.get(0).get库存数量());
        return all;
    }
}
