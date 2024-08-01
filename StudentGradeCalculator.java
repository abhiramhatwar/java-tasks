import java.util.Scanner;
import java.util.ArrayList;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> marks = new ArrayList<>();

        System.out.println("Student Grade Calculator");
        System.out.println("------------------------");
        while (true) {
            System.out.print("Enter marks (out of 100) for a subject (-1 to finish): ");
            int mark = scanner.nextInt();
            if (mark == -1) {
                break;
            }
            if (mark < 0 || mark > 100) {
                System.out.println("Invalid marks. Please enter marks between 0 and 100.");
                continue;
            }
            marks.add(mark);
        }

        if (marks.isEmpty()) {
            System.out.println("No marks entered. Exiting program.");
            return;
        }

        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        double averagePercentage = (double) totalMarks / marks.size();

        String grade = calculateGrade(averagePercentage);

        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    public static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
