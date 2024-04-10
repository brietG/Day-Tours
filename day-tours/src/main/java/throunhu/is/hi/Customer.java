package throunhu.is.hi;

import throunhu.is.hi.Booking;


public class Customer {
    private int kennitala;
    private String name;
    private String email;
    private int phone;

    // Constructor
    public Customer(int kennitala, String name, String email, int phone) {
        this.kennitala = kennitala;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Getters & Setters
    public int getKennitala() {
        return kennitala;
    }

    public void setKennitala(int kennitala) {
        this.kennitala = kennitala;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    // Methods
    public void seeBooking(){
        //þarf að gera e'ð hérna ??
    }

    public Booking[] getBookings(){
        // AI sagði mér að gera þetta veit ekki afhverju 
        return null; // Placeholder, replace with actual logic
    }
}
