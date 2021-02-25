package cn.gsq.queryform.service;

import cn.gsq.queryform.domain.SCDD;

import java.util.List;

/**
 * @author diao 2021/2/24
 */
public interface SCDDService {
    public List<SCDD> findByMD();

    public List<SCDD> findByWX();

    public List<SCDD> findByZZ();

    public List<SCDD> findByPK();
}
