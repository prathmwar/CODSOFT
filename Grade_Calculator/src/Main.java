import java.util.Scanner;

class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("Enter the number of subjects:");
        int numOfSubj = sc.nextInt();

        System.out.println("Enter marks obtained in each subject (out of 100):");

        int totalMarks = 0;

        for (int i = 1; i <= numOfSubj; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            int marks = sc.nextInt();
            if (marks < 0 || marks > 100) {
                System.out.println("Marks should be between 0 and 100. Please re-enter.");
                i--;
                continue;
            }
            totalMarks += marks;
        }

        double avgPercentage = (double) totalMarks / numOfSubj;

        String grade;

        if (avgPercentage >= 90) {
            grade = "A";
        } else if (avgPercentage >= 80) {
            grade = "B";
        } else if (avgPercentage >= 70) {
            grade = "C";
        } else if (avgPercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + avgPercentage);
        System.out.println("Grade: " + grade);
    }
}