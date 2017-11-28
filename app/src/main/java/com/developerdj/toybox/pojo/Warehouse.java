package com.developerdj.toybox.pojo;

import java.io.Serializable;

/**
 * Created by diego on 25/11/17.
 */

public class Warehouse extends Item implements Serializable {
    private String id;
    private String name;
    private String address;
    private String gps;
    private int max_capacity;
    private int min_capacity;
    private String date_init;

    public Warehouse() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public int getMax_capacity() {
        return max_capacity;
    }

    public void setMax_capacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }

    public int getMin_capacity() {
        return min_capacity;
    }

    public void setMin_capacity(int min_capacity) {
        this.min_capacity = min_capacity;
    }

    public String getDate_init() {
        return date_init;
    }

    public void setDate_init(String date_init) {
        this.date_init = date_init;
    }
}
