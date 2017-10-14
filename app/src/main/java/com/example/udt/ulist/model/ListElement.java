package com.example.udt.ulist.model;


import static android.R.attr.id;

public class ListElement {

    private int id;
    private String elementName;

    public ListElement(int id, String elementName) {
        this.id = id;
        this.elementName = elementName;
    }

    public ListElement(String elementName) {
        this.elementName = elementName;
    }

    public ListElement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

}
