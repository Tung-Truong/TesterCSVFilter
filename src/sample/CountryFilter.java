package sample;

import java.util.ArrayList;
import java.util.Set;

public class CountryFilter {
    //field that contains the arraylist of testers after filtering countries
    private ArrayList<Tester> filteredTesters = new ArrayList<>();

    //function that filters an arraylist of testers given a set of country strings
    public boolean filterCountry(Set<String> countries, ArrayList<Tester> testers) {

        //check for specific countries
        for (Tester person : testers) {
            for (String country : countries) {
                //if there is an all string, just include all testers
                if(country.toLowerCase().equals("all")){
                    filteredTesters = testers;
                    return true;
                }
                if (person.getCountry().toLowerCase().equals(country.toLowerCase())) {
                    filteredTesters.add(person);
                }
            }
        }
        //no testers that match criteria
        if (filteredTesters.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    //getter
    public ArrayList<Tester> getFilteredTesters() {
        return filteredTesters;
    }
}
