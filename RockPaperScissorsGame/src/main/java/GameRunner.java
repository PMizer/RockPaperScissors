import java.util.Scanner;

public class GameRunner {

    private User user;
    private Computer computer;
    private int userScore;
    private int computerScore;
    private int numberOfWins;
    private int totalRounds;


    public GameRunner(){
        user = new User();
        computer = new Computer();
        userScore = 0;
        computerScore = 0;
        numberOfWins = 0;


    }

    public void printGameStats(){
        int wins = userScore;
        int losses = computerScore;
        int ties = totalRounds - userScore - computerScore;

        System.out.println("Wygrales "+ wins + ", razy ");
        System.out.println("Przegrales "+ losses + ", razy ");
        System.out.println("Zremisowales "+ ties + ", razy ");
    }

    public void gameRunner() {

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
        while (numberOfWins <= 0);


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

            int compareMoves = userMove.compareMoves(computerMove);
            switch (compareMoves) {
                case 0:
                    System.out.println("Remis.");
                    break;
                case 1:
                    System.out.println(userMove + " pokonuje " + computerMove + ", wygrana!");
                    userScore++;
                    break;
                case -1:
                    System.out.println(userMove + " przegrywa z " + computerMove + ", przegrana");
                    computerScore++;
                    break;
            }
            totalRounds++;
        }
        printGameStats();

        user.playAgain();

    }
}
