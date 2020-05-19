package cn.itcast.dao;


import cn.itcast.domain.Advertisement;
import cn.itcast.domain.Device;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface AdvertisementDao {

    @Select("select * from advertisement")
    List<Advertisement> findAll();

    @Select("select * from advertisement where context like CONCAT('%',#{searchText},'%')")
    List<Advertisement> findAdvertisementByName(String searchText);

    @Insert("insert into advertisement (context,get_date) values (#{context},#{getDate})")
    void addAdvertisement(@Param("context") String context, @Param("getDate") Date getDate);

    @Delete("delete from advertisement where id=#{id}")
    void delAdvertisementById(Integer id);

    @Select("select * from device where id not in (select device_id from device_advertisement where advertisement_id=#{id})")
    List<Device> findDeviceNotIn(Integer id);

    @Insert("insert into device_advertisement (advertisement_id,device_id) values (#{advertisementId},#{deviceId})")
    void addAdvertisementToDevice(@Param("advertisementId")Integer advertisementId,@Param("deviceId") String deviceId);

    @Select("select * from advertisement where id=#{advertisementId}")
    Advertisement findAdvertisementById(Integer advertisementId);

    @Update("update advertisement set context=#{context},get_date=#{getDate} where id=#{id}")
    void editAdvertisement(Advertisement advertisement);
}
