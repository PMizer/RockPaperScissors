import java.util.Scanner;

public class GameRunner {

    private User user;
    private Computer computer;
    private int userScore;
    private int computerScore;
    private int numberOfWins;
    private int totalRounds;
    private int gameMode;
    private static int gameOn;


    public GameRunner(){
        user = new User();
        computer = new Computer();
        userScore = 0;
        computerScore = 0;
        numberOfWins = 0;
        gameMode = 0;
        gameOn = 0;


    }

    public static void GameOff() {
       gameOn = 1 ;
    }

    public int difficultySetting(){
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Czy chcialbys sprobowac nieuczciwy tryb? Komputer ma 50% szansy na wygrana.\n0 - Nie\n1 - Tak");
        while (!inputScanner.hasNextInt()) {
            System.out.println("To nie jest liczba.");
            inputScanner.next();
        }
        gameMode = inputScanner.nextInt();
        if(gameMode != 0 && gameMode != 1) {
            return difficultySetting();
        }
        return gameMode;

    }

    public void printGameStats(){
        int wins = userScore;
        int losses = computerScore;
        int ties = totalRounds - userScore - computerScore;

        double winPercentage = (double)wins / totalRounds*100;
        double lossesPercentage = (double)losses / totalRounds*100;
        double tiesPercentage = (double)ties  / totalRounds*100;


        System.out.println("Zagrana ilosc rund: " + totalRounds);
        System.out.println("Wygrales "+ wins + ", razy " + String.format("%.2f", winPercentage)+"% wygranych");
        System.out.println("Przegrales "+ losses + ", razy "+ String.format("%.2f", lossesPercentage)+"% przegranych");
        System.out.println("Zremisowales "+ ties + ", razy "+ String.format("%.2f", tiesPercentage)+"% remisow");

    }

    public void gameRunner() {
        while(gameOn == 0) {
            System.out.println("Witam w grze Papier, Kamien, Nozyce, Spock!");

            Scanner inputScanner = new Scanner(System.in);

            difficultySetting();

            System.out.println("Do ilu wygranych rund chcialbys zagrac?");

            do {
                System.out.println("Pamietaj, ze liczba wygranych musi byc dodatnia oraz calkowita.");
                while (!inputScanner.hasNextInt()) {
                    System.out.println("To nie jest liczba.");
                    inputScanner.next();
                }
                numberOfWins = inputScanner.nextInt();
            }
            while (numberOfWins <= 0);


            while (userScore < numberOfWins && computerScore < numberOfWins) {
                System.out.println("Zadeklaruj swoj wybor: " +
                        "\n 1 - Papier " +
                        "\n 2 - Kamien " +
                        "\n 3 - Nozyce " +
                        "\n 4 - Jaszczurka " +
                        "\n 5 - Spock");


                Move userMove = user.getMove();
                Move computerMove = gameMode == 0 ? computer.getMove() : computer.getMoveHard(userMove);
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
}
