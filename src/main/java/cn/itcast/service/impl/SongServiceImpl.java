package cn.itcast.service.impl;

import cn.itcast.dao.SongDao;
import cn.itcast.domain.Song;
import cn.itcast.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SongServiceImpl implements ISongService {

    @Autowired
    private SongDao songDao;

    @Override
    public List<Song> findAll() {
        return songDao.findAll();
    }

    @Override
    public void saveSong(Song song) {
        songDao.saveSong(song);
    }

    @Override
    public void delSongs(List<Integer> songIds) {
        for (int id:songIds)
        {
            songDao.delSong(id);
        }
    }

    @Override
    public void editSong(Song song) {
        songDao.editSong(song);
    }

    @Override
    public List<Song> findSongByName(String searchText) {
        return songDao.findSongByName(searchText);
    }

    @Override
    public void delASong(Integer songId) {
        songDao.delSong(songId);
    }

    @Override
    public Song findSongById(Integer id) {
        return songDao.findSongById(id);
    }


}
