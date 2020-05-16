package cn.itcast.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Song {
    private int id;
    private String name;
    private String info;
    private String author;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updateTime;
    private int status;

    private List<SongList> songListList;

    public List<SongList> getSongListList() {
        return songListList;
    }

    public void setSongListList(List<SongList> songListList) {
        this.songListList = songListList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
