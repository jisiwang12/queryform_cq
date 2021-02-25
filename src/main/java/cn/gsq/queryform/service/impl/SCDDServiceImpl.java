package cn.gsq.queryform.service.impl;

import cn.gsq.queryform.dao.SCDDDao;
import cn.gsq.queryform.domain.SCDD;
import cn.gsq.queryform.service.SCDDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author diao 2021/2/24
 */
@Service
public class SCDDServiceImpl implements SCDDService {
    @Autowired
    SCDDDao scddDao;

    @Override
    public List<SCDD> findByMD() {
        return scddDao.findAllByMD();
    }

    @Override
    public List<SCDD> findByWX() {
        return scddDao.findByWX();
    }

    @Override
    public List<SCDD> findByZZ() {
        return scddDao.findByZZ();
    }

    @Override
    public List<SCDD> findByPK() {
        return scddDao.findByPK();
    }
}
