package cn.itcast.service;

import cn.itcast.domain.Advertisement;

import java.util.List;

public interface IAdvertisementService {
    List<Advertisement> findAll();


    List<Advertisement> findAdvertisementByName(String searchText);
}
