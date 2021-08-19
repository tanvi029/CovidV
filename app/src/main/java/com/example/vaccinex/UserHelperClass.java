package com.example.vaccinex;

public class UserHelperClass {
    String name, email,age,phonenumber,address,adhaar,gender;

    public UserHelperClass() {

    }

    public UserHelperClass(String name, String email, String age, String phonenumber, String address, String adhaar, String gender) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.phonenumber = phonenumber;
        this.address = address;
        this.adhaar = adhaar;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdhaar() {
        return adhaar;
    }

    public void setAdhaar(String adhaar) {
        this.adhaar = adhaar;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
