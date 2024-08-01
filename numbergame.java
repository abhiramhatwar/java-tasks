import java.util.Random;
import java.util.Scanner;

public class numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int roundsWon = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        boolean playAgain = true;
        while (playAgain) {
            int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            System.out.println("\nI'm thinking of a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");
            
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts!");
                    guessedCorrectly = true;
                    roundsWon++;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
                
                if (attempts == maxAttempts && !guessedCorrectly) {
                    System.out.println("Sorry, you've run out of attempts. The number was " + numberToGuess + ".");
                }
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes") || playAgainResponse.equals("y");
        }
        
        System.out.println("\nGame Over!");
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("Thank you for playing!");
        
        scanner.close();
    }
}
