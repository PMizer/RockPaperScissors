import java.util.Scanner;

public class GameRunner {

    private static final int ZERO_GAMES_LEFT = 0;
    private User user = new User();
    private Computer computer = new Computer();
    private int userScore = 0;
    private int computerScore = 0;
    private int numberOfWins = 0;
    private int totalRounds;

    public void runGame() {

        System.out.println("Do ilu wygranych rund chcialbys zagrac?");
        Scanner inputScanner = new Scanner(System.in);
        do {
            System.out.println("Pamietaj, ze liczba wygranych musi byc dodatnia oraz calkowita.");
            while (!inputScanner.hasNextInt()) {
                System.out.println("To nie jest liczba.");
                inputScanner.next();
            }
            numberOfWins = inputScanner.nextInt();
        }
        while (numberOfWins <= ZERO_GAMES_LEFT);

        while(userScore < numberOfWins && computerScore < numberOfWins) {
            System.out.println("Zadeklaruj swoj wybor: " +
                    "\n 1 - Papier " +
                    "\n 2 - Kamien " +
                    "\n 3 - Nozyce " +
                    "\n 4 - Jaszczurka " +
                    "\n 5 - Spock");

            Move userMove = user.getMove();
            Move computerMove = computer.getMove();
            System.out.println("Zagrales: " + userMove);
            System.out.println("Komputer wybral: " + computerMove);

            Winner winner = userMove.compareMoves(computerMove);

            switch (winner) {
                case DRAW:
                    System.out.println("Remis.");
                    break;
                case PLAYER_WINNS:
                    System.out.println(userMove + " pokonuje " + computerMove + ", wygrana!");
                    userScore++;
                    break;
                case COMPUTER_WINNS:
                    System.out.println(userMove + " przegrywa z " + computerMove + ", przegrana");
                    computerScore++;
                    break;
            }
            totalRounds++;
        }
        printGameStats();

        user.playAgain();

    }

    private void printGameStats(){
        int wins = userScore;
        int losses = computerScore;
        int ties = totalRounds - userScore - computerScore;

        System.out.println("Wygrales "+ wins + ", razy ");
        System.out.println("Przegrales "+ losses + ", razy ");
        System.out.println("Zremisowales "+ ties + ", razy ");
    }

}
