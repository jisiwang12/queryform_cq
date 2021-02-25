package cn.gsq.queryform.service.impl;

import cn.gsq.queryform.dao.YCTimeOutDao;
import cn.gsq.queryform.domain.YCTimeOut;
import cn.gsq.queryform.service.YCTimeOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author diao 2021/2/24
 */
@Service
public class YCTimeOutServiceImpl implements YCTimeOutService {
    @Autowired
    YCTimeOutDao ycTimeOutDao;
    @Override
    public List<YCTimeOut> findAll() {
        return ycTimeOutDao.findAll();
    }
}
