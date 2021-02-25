package cn.gsq.queryform.service.impl;

import cn.gsq.queryform.dao.TimeOutDao;
import cn.gsq.queryform.domain.TimeOut;
import cn.gsq.queryform.service.TimeOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author diao 2021/2/22
 */
@Service
public class TimeOutServiceImpl implements TimeOutService {
    @Autowired
    TimeOutDao timeOutDao;
    @Override
    public List<TimeOut> findAll() {
        return timeOutDao.findAll();
    }
}
