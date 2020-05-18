package cn.itcast.service.impl;

import cn.itcast.dao.DeviceDao;
import cn.itcast.domain.Device;
import cn.itcast.domain.SongList;
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
    public void delDevice(String deviceIds) {
        deviceDao.delDevice(deviceIds);
    }

    @Override
    public void editDevice(Device device) {
        deviceDao.editDevice(device);
    }

    @Override
    public List<Device> findDeviceByName(String searchText) {
        return deviceDao.findDeviceByName(searchText);
    }

    @Override
    public void addDevice(Device device) {
        deviceDao.addDevice(device);
    }

    @Override
    public Device findDeviceById(String id) {
        return deviceDao.findDeviceById(id);
    }

    @Override
    public List<SongList> findSongListNotIn(String id) {
        return deviceDao.findSongListNotIn(id);
    }

    @Override
    public void addSongList(int songListId, String deviceId) {
        deviceDao.addSongList(songListId,deviceId);
    }

    @Override
    public List<SongList> findSongListIn(String deviceId) {
        return deviceDao.findSongListIn(deviceId);
    }

    @Override
    public void cancelSongList(int songListId, String deviceId) {
        deviceDao.cancelSongList(songListId,deviceId);
    }
}
