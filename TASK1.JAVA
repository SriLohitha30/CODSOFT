import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int score = 0;
        int numberOfRounds = 0;

        while (true) {
            numberOfRounds++;
            int generatedNumber = random.nextInt(100) + 1;
            int attemptsLeft = 5;

            System.out.println("Welcome to the Number Guessing Game! (round " + numberOfRounds + ")");

            while (attemptsLeft > 0) {
                System.out.println("Enter your guess between 1 and 100: ");
                int userGuess = scanner.nextInt();

                if (userGuess < generatedNumber) {
                    System.out.println("Your guess is too low. You have " + attemptsLeft + " attempts left.");
                } else if (userGuess > generatedNumber) {
                    System.out.println("Your guess is too high. You have " + attemptsLeft + " attempts left.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + (5 - attemptsLeft) + " attempts.");
                    score += (5 - attemptsLeft);
                    break;
                }

                attemptsLeft--;
            }

            System.out.println("Do you want to play again? (yes/no)");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        double averageScore = (double) score / numberOfRounds;
        System.out.println("Your score is " + score + " based on " + numberOfRounds + " rounds. Your average score is " + averageScore + ".");
    }
}
