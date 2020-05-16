package cn.itcast.controller;

import cn.itcast.domain.Device;
import cn.itcast.domain.Song;
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
        List<Device> devices = deviceService.findAll();
        return devices;
    }

    @RequestMapping("/saveDevice.do")
    public @ResponseBody void saveDevice(Device device){
        deviceService.saveSong(device);
    }

    @RequestMapping("/delDevice.do")
    public @ResponseBody void delDevice(@RequestParam(value="deviceIds[]") List<Integer> deviceIds){
        deviceService.delDevice(deviceIds);
    }


    @RequestMapping("/editDevice.do")
    public @ResponseBody void editDevice(Device device){
        deviceService.editDevice(device);
    }
}
