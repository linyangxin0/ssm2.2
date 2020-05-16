package cn.itcast.dao;

import cn.itcast.domain.Device;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DeviceDao {

    @Select("select * from device")
    List<Device> findAll();

    @Insert("insert into device (id,name,type,status) values (#{id},#{name},#{type},#{status})")
    void saveDevice(Device device);

    @Delete("delete from device where id=#{id}")
    void delDevice(int id);

    @Update("update device set name=#{name},type=#{type},status=#{status} where id=#{id}")
    void editDevice(Device device);
}
