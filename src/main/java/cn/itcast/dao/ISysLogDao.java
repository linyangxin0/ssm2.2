package cn.itcast.dao;


import cn.itcast.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISysLogDao {

    @Insert("insert into system_log (visit_time,user_id,ip,url,execution_time,method) values(#{visitTime},#{userId},#{ip},#{url},#{executionTime},#{method})")
    public void save(SysLog sysLog);

    @Select("select * from system_log")
    List<SysLog> findAll();
}
