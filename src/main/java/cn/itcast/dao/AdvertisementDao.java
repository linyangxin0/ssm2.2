package cn.itcast.dao;


import cn.itcast.domain.Advertisement;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
}
