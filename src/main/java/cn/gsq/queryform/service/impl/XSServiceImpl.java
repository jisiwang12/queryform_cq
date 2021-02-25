package cn.gsq.queryform.service.impl;

import cn.gsq.queryform.dao.XSDao;
import cn.gsq.queryform.domain.XS;
import cn.gsq.queryform.service.XSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author diao 2021/2/25
 */
@Service
public class XSServiceImpl implements XSService {
    @Autowired
    XSDao xsDao;
    @Override
    public List<XS> findAll() {
        return xsDao.findAll();
    }
}
