package cn.itcast.service;

import cn.itcast.domain.Advertisement;
import cn.itcast.domain.Device;

import java.util.Date;
import java.util.List;

public interface IAdvertisementService {
    List<Advertisement> findAll();


    List<Advertisement> findAdvertisementByName(String searchText);

    void addAdvertisement(String context, Date getDate);

    void delAdvertisementById(Integer id);


    List<Device> findDeviceNotIn(Integer id);

    void addAdvertisementToDevice(Integer advertisementId, String deviceId);


    Advertisement findAdvertisementById(Integer advertisementId);

    void editAdvertisement(Advertisement advertisement);
}
