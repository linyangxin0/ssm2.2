package cn.itcast.service.impl;


import cn.itcast.dao.ISysLogDao;
import cn.itcast.domain.SysLog;
import cn.itcast.service.ISysLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog){
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }
}
