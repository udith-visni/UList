package com.example.udt.ulist.model;


public class ListItem {

    private int itemId;
    private String itemName;
    private int price;
    private int promoPrice;
    private int qty ;
    private int itemTotal;

    public ListItem() {
    }

    public ListItem(String itemName) {
        this.itemName = itemName;
    }

    public ListItem(String itemName, int qty) {
        this.itemName = itemName;
        this.qty = qty;
    }


    public ListItem(int itemId, String itemName, int price, int promoPrice, int qty, int itemTotal) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.promoPrice = promoPrice;

        this.qty = qty;
        this.itemTotal = itemTotal;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(int promoPrice) {
        this.promoPrice = promoPrice;
    }


    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(int itemTotal) {
        this.itemTotal = itemTotal;
    }
}
