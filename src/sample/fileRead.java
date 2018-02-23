package sample;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;

public class fileRead {
    private ArrayList<Bug> bugArrayList = new ArrayList<>();
    private ArrayList<Device> deviceArrayList = new ArrayList<>();
    private ArrayList<Tester> testerArrayList = new ArrayList<>();
    private ArrayList<String[]> testerDeviceList = new ArrayList<>();

    //getters
    public ArrayList<Bug> getBugArrayList() {
        return bugArrayList;
    }

    public ArrayList<Device> getDeviceArrayList() {
        return deviceArrayList;
    }

    public ArrayList<Tester> getTesterArrayList() {
        return testerArrayList;
    }

    /*csv takes a generic file to read, and the type of data
    State machine that just changes how the data is sorted
     */
    public void fileRead(String fileName, String dataType) {
        CSVReader csvReader = null;
        try {
            /**
             * Reading the CSV File
             * Delimiter is comma
             * Start reading from line 1
             */
            csvReader = new CSVReader(new FileReader(fileName), ',', '"', 1);
            String[] file = null;
            switch (dataType) {
                case "bug":
                    while ((file = csvReader.readNext()) != null) {
                        Bug newBug = new Bug(file[0], file[1], file[2]);
                        bugArrayList.add(newBug);
                    }
                    break;
                case "device":
                    while ((file = csvReader.readNext()) != null) {
                        Device newDevice = new Device(file[0], file[1]);
                        deviceArrayList.add(newDevice);
                    }
                    break;
                case "testerDevices":
                    while ((file = csvReader.readNext()) != null) {
                        String[] strings = {file[0],file[1]};
                        testerDeviceList.add(strings);
                    }
                    break;
                case "tester":
                    while ((file = csvReader.readNext()) != null) {
                        Tester newTester = new Tester(file[0], file[1], file[2], file[3], file[4], new ArrayList<String>());
                        testerArrayList.add(newTester);
                    }
                    //for loop that adds the correct devices to each tester's devices list
                    for (Tester t:testerArrayList) {
                        ArrayList<String> testerDevices = t.getDevices();
                        for (String[] stringArray: testerDeviceList) {
                            if (stringArray[0].equals(t.getTesterID())) {
                                testerDevices.add(deviceString(stringArray[1]));
                            }
                        }
                        t.setDevices(testerDevices);
                    }
                    break;
                default:
                    break;
            }

        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            try {
                //closing the reader
                csvReader.close();
            } catch (Exception ee) {
                ee.printStackTrace();
            }

        }
    }
    //converts from deviceID into String
    private String deviceString(String id){
        switch(id) {
            case "1":
                return "iPhone4";
            case "2":
                return "iPhone4s";
            case "3":
                return "iPhone5";
            case "4":
                return "GalaxyS3";
            case "5":
                return "GalaxyS4";
            case "6":
                return "Nexus4";
            case "7":
                return "DroidRazor";
            case "8":
                return "DroidDNA";
            case "9":
                return "HTCOne";
            case "10":
                return "iPhone3";
            default:
                return "false";
        }
    }
}
