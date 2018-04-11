public enum Move {
    ROCK, PAPER, SCISSORS, LIZARD, SPOCK;

    public Winner compareMoves(Move otherMove) {

        if (this == otherMove)
            return Winner.DRAW;

        switch (this) {
            case ROCK:
                return ((otherMove == SCISSORS || otherMove == LIZARD) ? Winner.PLAYER_WINNS : Winner.COMPUTER_WINNS);
            case PAPER:
                return ((otherMove == ROCK || otherMove == SPOCK) ? Winner.PLAYER_WINNS : Winner.COMPUTER_WINNS);
            case SCISSORS:
                return ((otherMove == PAPER || otherMove == LIZARD) ? Winner.PLAYER_WINNS : Winner.COMPUTER_WINNS);
            case LIZARD:
                return ((otherMove == SPOCK || otherMove == PAPER) ? Winner.PLAYER_WINNS : Winner.COMPUTER_WINNS);
            case SPOCK:
                return ((otherMove == SCISSORS || otherMove == ROCK) ? Winner.PLAYER_WINNS : Winner.COMPUTER_WINNS);
        }

        throw new CustomException();
    }
}