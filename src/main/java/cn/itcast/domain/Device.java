package cn.itcast.domain;

import java.util.List;

public class Device {
    private String id;
    private String name;
    private int type;
    private int status;
    private List<Advertisement> advertisement;
    private List<SongList> songListList;

    public List<SongList> getSongListList() {
        return songListList;
    }

    public void setSongListList(List<SongList> songListList) {
        this.songListList = songListList;
    }

    public List<Advertisement> getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(List<Advertisement> advertisement) {
        this.advertisement = advertisement;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
