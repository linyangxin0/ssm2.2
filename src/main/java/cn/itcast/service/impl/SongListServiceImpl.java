package cn.itcast.service.impl;

import cn.itcast.dao.SongListDao;
import cn.itcast.domain.Song;
import cn.itcast.domain.SongList;
import cn.itcast.service.ISongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SongListServiceImpl implements ISongListService {

    @Autowired
    private SongListDao songListDao;


    @Override
    public List<SongList> findAll() {
        return songListDao.findAll();
    }

    @Override
    public List<Song> findSongListsSong(Integer id) {
        return songListDao.findSongListsSong(id);
    }

    @Override
    public void delSongFromSongList(Integer songId, Integer songListId) {
        songListDao.delSongFromSongList(songId,songListId);
    }

    @Override
    public void delSongList(Integer id) {
        songListDao.delSongList(id);
    }

    @Override
    public List<Song> findSongNotIn(Integer id) {
        return songListDao.findSongNotIn(id);
    }

    @Override
    public void addSongToSongList(Integer songId, Integer songListId) {
        songListDao.addSongToSongList(songId,songListId);
    }

    @Override
    public List<Song> findSongListByName(String searchText) {
        return songListDao.findSongListByName(searchText);
    }

    @Override
    public void addSongList(String name) {
        songListDao.addSongList(name);
    }

    @Override
    public void editSongList(Integer id, String name) {
        songListDao.editSongList(id,name);
    }


}
