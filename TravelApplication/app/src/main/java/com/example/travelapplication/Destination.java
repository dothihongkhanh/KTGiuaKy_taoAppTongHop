package com.example.travelapplication;

public class Destination {
    private String Name;
    private String Price;
    private String NameProvince;
    private int Picture;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }


    public String getNameProvince() {
        return NameProvince;
    }

    public void setNameProvince(String nameProvince) {
        NameProvince = nameProvince;
    }

    public int getPicture() {
        return Picture;
    }

    public void setPicture(int picture) {
        Picture = picture;
    }

    public Destination(String name, String price, String nameProvince, int picture) {
        Name = name;
        Price = price;
        NameProvince = nameProvince;
        Picture = picture;
    }
}
