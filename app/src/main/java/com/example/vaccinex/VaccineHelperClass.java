package com.example.vaccinex;

public class VaccineHelperClass {

    String vaccine,location,timing,number;
    public VaccineHelperClass() {

    }


    public VaccineHelperClass(String vaccine, String location,  String timing, String number) {
        this.vaccine = vaccine;
        this.location = location;
        this.number=number;
        this.timing = timing;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }
}
