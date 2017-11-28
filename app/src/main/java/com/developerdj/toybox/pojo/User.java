package com.developerdj.toybox.pojo;

import java.io.Serializable;

/**
 * Created by diego on 25/11/17.
 */

public class User extends Item implements Serializable {

    private int id;
    private String name;
    private String last_name;
    private String email;
    private String cellphone;
    private String password;
    private String picture_url;
    private int type_user;
    private String date_init;

    public User() {
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

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public int getType_user() {
        return type_user;
    }

    public void setType_user(int type_user) {
        this.type_user = type_user;
    }

    public String getDate_init() {
        return date_init;
    }

    public void setDate_init(String date_init) {
        this.date_init = date_init;
    }
}
