package cn.itcast.dao;


import cn.itcast.domain.Advertisement;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdvertisementDao {

    @Select("select * from advertisement")
    List<Advertisement> findAll();

    @Select("select * from advertisement where context like CONCAT('%',#{searchText},'%')")
    List<Advertisement> findAdvertisementByName(String searchText);
}
