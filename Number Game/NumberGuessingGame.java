import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int score = 0;
        int rounds = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            rounds++;
            int attempts = 0;
            int randomNumber = random.nextInt(100) + 1; // generate a random number between 1 and 100
            boolean gameOver = false;

            while (!gameOver) {
                attempts++;
                System.out.print("Enter your guess (1-100): ");
                int guess = scanner.nextInt();

                if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    gameOver = true;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += 10 - attempts; // update score based on attempts taken
                }

                if (attempts >= 10) {
                    gameOver = true;
                    System.out.println("Game over! The number was " + randomNumber + ".");
                }
            }

            System.out.print("Play again? (y/n): ");
            String response = scanner.next();

            if (!response.equalsIgnoreCase("y")) {
                break;
            }
        }

        System.out.println("Final score: " + score + " in " + rounds + " rounds.");
    }
}