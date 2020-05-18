package cn.itcast.controller;


import cn.itcast.domain.Song;
import cn.itcast.domain.SongList;
import cn.itcast.service.ISongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/songList")
public class SongListController {

    @Autowired
    private ISongListService songListService;

    @RequestMapping("/findAll.do")
    public @ResponseBody List<SongList> findAll(){
        return songListService.findAll();
    }

    @RequestMapping("/findSongListsSong.do")
    public @ResponseBody List<Song> findSongListsSong(@RequestParam(value = "id",required = true) Integer id){
        return songListService.findSongListsSong(id);
    }

    @RequestMapping("/delSongFromSongList.do")
    public @ResponseBody void delSongFromSongList(@RequestParam(value = "songId",required = true) Integer songId,
                                                  @RequestParam(value = "songListId",required = true) Integer songListId){
        songListService.delSongFromSongList(songId,songListId);
    }

    @RequestMapping("/delSongList.do")
    public @ResponseBody void delSongList(@RequestParam(value = "id",required = true) Integer id){
        songListService.delSongList(id);
    }


    @RequestMapping("/findSongNotIn.do")
    public @ResponseBody List<Song> findSongNotIn(@RequestParam(value = "id",required = true) Integer id){
        return songListService.findSongNotIn(id);
    }



    @RequestMapping("/addSongToSongList.do")
    public @ResponseBody void addSongToSongList(@RequestParam(value = "songId",required = true) Integer songId,
                                                  @RequestParam(value = "songListId",required = true) Integer songListId){
        songListService.addSongToSongList(songId,songListId);
    }

    @RequestMapping("/findSongListByName.do")
    public @ResponseBody List<Song> findSongListByName(@RequestParam(value = "searchText",required = true) String searchText){
        return songListService.findSongListByName(searchText);
    }

    @RequestMapping("/addSongList.do")
    public @ResponseBody void addSongList(@RequestParam(value = "name",required = true) String name){
        songListService.addSongList(name);
    }




}
