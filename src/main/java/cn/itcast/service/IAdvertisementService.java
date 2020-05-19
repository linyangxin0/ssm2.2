package cn.itcast.service;

import cn.itcast.domain.Advertisement;

import java.util.Date;
import java.util.List;

public interface IAdvertisementService {
    List<Advertisement> findAll();


    List<Advertisement> findAdvertisementByName(String searchText);

    void addAdvertisement(String context, Date getDate);

    void delAdvertisementById(Integer id);
}
