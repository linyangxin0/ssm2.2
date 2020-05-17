package cn.itcast.controller;

import cn.itcast.domain.Song;
import cn.itcast.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private ISongService songService;

    @RequestMapping("/findAll.do")
    public @ResponseBody List<Song> findAll(){
        List<Song> songs = songService.findAll();
        return songs;
    }

    @RequestMapping("/saveSong.do")
    public @ResponseBody void saveSong(@RequestParam(value = "name",required = true) String name,
                                       @RequestParam(value = "info",required = true)String info,
                                       @RequestParam(value = "author",required = true)String author,
                                       @RequestParam(value = "updateTime",required = true)String updateTime,
                                       @RequestParam(value = "status",required = true)Integer status){
//        System.out.println(song);
//        songService.saveSong(song);
//        System.out.println("chengg2");
        System.out.println(name);
    }

    @RequestMapping("/delSong.do")
    public @ResponseBody void delSong(@RequestParam(value="songIds[]") List<Integer> songIds){
        songService.delSongs(songIds);
    }


    @RequestMapping("/editSong.do")
    public @ResponseBody void editSong(Song song){
        songService.editSong(song);
    }


    @RequestMapping("/findSongByName.do")
    public @ResponseBody List<Song> findSongByName(String searchText){
        return songService.findSongByName(searchText);
    }


}
