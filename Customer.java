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

    // Getterar & Setterar
    public int getKennitala() {
        return kennitala;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public void setKennitala(int kennitala) {
        this.kennitala = kennitala;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    // Methods / Aðferðir

    public void seeBooking(){

    }

    // TODO - Laga þetta fall 
    public Bookings[] getBookings(){
        return null;
    }
}
