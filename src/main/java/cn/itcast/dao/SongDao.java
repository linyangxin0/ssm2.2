package cn.itcast.dao;

import cn.itcast.domain.Song;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SongDao {

    @Select("select * from song")
    List<Song> findAll();

    @Insert("insert into song (name,info,author,update_time,status) values (#{name},#{info},#{author},#{updateTime},#{status})")
    void saveSong(Song song);

    @Delete("delete from song where id=#{id}")
    void delSong(int id);

    @Update("update song set name=#{name},info=#{info},author=#{author},update_time=#{updateTime},status=#{status} where id=#{id}")
    void editSong(Song song);

    @Select("select * from song where name like CONCAT('%',#{searchText},'%')")
    List<Song> findSongByName(String searchText);

    @Select("select * from song where id=#{id}")
    Song findSongById(Integer id);
}
