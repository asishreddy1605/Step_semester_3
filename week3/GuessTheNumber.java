import java.util.Scanner;

public class GuessTheNumber {

    static void guessTheNumber(int secretNumber, int maxTries, int[] guesses) {

        int tries = 0;
        boolean guessed = false;

        while (tries < maxTries && tries < guesses.length) {

            int guess = guesses[tries];
            tries++;

            if (guess > secretNumber) {
                System.out.println("Too high");
            }
            else if (guess < secretNumber) {
                System.out.println("Too low");
            }
            else {
                System.out.println("Correct! You guessed it");
                guessed = true;
                break;
            }
        }

        if (!guessed) {
            System.out.println("Out of tries — the number was " + secretNumber);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter secret number: ");
        int secretNumber = sc.nextInt();

        System.out.print("Enter maximum tries: ");
        int maxTries = sc.nextInt();

        System.out.print("Enter number of guesses: ");
        int n = sc.nextInt();

        int[] guesses = new int[n];

        System.out.println("Enter guesses:");

        for (int i = 0; i < n; i++) {
            guesses[i] = sc.nextInt();
        }

        guessTheNumber(secretNumber, maxTries, guesses);

        sc.close();
    }
}