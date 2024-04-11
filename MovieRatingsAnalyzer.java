package Assignment8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Movie {
    private String title;
    private String rating;
    private double ratingValue;

    public Movie(String title, String rating, double ratingValue) {
        this.title = title;
        this.rating = rating;
        this.ratingValue = ratingValue;
    }

    public String getRating() {
        return rating;
    }

    public double getRatingValue() {
        return ratingValue;
    }
}

public class MovieRatingsAnalyzer {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Movie1", "PG", 3.5));
        movies.add(new Movie("Movie2", "PG-13", 4.2));
        movies.add(new Movie("Movie3", "R", 4.8));
        movies.add(new Movie("Movie4", "PG", 3.9));
        movies.add(new Movie("Movie5", "R", 4.1));
        movies.add(new Movie("Movie6", "PG-13", 4.5));

        Map<String, Integer> movieCounts = new HashMap<>();
        Map<String, Double> totalRatings = new HashMap<>();

        for (Movie movie : movies) {
            String rating = movie.getRating();
            double ratingValue = movie.getRatingValue();

            movieCounts.put(rating, movieCounts.getOrDefault(rating, 0) + 1);
            totalRatings.put(rating, totalRatings.getOrDefault(rating, 0.0) + ratingValue);
        }

        System.out.println("Number of movies rated in each category:");
        for (Map.Entry<String, Integer> entry : movieCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " movies");
        }

        System.out.println("\nAverage rating for each category:");
        for (Map.Entry<String, Double> entry : totalRatings.entrySet()) {
            String rating = entry.getKey();
            double totalRating = entry.getValue();
            int count = movieCounts.getOrDefault(rating, 0);
            double averageRating = count == 0 ? 0 : totalRating / count;
            System.out.println(rating + ": " + averageRating);
        }
    }
}