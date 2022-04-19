/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Bike {
    String motoID , model;
    String year;
    String condition;
    float price;
    int quantity;
    String warranty;
    String brandID;

    public Bike(String motoID, String model, String year, String condition, float price, int quantity, String warranty, String brandID) {
        this.motoID = motoID;
        this.model = model;
        this.year = year;
        this.condition = condition;
        this.price = price;
        this.quantity = quantity;
        this.warranty = warranty;
        this.brandID = brandID;
    }

    public String getMotoID() {
        return motoID;
    }

    public void setMotoID(String motoID) {
        this.motoID = motoID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    @Override
    public String toString() {
        return "Bike{" + "motoID=" + motoID + ", model=" + model + ", year=" + year + ", condition=" + condition + ", price=" + price + ", quantity=" + quantity + ", warranty=" + warranty + ", brandID=" + brandID + '}';
    }
    
}
