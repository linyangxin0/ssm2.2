package cn.itcast.dao;

import cn.itcast.domain.Device;
import cn.itcast.domain.SongList;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DeviceDao {

    @Select("select * from device")
    List<Device> findAll();

    @Insert("insert into device (id,name,type,status) values (#{id},#{name},#{type},#{status})")
    void saveDevice(Device device);

    @Delete("delete from device where id=#{id}")
    void delDevice(String id);

    @Update("update device set name=#{name},type=#{type},status=#{status} where id=#{id}")
    void editDevice(Device device);

    @Select("select * from device where name like CONCAT('%',#{searchText},'%')")
    List<Device> findDeviceByName(String searchText);


    @Insert("insert into device (id,name,type,status) values (#{id},#{name},#{type},#{status})")
    void addDevice(Device device);

    @Select("select * from device where id=#{id}")
    Device findDeviceById(String id);

    @Select("select * from songlist where id not in (select songlist_id from device_songlist where device_id=#{id})")
    List<SongList> findSongListNotIn(String id);

    @Insert("insert into device_songlist (songlist_id,device_id) values (#{songListId},#{deviceId})")
    void addSongList(@Param("songListId")int songListId,@Param("deviceId") String deviceId);

    @Select("select * from songlist where id in (select songlist_id from device_songlist where device_id=#{deviceId})")
    List<SongList> findSongListIn(String deviceId);

    @Delete("delete from device_songlist where songlist_id=#{songListId} and device_id=#{deviceId}")
    void cancelSongList(@Param("songListId")int songListId,@Param("deviceId") String deviceId);
}
