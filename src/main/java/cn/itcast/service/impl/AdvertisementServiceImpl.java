package cn.itcast.service.impl;

import cn.itcast.dao.AdvertisementDao;
import cn.itcast.domain.Advertisement;
import cn.itcast.service.IAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


}
