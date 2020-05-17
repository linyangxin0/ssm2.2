package cn.itcast.service;

import cn.itcast.domain.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void saveSong(Song song);

    void delSongs(List<Integer> songIds);

    void editSong(Song song);

    List<Song> findSongByName(String searchText);

    void delASong(Integer songId);


    Song findSongById(Integer id);
}
