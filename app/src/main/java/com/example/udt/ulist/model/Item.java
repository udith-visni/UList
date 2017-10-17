package com.example.udt.ulist.model;

/**
 * Created by UDT on 10/15/2017.
 */

public class Item {
    private int _id;
    private String _ItemName;

    public Item() {
    }

    public Item(String _ItemName) {
        this._ItemName = _ItemName;
    }

    public Item(int _id, String _ItemName) {
        this._id = _id;
        this._ItemName = _ItemName;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_ItemName() {
        return _ItemName;
    }

    public void set_ItemName(String _ItemName) {
        this._ItemName = _ItemName;
    }
}
