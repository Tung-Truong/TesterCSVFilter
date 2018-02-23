package sample;

import java.util.ArrayList;
import java.util.Set;

public class DeviceFilter {
    //field that holds the testers after filtering the devices
    private ArrayList<Tester> finalTesters = new ArrayList<>();

    //function that takes in a set of devices and filters the testers from the arraylist who have the devices
    public boolean filterDevices(Set<String> devices, ArrayList<Tester> testers) {
        //for loops that sees if the tester has a device in their devices list that matches requested device
        for (Tester person : testers) {
            for (String d : devices) {
                //if there is an all in the devices, then just return all of the testers
                if(d.toLowerCase().equals("all")){
                    finalTesters = testers;
                    return true;
                }
                for (String testerDevice : person.getDevices()) {
                    if (testerDevice.toLowerCase().equals(d.toLowerCase())) {
                        finalTesters.add(person);
                    }
                }
            }
        }
        //no testers that match criteria
        if (finalTesters.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<Tester> getFinalTesters() {
        return finalTesters;
    }
}
