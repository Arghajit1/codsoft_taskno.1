
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        boolean playAgain = true;
        int attempts = 0;
        int maxAttempts = 4; 
        int numberToGuess = random.nextInt(100) + 1;      
        boolean guessedCorrectly = false;

        System.out.println(" Welcome to Guess the Number Game!!!!!!");

        while (playAgain) {          

            System.out.println("\nI have picked a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts. Good luck!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println(" Correct!!!!!  You guessed it in " + attempts + " attempts.");
                    guessedCorrectly = true;
                  
                    int roundScore = (maxAttempts - attempts + 1) * 10;
                    totalScore += roundScore;
                    System.out.println("You earned " + roundScore + " points this round.");
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You ran out of attempts. The number was " + numberToGuess + ".");
            }

            System.out.println("Your total score so far: " + totalScore);

          
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\n Game Over! Your final score: " + totalScore);
        scanner.close();
    }
}
