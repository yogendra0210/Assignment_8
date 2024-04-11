package Assignment8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Project {
    private String studentName;
    private int completionTime; // in days

    public Project(String studentName, int completionTime) {
        this.studentName = studentName;
        this.completionTime = completionTime;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getCompletionTime() {
        return completionTime;
    }
}

public class ProjectManager {
    public static void main(String[] args) {
        List<Project> projects = new ArrayList<>();
        projects.add(new Project("Alice", 10));
        projects.add(new Project("Bob", 5));
        projects.add(new Project("Charlie", 7));
        projects.add(new Project("David", 12));

        Map<String, Integer> onTime = new HashMap<>();
        Map<String, Integer> late = new HashMap<>();
        Map<String, Integer> early = new HashMap<>();
        Map<String, Integer> totalCompletionTime = new HashMap<>();

        for (Project project : projects) {
            String studentName = project.getStudentName();
            int completionTime = project.getCompletionTime();
            totalCompletionTime.put(studentName, totalCompletionTime.getOrDefault(studentName, 0) + completionTime);

            if (completionTime <= 7) { // assuming 7 days is the deadline
                onTime.put(studentName, onTime.getOrDefault(studentName, 0) + 1);
            } else if (completionTime > 7) {
                late.put(studentName, late.getOrDefault(studentName, 0) + 1);
            } else {
                early.put(studentName, early.getOrDefault(studentName, 0) + 1);
            }
        }

        System.out.println("Projects completed on time:");
        printStats(onTime);
        System.out.println("\nProjects completed late:");
        printStats(late);
        System.out.println("\nProjects completed early:");
        printStats(early);
        System.out.println("\nAverage completion time per student:");
        printAverageCompletionTime(totalCompletionTime, projects.size());
    }

    private static void printStats(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void printAverageCompletionTime(Map<String, Integer> totalCompletionTime, int numProjects) {
        for (Map.Entry<String, Integer> entry : totalCompletionTime.entrySet()) {
            String studentName = entry.getKey();
            int totalTime = entry.getValue();
            double averageTime = totalTime / (double) numProjects;
            System.out.println(studentName + ": " + averageTime + " days");
        }
    }
}