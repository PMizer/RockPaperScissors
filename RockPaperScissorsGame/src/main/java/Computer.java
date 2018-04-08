import java.util.*;

public class Computer {
    public Move getMove() {
        Move[] moves = Move.values();
        Random random = new Random();
        int index = random.nextInt(moves.length);
        return moves[index];
    }

    public Move getMoveHard(Move playerMove) {
            int win = (Math.random() <= 0.5) ? 0 : 1;
            int temp = (Math.random() <= 0.5) ? 0 : 1;
            int temp1 = (Math.random() <= 0.5) ? 0 : 1;

            switch (playerMove) {
                case ROCK:
                    if(win==1) { // if computer wins
                        return (temp == 1) ? Move.PAPER : Move.SPOCK;
                    }
                    if(temp==1){ // if computer losses
                        return (temp1 == 1) ? Move.SCISSORS : Move.LIZARD;
                    }
                    return Move.ROCK;
                case PAPER:
                    if(win==1) {
                        return (temp == 1) ? Move.SCISSORS : Move.LIZARD;
                    }
                    if(temp==1){
                        return (temp1 == 1) ? Move.SPOCK : Move.ROCK;
                    }
                    return Move.PAPER;
                case SCISSORS:
                    if(win==1) {
                        return (temp == 1) ? Move.ROCK : Move.SPOCK;
                    }
                    if(temp==1){
                        return (temp1 == 1) ? Move.PAPER : Move.LIZARD;
                    }
                    return Move.SCISSORS;
                case LIZARD:
                    if(win==1) {
                        return (temp == 1) ? Move.ROCK : Move.SCISSORS;
                    }
                    if(temp==1){
                        return (temp1 == 1) ? Move.SPOCK : Move.PAPER;
                    }
                    return Move.LIZARD;
                case SPOCK:
                    if(win==1) {
                        return (temp == 1) ? Move.PAPER : Move.LIZARD;
                    }
                    if(temp==1){
                        return (temp1 == 1) ? Move.SCISSORS : Move.ROCK;
                    }
                    return Move.SPOCK;
            }


        return getMoveHard(playerMove);
    }
}
