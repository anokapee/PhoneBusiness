package com.dynamicdevz.phonebusiness.model.data;

public class Phone {
    private String manufacturer;
    private String model;
    private double price;
    private int phoneID;

    public Phone(int phoneID, String manufacturer, String model, double price) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.phoneID = phoneID;
    }

    public Phone(String manufacturer, String model, double price) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
    }

    public int getPhoneID() {
        return phoneID;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }
}


//Test Comment