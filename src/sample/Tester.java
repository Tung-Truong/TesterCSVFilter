package sample;

import java.util.ArrayList;

public class Tester {
    //fields
    private String testerID;
    private String firstName;
    private String lastName;
    private String country;
    private String lastLogin;
    private ArrayList<String> devices;

    //Constructor
    public Tester(String testerID, String firstName, String lastName, String country, String  lastLogin,ArrayList<String> devices){
        this.testerID = testerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.lastLogin = lastLogin;
        this.devices = devices;
    }

    //getters

    public String getTesterID() {
        return testerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public String  getLastLogin() {
        return lastLogin;
    }

    public ArrayList<String> getDevices() {
        return devices;
    }
    //setters


    public void setTesterID(String testerID) {
        this.testerID = testerID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLastLogin(String  lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setDevices(ArrayList<String> devices) {
        this.devices = devices;
    }
}

