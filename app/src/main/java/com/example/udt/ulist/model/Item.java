package com.example.udt.ulist.model;

/**
 * Created by UDT on 10/15/2017.
 */

public class Item {
    private int itemId;
    private String ItemName;

    public Item() {
    }

    public Item(String itemName) {
        ItemName = itemName;
    }


    public Item(int itemId, String itemName) {
        this.itemId = itemId;
        ItemName = itemName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }
}
