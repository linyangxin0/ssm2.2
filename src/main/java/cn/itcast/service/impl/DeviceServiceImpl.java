package cn.itcast.service.impl;

import cn.itcast.dao.DeviceDao;
import cn.itcast.domain.Device;
import cn.itcast.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.annotations.Instantiator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeviceServiceImpl implements IDeviceService {

    @Autowired
    private DeviceDao deviceDao;


    @Override
    public List<Device> findAll() {
        return deviceDao.findAll();
    }

    @Override
    public void saveSong(Device device) {
        deviceDao.saveDevice(device);
    }

    @Override
    public void delDevice(List<Integer> deviceIds) {
        for (int id: deviceIds){
            deviceDao.delDevice(id);
        }
    }

    @Override
    public void editDevice(Device device) {
        deviceDao.editDevice(device);
    }
}
