package com.developerdj.toybox.pojo;

import java.io.Serializable;

/**
 * Created by diego on 25/11/17.
 */

public class Order extends Item implements Serializable {

    private int id;
    private int id_warehouse;
    //private Warehouse id_warehouse;
    private int status;
    private String date_delivery;
    private String date_init;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_warehouse() {
        return id_warehouse;
    }

    public void setId_warehouse(int id_warehouse) {
        this.id_warehouse = id_warehouse;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate_delivery() {
        return date_delivery;
    }

    public void setDate_delivery(String date_delivery) {
        this.date_delivery = date_delivery;
    }

    public String getDate_init() {
        return date_init;
    }

    public void setDate_init(String date_init) {
        this.date_init = date_init;
    }
}
