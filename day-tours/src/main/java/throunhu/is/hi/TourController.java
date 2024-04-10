package throunhu.is.hi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TourController {
    private TourDatabase tourDatabase = new TourDatabase();

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

    public List<Tour> getAllTours() {
        return tourDatabase.getAllTours();
    }

}
