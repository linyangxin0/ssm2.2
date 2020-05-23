package cn.itcast.service;

import cn.itcast.domain.Song;
import cn.itcast.domain.SongList;

import java.util.List;

public interface ISongListService {
    List<SongList> findAll();


    List<Song> findSongListsSong(Integer id);

    void delSongFromSongList(Integer songId, Integer songListId);

    void delSongList(Integer id);

    List<Song> findSongNotIn(Integer id);


    void addSongToSongList(Integer songId, Integer songListId);

    List<Song> findSongListByName(String searchText);

    void addSongList(String name);

    void editSongList(Integer id, String name);
}
