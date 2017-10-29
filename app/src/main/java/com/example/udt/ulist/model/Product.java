package com.example.udt.ulist.model;

/**
 * Created by UDT on 10/29/2017.
 */

public class Product {

    private String title;
    private String oldPrice;
    private String specialPrice;
    private String promo;
    private String src;


    public Product(String title, String oldPrice, String specialPrice, String promo, String src) {
        this.title = title;
        this.oldPrice = oldPrice;
        this.specialPrice = specialPrice;
        this.promo = promo;
        this.src = src;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(String specialPrice) {
        this.specialPrice = specialPrice;
    }

    public String getPromo() {
        return promo;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
