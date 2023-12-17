import java.util.Random;
import java.util.Scanner;

class Number_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int S = 1;
        int L = 100;
        int maxAttempts = 7;
        int score = 0;

        System.out.println("Welcome to the Number Game!");
        System.out.println("Guess the number between " + S + " and " + L);

        do {
            int target = rand.nextInt(L - S + 1) + S;
            int attempts = 0;
            boolean ques = false;

            System.out.println("New round! You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");

                if (sc.hasNextInt()) {
                    int guess = sc.nextInt();
                    sc.nextLine(); // Consume newline character
                    attempts++;

                    if (guess == target) {
                        System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                        ques = true;
                        score += maxAttempts - attempts + 1;
                        break;
                    } else if (guess < target) {
                        System.out.println("The number is greater than " + guess + ". Try again!");
                    } else {
                        System.out.println("The number is less than " + guess + ". Try again!");
                    }
                } else {
                    System.out.println("Please enter a valid number.");
                    sc.nextLine(); // Clear input buffer
                }
            }

            if (!ques) {
                System.out.println("Sorry! The correct number was: " + target);
            }

            System.out.println("Your current score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
        } while (sc.next().equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing! Your final score: " + score);
    }
}
