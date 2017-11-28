package com.developerdj.toybox.pojo;

import java.io.Serializable;

/**
 * Created by diego on 25/11/17.
 */

public class Store extends Item implements Serializable {

    private int id;
    private String name;
    private String nit;
    private String address;
    private String gps;
    private int type_store;
    private String date_init;

    public Store() {

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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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

    public int getType_store() {
        return type_store;
    }

    public void setType_store(int type_store) {
        this.type_store = type_store;
    }

    public String getDate_init() {
        return date_init;
    }

    public void setDate_init(String date_init) {
        this.date_init = date_init;
    }
}
