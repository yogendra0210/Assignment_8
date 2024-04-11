package Assignment8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BookReview {
    private String title;
    private int rating;

    public BookReview(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}

public class BookReviewAnalyzer {
    public static void main(String[] args) {
        List<BookReview> reviews = new ArrayList<>();
        reviews.add(new BookReview("Book1", 4));
        reviews.add(new BookReview("Book2", 8));
        reviews.add(new BookReview("Book3", 6));
        reviews.add(new BookReview("Book4", 2));
        reviews.add(new BookReview("Book5", 10));
        reviews.add(new BookReview("Book6", 3));

        int[] ratingRanges = { 5, 10 };
        Map<String, Integer> booksByRatingRange = countBooksByRatingRange(reviews, ratingRanges);

        Map<String, Integer> reviewSentiments = countReviewSentiments(reviews);

        System.out.println("Number of books reviewed within specified rating ranges:");
        for (Map.Entry<String, Integer> entry : booksByRatingRange.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nCount of books with positive, neutral, and negative reviews:");
        for (Map.Entry<String, Integer> entry : reviewSentiments.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static Map<String, Integer> countBooksByRatingRange(List<BookReview> reviews, int[] ratingRanges) {
        Map<String, Integer> countByRange = new HashMap<>();
        for (BookReview review : reviews) {
            int rating = review.getRating();
            for (int i = 0; i < ratingRanges.length; i++) {
                if (rating <= ratingRanges[i]) {
                    countByRange.put("1-" + ratingRanges[i], countByRange.getOrDefault("1-" + ratingRanges[i], 0) + 1);
                    break;
                }
            }
        }
        return countByRange;
    }

    private static Map<String, Integer> countReviewSentiments(List<BookReview> reviews) {
        Map<String, Integer> sentimentCount = new HashMap<>();
        for (BookReview review : reviews) {
            int rating = review.getRating();
            if (rating >= 8) {
                sentimentCount.put("Positive", sentimentCount.getOrDefault("Positive", 0) + 1);
            } else if (rating >= 5 && rating < 8) {
                sentimentCount.put("Neutral", sentimentCount.getOrDefault("Neutral", 0) + 1);
            } else {
                sentimentCount.put("Negative", sentimentCount.getOrDefault("Negative", 0) + 1);
            }
        }
        return sentimentCount;
    }
}