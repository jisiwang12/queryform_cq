package cn.gsq.queryform.service.impl;

import cn.gsq.queryform.dao.WXTNInfoDao;
import cn.gsq.queryform.domain.WXTNInfo;
import cn.gsq.queryform.service.WXTNInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author diao 2021/2/25
 */
@Service
public class WXTNInfoServiceImpl implements WXTNInfoService {
    @Autowired
    WXTNInfoDao wxtnInfoDao;
    @Override
    public List<WXTNInfo> findAll() {
        return wxtnInfoDao.findAll();
    }
}
