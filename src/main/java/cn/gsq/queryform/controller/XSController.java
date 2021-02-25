package cn.gsq.queryform.controller;

import cn.gsq.queryform.domain.XS;
import cn.gsq.queryform.service.XSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author diao 2021/2/25
 */
@RequestMapping("/xs")
@RestController
public class XSController {
    @Autowired
    XSService xsService;
    @RequestMapping("/findAll")
    public List<XS> findAll() {
        return xsService.findAll();
    }
}
