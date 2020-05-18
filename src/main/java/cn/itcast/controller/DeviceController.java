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


//    @RequestMapping("/editDevice.do")
//    public @ResponseBody void editDevice(Device device){
//        deviceService.editDevice(device);
//    }


    @RequestMapping("/findDeviceByName.do")
    public @ResponseBody List<Device> findDeviceByName(String searchText){
        return deviceService.findDeviceByName(searchText);
    }

    @RequestMapping("/addDevice.do")
    public @ResponseBody void addDevice(@RequestParam(value = "addId",required = true) String addId,
                                       @RequestParam(value = "addName",required = true)String addName,
                                       @RequestParam(value = "addType",required = true)Integer addType,
                                       @RequestParam(value = "addStatus",required = true)Integer addStatus){

        Device device = new Device();
        device.setId(addId);
        device.setName(addName);
        device.setType(addType);
        device.setStatus(addStatus);

        deviceService.addDevice(device);
    }

    @RequestMapping("/findDeviceById.do")
    public @ResponseBody Device findDeviceById(String id){
        return deviceService.findDeviceById(id);
    }


    @RequestMapping("/editDevice.do")
    public @ResponseBody void editDevice(@RequestParam(value = "addId",required = true) String addId,
                                        @RequestParam(value = "addName",required = true)String addName,
                                        @RequestParam(value = "addType",required = true)Integer addType,
                                        @RequestParam(value = "addStatus",required = true)Integer addStatus){

        Device device = new Device();
        device.setId(addId);
        device.setName(addName);
        device.setType(addType);
        device.setStatus(addStatus);

        deviceService.editDevice(device);
    }


    @RequestMapping("/findSongListNotIn.do")
    public @ResponseBody List<SongList> findSongListNotIn(String deviceId){
        return deviceService.findSongListNotIn(deviceId);
    }

    @RequestMapping("/addSongList.do")
    public @ResponseBody void addSongList(@RequestParam(value = "songListId",required = true) int songListId,
                                          @RequestParam(value = "deviceId",required = true)String deviceId){
        deviceService.addSongList(songListId,deviceId);
    }

    @RequestMapping("/findSongListIn.do")
    public @ResponseBody List<SongList> findSongListIn(String deviceId){
        return deviceService.findSongListIn(deviceId);
    }

    @RequestMapping("/cancelSongList.do")
    public @ResponseBody void cancelSongList(@RequestParam(value = "songListId",required = true) int songListId,
                                          @RequestParam(value = "deviceId",required = true)String deviceId){
        deviceService.cancelSongList(songListId,deviceId);
    }
}
