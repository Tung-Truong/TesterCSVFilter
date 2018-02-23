package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Controller {

    //various elements on the UI
    @FXML
    private Button confirm;

    @FXML
    private TextField devicesInput;

    @FXML
    private TextField countriesInput;

    @FXML
    private Label TestersList;


    //handles the action when mouse is clicked and filters to get the correct testers
    @FXML
    void findTesters(MouseEvent event) {
        //declaring objects
        fileRead fileRead1 = new fileRead();
        CountryFilter countryFilter1 = new CountryFilter();
        DeviceFilter deviceFilter1 = new DeviceFilter();
        BugFilter bugFilter1 = new BugFilter();

        //file reads
        fileRead1.fileRead("bugs.csv", "bug");
        fileRead1.fileRead("devices.csv", "device");
        fileRead1.fileRead("tester_device.csv", "testerDevices");
        fileRead1.fileRead("testers.csv", "tester");

        //getting the countries input text, removes spaces, and splits by the comma
        String countriesText = countriesInput.getText();
        String [] countriesSplit = countriesText.split(",");
        Set<String> Countries = new HashSet<>();
        for (String s: countriesSplit) {
            String a = s.replaceAll("\\s+","");
            Countries.add(a);
        }

        //getting the devices input text, removes spaces, and splits by the comma
        String devicesText = devicesInput.getText();
        String [] devicesSplit = devicesText.split(",");
        Set<String> Devices = new HashSet<>();
        for (String s: devicesSplit) {
            String a = s.replaceAll("\\s+","");
            Devices.add(a);
        }

        //filters the testers by requested countries then requested devices
        countryFilter1.filterCountry(Countries, fileRead1.getTesterArrayList());
        deviceFilter1.filterDevices(Devices, countryFilter1.getFilteredTesters());
        bugFilter1.filterBugs(fileRead1.getBugArrayList(), deviceFilter1.getFinalTesters());

        //if the filters result in no bugs being added which means there are no testers that match criteria
        if(bugFilter1.getResults().size() == 0){
            TestersList.setText("No Testers Listed for Criteria");
        }
        else {
            //builds a msg to display on UI
            StringBuilder msg = new StringBuilder();
            for (Result r : bugFilter1.getResults()) {
                msg.append(r.getFirstName() + " " + r.getLastName() + " " + r.getBugs() + "\n");
            }
            TestersList.setText(msg.toString());
        }
    }
}
