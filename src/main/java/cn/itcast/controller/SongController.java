package cn.itcast.controller;

import cn.itcast.domain.Song;
import cn.itcast.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                                       @RequestParam(value = "status",required = true)Integer status) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date time = sdf.parse(updateTime);
        Song song = new Song();
        song.setName(name);
        song.setInfo(info);
        song.setAuthor(author);
        song.setUpdateTime(time);
        song.setStatus(status);

        songService.saveSong(song);

    }

    @RequestMapping("/delASong.do")
    public @ResponseBody void delASong(@RequestParam(value="id") Integer songId){
        songService.delASong(songId);
    }


    @RequestMapping("/delSong.do")
    public @ResponseBody void delSong(@RequestParam(value="songIds[]") List<Integer> songIds){
        songService.delSongs(songIds);
    }


    @RequestMapping("/editSong.do")
    public @ResponseBody void editSong(@RequestParam(value = "id",required = true) Integer id,
                                       @RequestParam(value = "name",required = true) String name,
                                       @RequestParam(value = "info",required = true)String info,
                                       @RequestParam(value = "author",required = true)String author,
                                       @RequestParam(value = "updateTime",required = true)String updateTime,
                                       @RequestParam(value = "status",required = true)Integer status) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date time = sdf.parse(updateTime);
        Song song = new Song();
        song.setId(id);
        song.setName(name);
        song.setInfo(info);
        song.setAuthor(author);
        song.setUpdateTime(time);
        song.setStatus(status);


        songService.editSong(song);
    }


    @RequestMapping("/findSongByName.do")
    public @ResponseBody List<Song> findSongByName(String searchText){
        return songService.findSongByName(searchText);
    }

    @RequestMapping("/findSongById.do")
    public @ResponseBody Song findSongById(@RequestParam(value="id") Integer id){
        return songService.findSongById(id);
    }




}
