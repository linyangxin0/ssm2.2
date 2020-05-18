package cn.itcast.service;

import cn.itcast.domain.Device;
import cn.itcast.domain.SongList;

import java.util.List;

public interface IDeviceService {
    List<Device> findAll();

    void saveSong(Device device);

    void delDevice(String deviceIds);

    void editDevice(Device device);

    List<Device> findDeviceByName(String searchText);

    void addDevice(Device device);

    Device findDeviceById(String id);

    List<SongList> findSongListNotIn(String id);

    void addSongList(int songListId, String deviceId);

    List<SongList> findSongListIn(String deviceId);

    void cancelSongList(int songListId, String deviceId);
}
