package cn.itcast.dao;


import cn.itcast.domain.Song;
import cn.itcast.domain.SongList;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SongListDao {

    @Select("select * from songlist")
    List<SongList> findAll();

    @Select("select * from song where id in (select song_id from song_songList where songList_id=#{id})")
    List<Song> findSongListsSong(Integer id);

    @Delete("delete from song_songList where song_id=#{songId} and songlist_id=#{songListId}")
    void delSongFromSongList(@Param("songId") Integer songId,@Param("songListId") Integer songListId);

    @Delete("delete from songList where id=#{id}")
    void delSongList(Integer id);

    @Select("select * from song where id not in (select song_id from song_songlist where songlist_id=#{id})")
    List<Song> findSongNotIn(Integer id);

    @Insert("insert into song_songlist (song_id,songlist_id) values (#{songId},#{songListId})")
    void addSongToSongList(@Param("songId") Integer songId,@Param("songListId") Integer songListId);

    @Select("select * from songlist where name like CONCAT('%',#{searchText},'%')")
    List<Song> findSongListByName(String searchText);

    @Insert("insert into songlist (name) values (#{name})")
    void addSongList(String name);
}
