import java.sql.Date;

public class Tour {
    private int tourID;
    private String type;
    private String location;
    private int pricePerPerson;
    // private double duration;
    private Date tourDate;
    private String tourTime;
    private boolean spaceAvailable;

    // Constructor
    public Tour(int tourID, String location, int pricePerPerson, String type, Date tourDate, String tourTime, boolean spaceAvailable) {
        this.tourID = tourID;
        this.location = location;
        // this.duration = duration;
        this.pricePerPerson = pricePerPerson;
        this.type = type;
        this.tourDate = tourDate;
        this.tourTime = tourTime;
        this.spaceAvailable = spaceAvailable;
    }

    // Getterar & Setterar
    public int getTourID() {
        return tourID;
    }
    
    public String getLocation() {
        return location;
    }

    /* 
    public double getDuration() {
        return duration;
    }
    */

    public int getPricePerPerson() {
        return pricePerPerson;
    }

    public String getType() {
        return type;
    }

    public Date getTourDate() {
        return tourDate;
    }

    public String getTourTime() {
        return tourTime;
    }

    public boolean getSpaceAvailable() {
        return spaceAvailable;
    }

    public void setTourID(int tourID) {
        this.tourID = tourID;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    /*
    public void setDuration(double duration) {
        this.duration = duration;
    }
    */
    public void setPricePerPerson(int pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTourDate(Date tourDate) {
        this.tourDate = tourDate;
    }

    public void setTourTime(String tourTime) {
        this.tourTime = tourTime;
    }

    public void setSpaceAvailable(boolean spaceAvailable) {
        this.spaceAvailable = spaceAvailable;
    }

    // Method / Aðferð
    public void getInfo() {
    }
}
