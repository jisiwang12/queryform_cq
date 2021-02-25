package cn.gsq.queryform.service.impl;

import cn.gsq.queryform.dao.CGDDDao;
import cn.gsq.queryform.domain.CGDD;
import cn.gsq.queryform.service.CGDDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author diao 2021/2/24
 */
@Service
public class CGDDServiceImpl implements CGDDService {
    @Autowired
    CGDDDao cgddDao;
    @Override
    public List<CGDD> findAll() {
        return cgddDao.findAll();
    }
}
