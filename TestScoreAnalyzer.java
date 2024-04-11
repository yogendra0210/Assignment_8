package Assignment8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestScoreAnalyzer {
    public static void main(String[] args) {
        List<Integer> scores = new ArrayList<>();
        scores.add(80);
        scores.add(90);
        scores.add(75);
        scores.add(85);
        scores.add(95);

        double averageScore = calculateAverage(scores);

        double medianScore = calculateMedian(scores);

        int aboveAverage = 0, atAverage = 0, belowAverage = 0;
        for (int score : scores) {
            if (score > averageScore) {
                aboveAverage++;
            } else if (score == averageScore) {
                atAverage++;
            } else {
                belowAverage++;
            }
        }

        System.out.println("Number of students who scored above the average: " + aboveAverage + ", Median score: " + medianScore + " (Group: Above Average)");
        System.out.println("Number of students who scored at the average: " + atAverage + ", Median score: " + medianScore + " (Group: At Average)");
        System.out.println("Number of students who scored below the average: " + belowAverage + ", Median score: " + medianScore + " (Group: Below Average)");
    }

    private static double calculateAverage(List<Integer> scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.size();
    }

    private static double calculateMedian(List<Integer> scores) {
        Collections.sort(scores);
        int size = scores.size();
        if (size % 2 == 0) {
            return (scores.get(size / 2 - 1) + scores.get(size / 2)) / 2.0;
        } else {
            return scores.get(size / 2);
        }
    }
}