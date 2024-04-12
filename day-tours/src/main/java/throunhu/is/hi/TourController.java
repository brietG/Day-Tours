package throunhu.is.hi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import throunhu.is.hi.Tour;

public class TourController {
    private TourDatabase tourDatabase;

    public TourController(TourDatabase tourDatabase) {
        this.tourDatabase = tourDatabase;
    }

    public void addTour(Tour tour) {
        tourDatabase.addTour(tour);
    }

    public Tour[] searchTours(String query) {
        return tourDatabase.searchTours(query);
    }

    public void printTourInfo(int id) {
        Tour tour = tourDatabase.getTourByDetails(String.valueOf(id)); // Use the tour ID as detail
        if (tour != null) {
            tour.getInfo();
        } else {
            System.out.println("Tour not found");
        }
    }

    public List<Tour> seeAllTours() {
        return tourDatabase.getAllTours();
    }

    //á að tengjast við decrement í tourDatabase og kalla á hann til að minnka sæti í limitspots
    //svo fjöldi limitspots minnki um fjölda sæta sem bókuð eru
    public void decrementAvailableSpots(Booking booking) {
        if (tourDatabase != null) {
            tourDatabase.decrementAvailableSpace(booking.getTour().getTourID(), booking.getNumSpots());
        }
    }

}
