
import java.util.*;


public class User {

    private static final int LOWEST_NUMBER = 1;
    private static final int FIRST_CHARACTER = 0;
    private static final int HIGHEST_NUMBER = 6;
    private Scanner inputScanner = new Scanner(System.in);

    public Move getMove(){

        while (!inputScanner.hasNextInt()) {
            System.out.println("To nie jest liczba.");
            inputScanner.next();
        }
        int userInput = inputScanner.nextInt();

        if(userInput >= LOWEST_NUMBER && userInput <= HIGHEST_NUMBER){
            switch(userInput){
                case 1:
                    return Move.PAPER;
                case 2:
                    return Move.ROCK;
                case 3:
                    return Move.SCISSORS;
                case 4:
                    return Move.LIZARD;
                case 5:
                    return Move.SPOCK;
            }
        }
        System.out.println("Nie wybrales liczby z zakresu 1 - 5.\nWybierz jeszcze raz");
        return getMove();
    }

    public void playAgain(){
        System.out.println("Czy chcesz zagrac jeszcze raz? \n Jesli tak wpisz n! \n Jesli chcesz zakonczyc wpisz x");
        inputScanner = new Scanner(System.in);
        char userInput = inputScanner.nextLine().charAt(FIRST_CHARACTER);
        while(userInput!='n' && userInput !='x') {
            playAgain();
        }
        if (userInput == 'n'){
            GameRunner game = new GameRunner();
            game.runGame();
        }
        else{
            System.out.println("Dziekuje za wspolna gre.");
        }
    }

}
