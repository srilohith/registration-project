package whtson.test.db.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

    @JsonProperty
    private String personnumber;

    @JsonProperty
    private String forename;

    @JsonProperty
    private String lastname;


    public Employee(String personnumber, String forename, String lastname) {
        this.personnumber = personnumber;
        this.forename = forename;
        this.lastname = lastname;
    }

    public Employee() {
    }

    public String getPersonnumber() {
        return personnumber;
    }

    public void setPersonnumber(String personnumber) {
        this.personnumber = personnumber;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
