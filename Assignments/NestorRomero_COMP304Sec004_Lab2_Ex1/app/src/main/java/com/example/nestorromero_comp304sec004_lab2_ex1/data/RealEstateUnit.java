package com.example.nestorromero_comp304sec004_lab2_ex1.data;


import android.graphics.drawable.Drawable;

/**
 * COMP304 - Assignment 2
 * Nestor Romero - 301133331
 *
 * Model class for the app main content
 * This class represents a real estate unit *
 */
public class RealEstateUnit {

    private RealEstateUnitType type = RealEstateUnitType.APARTMENT;
    private String id;
    private String address;
    private double rentPrice;
    private boolean selected;

    public RealEstateUnit(){}

    public RealEstateUnit(RealEstateUnitType type, String id, String address, double rentPrice){
        this.setId(id);
        this.setType(type);
        this.setAddress(address);
        this.setRentPrice(rentPrice);
    }

    public RealEstateUnitType getType() {
        return type;
    }

    public void setType(RealEstateUnitType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(address == null || address.trim().length()==0){
            throw new IllegalArgumentException("Unit address must contain an appropriate value");
        }
        this.address = address;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        if(rentPrice < 0 ){
            throw new IllegalArgumentException("Rent price must be a positive number");
        }
        this.rentPrice = rentPrice;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "RealEstateUnit{" +
                "type=" + type +
                ", id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", rentPrice=" + rentPrice +
                ", selected=" + selected +
                '}';
    }
}



