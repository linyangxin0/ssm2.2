package cn.itcast.controller;

import cn.itcast.domain.Song;
import cn.itcast.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public @ResponseBody void saveSong(Song song){
        songService.saveSong(song);
        System.out.println("chengg");
    }

    @RequestMapping("/delSong.do")
    public @ResponseBody void delSong(@RequestParam(value="songIds[]") List<Integer> songIds){
        songService.delSongs(songIds);
    }


    @RequestMapping("/editSong.do")
    public @ResponseBody void editSong(Song song){
        songService.editSong(song);
    }


    @RequestMapping("/search.do")
    public @ResponseBody List<Song> search(String searchText){
        return songService.search(searchText);
    }


}
