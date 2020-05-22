package cn.itcast.controller;

import cn.itcast.domain.Device;
import cn.itcast.domain.Song;
import cn.itcast.domain.SongList;
import cn.itcast.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private IDeviceService deviceService;

    @RequestMapping("/findAll.do")
    public @ResponseBody List<Device> findAll(){
        return deviceService.findAll();
    }

    @RequestMapping("/saveDevice.do")
    public @ResponseBody void saveDevice(Device device){
        deviceService.saveSong(device);
    }

    @RequestMapping("/delDevice.do")
    public @ResponseBody void delDevice(String id){
        deviceService.delDevice(id);
    }

    @RequestMapping("/findDeviceByName.do")
    public @ResponseBody List<Device> findDeviceByName(String searchText){
        return deviceService.findDeviceByName(searchText);
    }

    @RequestMapping("/addDevice.do")
    public @ResponseBody void addDevice(Device device){
        deviceService.addDevice(device);
    }

    @RequestMapping("/findDeviceById.do")
    public @ResponseBody Device findDeviceById(String id){
        return deviceService.findDeviceById(id);
    }


    @RequestMapping("/editDevice.do")
    public @ResponseBody void editDevice(Device device){
        deviceService.editDevice(device);
    }

    /**
     * 查找当前设备未关联的歌单
     * @param deviceId
     * @return
     */
    @RequestMapping("/findSongListNotIn.do")
    public @ResponseBody List<SongList> findSongListNotIn(String deviceId){
        return deviceService.findSongListNotIn(deviceId);
    }

    @RequestMapping("/addSongList.do")
    public @ResponseBody void addSongList(@RequestParam(value = "songListId",required = true) Integer songListId,
                                          @RequestParam(value = "deviceId",required = true)String deviceId){
        deviceService.addSongList(songListId,deviceId);
    }

    /**
     * 查找当前设备关联的歌单
     * @param deviceId
     * @return
     */
    @RequestMapping("/findSongListIn.do")
    public @ResponseBody List<SongList> findSongListIn(String deviceId){
        return deviceService.findSongListIn(deviceId);
    }

    @RequestMapping("/cancelSongList.do")
    public @ResponseBody void cancelSongList(@RequestParam(value = "songListId",required = true) Integer songListId,
                                             @RequestParam(value = "deviceId",required = true)String deviceId){
        deviceService.cancelSongList(songListId,deviceId);
    }
}
