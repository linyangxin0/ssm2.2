package cn.itcast.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Advertisement {
    private int id;
    private String context;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date getDate;
    private List<Device> device;

    public List<Device> getDevice() {
        return device;
    }

    public void setDevice(List<Device> device) {
        this.device = device;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getGetDate() {
        return getDate;
    }

    public void setGetDate(Date getDate) {
        this.getDate = getDate;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "id=" + id +
                ", context='" + context + '\'' +
                ", getDate=" + getDate +
                '}';
    }
}
