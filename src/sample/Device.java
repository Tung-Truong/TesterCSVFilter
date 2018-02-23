package sample;

public class Device {
    //fields
    private String deviceID;
    private String name;

    //contructor
    public Device(String deviceID, String name){
        this.deviceID = deviceID;
        this.name = name;
    }

    //getters

    public String getDeviceID() {
        return deviceID;
    }

    public String getName() {
        return name;
    }

    //setters

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public void setName(String name) {
        this.name = name;
    }
}
