package com.developerdj.toybox.pojo;

import java.io.Serializable;

/**
 * Created by diego on 25/11/17.
 */

public class Carrera implements Serializable {

    private int id;
    private String name;
    private String detail;
    private int id_area;

    public Carrera() {
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    @Override
    public String toString() {
        return "nombre "+this.getName();
    }
}
