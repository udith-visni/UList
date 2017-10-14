package com.example.udt.ulist.model;

import static android.R.attr.id;

/**
 * Created by UDT on 10/14/2017.
 */

public class MyLists {

    int id;
    String listName;

    public MyLists() {
    }

    public MyLists(String listName) {
        this.listName = listName;
    }

    public MyLists(int id, String listName) {
        this.id = id;
        this.listName = listName;
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


}
