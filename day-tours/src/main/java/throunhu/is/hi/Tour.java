package throunhu.is.hi;

import java.sql.*;

public class Tour {
    private int tourID;
    private String name;
    private String type;
    private String location;
    private int pricePerPerson;
    // private double duration;
    private Date tourDate;
    private Time tourTime;
    private int limitSpots;
    private boolean spaceAvailable;

    // Constructor
    public Tour(int tourID, String name, String location, int pricePerPerson, String type, Date tourDate, Time tourTime, int limitSpots, boolean spaceAvailable) {
        this.tourID = tourID;
        this.name = name;
        this.location = location;
        // this.duration = duration;
        this.pricePerPerson = pricePerPerson;
        this.type = type;
        this.tourDate = tourDate;
        this.tourTime = tourTime;
        this.limitSpots = limitSpots;
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

    public Time getTourTime() {
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

    public void setTourTime(Time tourTime) {
        this.tourTime = tourTime;
    }

    public void setSpaceAvailable(boolean spaceAvailable) {
        this.spaceAvailable = spaceAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLimitSpots() {
        return limitSpots;
    }

    public void setLimitSpots(int limitSpots) {
        this.limitSpots = limitSpots;
    }

    public Tour getTour(){
        return this;
    }


    // Method / Aðferð
    public void getInfo() {
        System.out.println("Tour ID: " + tourID);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        // System.out.println("Duration: " + duration);
        System.out.println("Price per person: " + pricePerPerson);
        System.out.println("Type: " + type);
        System.out.println("Date: " + tourDate);
        System.out.println("Time: " + tourTime);
        System.out.println("Limit spots: " + limitSpots);
        if (spaceAvailable) {
            System.out.println("Space available" + limitSpots);
        } else {
            System.out.println("Fully booked");
        }
    }

    

}