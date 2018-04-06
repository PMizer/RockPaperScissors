
import java.util.*;


public class User {
    private Scanner inputScanner;

    public User(){
        inputScanner = new Scanner(System.in);
    }
    public Move getMove(){

        int userInput = inputScanner.nextInt();
        if(userInput > 0 && userInput < 6){
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
        return getMove();
    }

    public void playAgain(){
        System.out.println("Czy chcesz zagrac jeszcze raz? \n Jesli tak wpisz n! \n Jesli chcesz zakonczyc wpisz x");
        inputScanner = new Scanner(System.in);
        char userInput = inputScanner.nextLine().charAt(0);
        while(userInput!='n' && userInput !='x') {
            playAgain();
        }
        if (userInput == 'n'){
            GameRunner game = new GameRunner();
            game.gameRunner();
        }
        else{
            System.out.println("Dziekuje za wspolna gre.");
        }
    }

}
