package com.example.satourismapp;

public class PlaceDetails {
    //Variables.
    public String ID;
    public String Province;
    public String Place;

    //Constructor met all variables.
    public PlaceDetails(String id,String province, String place){
        this.ID = id;
        this.Province = province;
        this.Place = province;
    }

    //Getters.
    public String getID(){
        return ID;
    }

    public String getProvince() {
        return Province;
    }

    public String getPlace() {
        return Place;
    }
}
