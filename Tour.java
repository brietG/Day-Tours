import java.sql.Date;

public class Tour {
    private String location;
    private double duration;
    private int pricePerPerson;
    private String type;
    private Date dates;
    private String time;

    // Constructor
    public Tour(String location, double duration, int pricePerPerson, String type, Date dates, String time) {
        this.location = location;
        this.duration = duration;
        this.pricePerPerson = pricePerPerson;
        this.type = type;
        this.dates = dates;
        this.time = time;
    }

    // Getterar & Setterar
    public String getLocation() {
        return location;
    }

    public double getDuration() {
        return duration;
    }

    public int getPricePerPerson() {
        return pricePerPerson;
    }

    public String getType() {
        return type;
    }

    public Date getDates() {
        return dates;
    }

    public String getTime() {
        return time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setPricePerPerson(int pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public void setTime(String time) {
        this.time = time;
    }

    // Method / Aðferð
    public void getInfo() {
    }
}
