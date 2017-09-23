package com.example.udt.ulist.model;

/**
 * Created by Ravi Tamada on 21/02/17.
 * www.androidhive.info
 */

public class MainListItem {
    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getBoughtItem() {
        return boughtItem;
    }

    public void setBoughtItem(String boughtItem) {
        this.boughtItem = boughtItem;
    }

    public String getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(String totalItem) {
        this.totalItem = totalItem;
    }

    private String listName;
    private String boughtItem;
    private String totalItem;

    public MainListItem(String listName, String boughtItem, String totalItem) {
        this.listName = listName;
        this.boughtItem = boughtItem;
        this.totalItem = totalItem;
    }









}
