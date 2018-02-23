package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BugFilter {
    //field which holds the unsortedResults, this is never used outside this class
    private HashMap<Tester,Integer> unsortedResults = new HashMap<>();

    //field that holds the results after adding all the bugs to the tester who fixed them
    private ArrayList<Result> results = new ArrayList<>();

    //funciton that links the testers and the bugs they tested
    public boolean filterBugs(ArrayList<Bug> bugArrayList, ArrayList<Tester> testerArrayList) {
        //filter for bugs for each tester
        ArrayList<Result> checkList = new ArrayList<>();
        for (Tester tester: testerArrayList) {
            for (Bug b : bugArrayList) {
                if (b.getTesterID().equals(tester.getTesterID())) {
                    addResult(tester);
                }
            }
        }
        //no testers that match criteria
        if (unsortedResults.size() == 0) {
            System.out.println("No testers listed");
            return false;
        } else {
            convertResults(unsortedResults);
            sortList();
            return true;
        }
    }

    //helper function that sorts the hashmap
    private void convertResults(HashMap<Tester,Integer> hashMap){
        ArrayList<Map.Entry<Tester, Integer>> array = new ArrayList<>();
        array.addAll(hashMap.entrySet());

        // Loop over ArrayList of Entry elements.
        for (Map.Entry<Tester,Integer> entry : array) {
            // Use each ArrayList element.
            Tester key = entry.getKey();
            Integer value = entry.getValue();
            Result newResult = new Result(key.getFirstName(),key.getLastName(),String.valueOf(value));
            results.add(newResult);
        }
    }

    //helper that sorts the list
    private void sortList(){
        Collections.sort(results,
                (o1, o2) -> Integer.valueOf(o1.getBugs()).compareTo(Integer.valueOf(o2.getBugs())));
    }

    //helper function that adds results to the hashmap
    private void addResult(Tester tester) {
        unsortedResults.putIfAbsent(tester,0);
        int i = unsortedResults.get(tester);
        i++;
        unsortedResults.remove(tester);
        unsortedResults.put(tester,i);
    }

    public ArrayList<Result> getResults() {
        return results;
    }
}
