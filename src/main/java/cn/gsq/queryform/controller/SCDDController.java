package cn.gsq.queryform.controller;

import cn.gsq.queryform.domain.SCDD;
import cn.gsq.queryform.service.SCDDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author diao 2021/2/24
 */
@RestController
@RequestMapping("/scdd")
public class SCDDController {
    @Autowired
    SCDDService scddService;

    @RequestMapping("/findByMD")
    public List<SCDD> findByMD() {
        return scddService.findByMD();
    }
    @RequestMapping("/findByZZ")
    public List<SCDD> findByZZ() {
        return scddService.findByZZ();
    }
    @RequestMapping("/findByWX")
    public List<SCDD> findByWX() {
        return scddService.findByWX();
    }
    @RequestMapping("/findByPK")
    public List<SCDD> findByPK() {
        return scddService.findByPK();
    }
}
