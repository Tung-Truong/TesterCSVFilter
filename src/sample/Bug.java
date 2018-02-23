package sample;

public class Bug {
    //fields
    private String bugID;
    private String deviceID;
    private String testerID;

    //constructor
    public Bug(String bugID, String deviceID, String testerID){
        this.bugID = bugID;
        this.deviceID = deviceID;
        this.testerID = testerID;
    }

    //getters

    public String getBugID() {
        return bugID;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public String getTesterID() {
        return testerID;
    }

    //setters

    public void setBugID(String bugID) {
        this.bugID = bugID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public void setTesterID(String testerID) {
        this.testerID = testerID;
    }
}