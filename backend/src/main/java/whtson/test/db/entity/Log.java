package whtson.test.db.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Log {

    @JsonProperty
    private String personnumber;

    @JsonProperty
    private String visitorname;

    @JsonProperty
    private String hostID;

    @JsonProperty
    private String entrytime;

    @JsonProperty
    private String exittime;


    public Log(String personnumber, String hostID, String entrytime, String exittime, String visitorname) {
        this.personnumber = personnumber;
        this.hostID = hostID;
        this.entrytime = entrytime;
        this.exittime = exittime;
        this.visitorname = visitorname;

    }

    public Log() {
    }

    public String getVisitorname() {
        return visitorname;
    }

    public void setVisitorname(String visitorname) {
        this.visitorname = visitorname;
    }

    public String getPersonnumber() {
        return personnumber;
    }

    public void setPersonnumber(String personnumber) {
        this.personnumber = personnumber;
    }

    public String getHostID() {
        return hostID;
    }

    public void setHostID(String hostID) {
        this.hostID = hostID;
    }

    public String getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(String entrytime) {
        this.entrytime = entrytime;
    }

    public String getExittime() {
        return exittime;
    }

    public void setExittime(String exittime) {
        this.exittime = exittime;
    }

}
