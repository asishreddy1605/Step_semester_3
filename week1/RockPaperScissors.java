import java.util.Random;
import java.util.Scanner;
public class RockPaperScissors {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int N = 5;
        String[] playerMoves = new String[N];
        String[] computerMoves = new String[N];
        String[] results = new String[N];
        String[] moves = {"Rock", "Paper", "Scissors"};
        int wins = 0;
        int losses = 0;
        int draws = 0;
        for (int i = 0; i < N; i++) {
            System.out.println("\nRound " + (i + 1));
            System.out.print("Enter your move (Rock/Paper/Scissors): ");
            playerMoves[i] = sc.next();
            int randomIndex = random.nextInt(3);
            computerMoves[i] = moves[randomIndex];
            results[i] = playRound(playerMoves[i], computerMoves[i]);
            System.out.println("Player: " + playerMoves[i]);
            System.out.println("Computer: " + computerMoves[i]);
            System.out.println("Result: " + results[i]);
            if (results[i].equals("Player Wins")) {
                wins++;
            } 
            else if (results[i].equals("Computer Wins")) {
                losses++;
            } 
            else {
                draws++;
            }
        }
        double winPercentage = (double) wins / N * 100;
        System.out.println("\n========== FINAL SUMMARY ==========");
        System.out.printf("%-8s %-15s %-15s %-15s%n",
                "Round", "Player Move", "Computer Move", "Result");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < N; i++) {
            System.out.printf("%-8d %-15s %-15s %-15s%n",
                    (i + 1),
                    playerMoves[i],
                    computerMoves[i],
                    results[i]);
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("Wins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.printf("Win %%  : %.1f%%%n", winPercentage);
        sc.close();
    }
}