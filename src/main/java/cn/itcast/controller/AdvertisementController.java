package cn.itcast.controller;

import cn.itcast.domain.Advertisement;
import cn.itcast.domain.Song;
import cn.itcast.service.IAdvertisementService;
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
}
