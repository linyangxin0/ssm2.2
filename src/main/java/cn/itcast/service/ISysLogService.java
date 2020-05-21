package cn.itcast.service;



import cn.itcast.domain.SysLog;

import java.util.List;

public interface ISysLogService {

    List<SysLog> findAll();

    public void save(SysLog sysLog);
}
