package sample;

public class Result {
    //fields
    private String firstName;
    private String lastName;
    private String bugs;

    public Result(String firstName, String lastName,String bugs){
        this.firstName = firstName;
        this.lastName = lastName;
        this.bugs = bugs;
    }

    //getters

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBugs() {
        return bugs;
    }

    //setters

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBugs(String bugs) {
        this.bugs = bugs;
    }
}
