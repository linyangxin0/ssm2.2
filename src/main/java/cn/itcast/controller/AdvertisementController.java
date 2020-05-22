package cn.itcast.controller;

import cn.itcast.domain.Advertisement;
import cn.itcast.domain.Device;
import cn.itcast.domain.Song;
import cn.itcast.service.IAdvertisementService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/advertisement")
public class AdvertisementController {

    @Autowired
    private IAdvertisementService advertisementService;


    @RequestMapping("/findAll.do")
    public @ResponseBody List<Advertisement> findAll(){
        return advertisementService.findAll();
    }


    /**
     * 使用模糊查询查找广告
     * @param searchText 查询关键词
     * @return
     */
    @RequestMapping("/findAdvertisementByName.do")
    public @ResponseBody List<Advertisement> findAdvertisementByName(String searchText){
        return advertisementService.findAdvertisementByName(searchText);
    }


    @RequestMapping("/addAdvertisement.do")
    public @ResponseBody void addAdvertisement(String context, String getDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date time = sdf.parse(getDate);
        advertisementService.addAdvertisement(context,time);
    }



    @RequestMapping("/delAdvertisementById.do")
    public @ResponseBody void delAdvertisementById(Integer id){
        advertisementService.delAdvertisementById(id);
    }


    /**
     * 查找这个广告未关联的设备
     * @param id 广告id
     * @return
     */
    @RequestMapping("/findDeviceNotIn.do")
    public @ResponseBody List<Device> findDeviceNotIn(Integer id){
       return advertisementService.findDeviceNotIn(id);
    }


    @RequestMapping("/addAdvertisementToDevice.do")
    public @ResponseBody void addAdvertisementToDevice(Integer advertisementId, String deviceId){
        advertisementService.addAdvertisementToDevice(advertisementId,deviceId);
    }


    @RequestMapping("/findAdvertisementById.do")
    public @ResponseBody Advertisement findAdvertisementById(Integer id){
        return advertisementService.findAdvertisementById(id);
    }


    @RequestMapping("/editAdvertisement.do")
    public @ResponseBody void editAdvertisement(Integer id,String context,String getDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date time = sdf.parse(getDate);

        Advertisement advertisement=new Advertisement();
        advertisement.setId(id);
        advertisement.setContext(context);
        advertisement.setGetDate(time);

        advertisementService.editAdvertisement(advertisement);
    }

    /**
     * 查找这个广告已关联的设备
     * @param id 广告id
     * @return
     */
    @RequestMapping("/findDeviceInById.do")
    public @ResponseBody List<Device> findDeviceInById(Integer id){
        return advertisementService.findDeviceInById(id);
    }


    @RequestMapping("/delAdvertisementFromDevice.do")
    public @ResponseBody void delAdvertisementFromDevice(Integer advertisementId, String deviceId){
        advertisementService.delAdvertisementFromDevice(advertisementId,deviceId);
    }

}
