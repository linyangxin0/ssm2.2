package cn.itcast.service;

import cn.itcast.domain.Device;

import java.util.List;

public interface IDeviceService {
    List<Device> findAll();

    void saveSong(Device device);

    void delDevice(List<Integer> deviceIds);

    void editDevice(Device device);
}
