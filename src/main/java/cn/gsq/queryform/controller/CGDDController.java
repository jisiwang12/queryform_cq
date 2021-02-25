package cn.gsq.queryform.controller;

import cn.gsq.queryform.domain.CGDD;
import cn.gsq.queryform.service.CGDDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author diao 2021/2/24
 */
@RequestMapping("/cgdd")
@RestController
public class CGDDController {

    @Autowired
    CGDDService cgddService;

    @RequestMapping("findAll")
    public List<CGDD> findAll() {
        return cgddService.findAll();
    }
}
