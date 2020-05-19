package cn.itcast.service.impl;

import cn.itcast.dao.AdvertisementDao;
import cn.itcast.domain.Advertisement;
import cn.itcast.domain.Device;
import cn.itcast.service.IAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AdvertisementServiceImpl implements IAdvertisementService {

    @Autowired
    private AdvertisementDao advertisementDao;

    @Override
    public List<Advertisement> findAll() {
        return advertisementDao.findAll();
    }

    @Override
    public List<Advertisement> findAdvertisementByName(String searchText) {
        return advertisementDao.findAdvertisementByName(searchText);
    }

    @Override
    public void addAdvertisement(String context, Date getDate) {
        advertisementDao.addAdvertisement(context,getDate);
    }

    @Override
    public void delAdvertisementById(Integer id) {
        advertisementDao.delAdvertisementById(id);
    }

    @Override
    public List<Device> findDeviceNotIn(Integer id) {
        return advertisementDao.findDeviceNotIn(id);
    }

    @Override
    public void addAdvertisementToDevice(Integer advertisementId, String deviceId) {
        advertisementDao.addAdvertisementToDevice(advertisementId,deviceId);
    }

    @Override
    public Advertisement findAdvertisementById(Integer advertisementId) {
        return advertisementDao.findAdvertisementById(advertisementId);
    }

    @Override
    public void editAdvertisement(Advertisement advertisement) {
        advertisementDao.editAdvertisement(advertisement);
    }


}
