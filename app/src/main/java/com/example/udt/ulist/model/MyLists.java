package com.example.udt.ulist.model;

import static android.R.attr.id;

/**
 * Created by UDT on 10/14/2017.
 */

public class MyLists {

    int id;
    String listName;
    int total;


    public MyLists() {
    }

    public MyLists(String listName) {
        this.listName = listName;
    }

    public MyLists(int id, String listName, int total) {
        this.id = id;
        this.listName = listName;
        this.total = total;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
