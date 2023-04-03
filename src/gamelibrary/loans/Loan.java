package gamelibrary.loans;

import gamelibrary.games.BoardGame;
import gamelibrary.games.Game;
import gamelibrary.members.Member;
import java.util.Date;

public class Loan {
    private final Game borrowedGame;
    private final Member borrower;
    private final Date borrowedOn;
    /* AJOUT */
    private BoardGame borrowedBGame;
    Loan(Game game, Member member) {
        borrowedGame = game;
        borrower = member;
        borrowedOn = new Date();
    }
    int getSecondsSinceLoanMade() {
        final long NOW = new Date().getTime();
        final int MILLI = 1000;
        return (int)((NOW - borrowedOn.getTime())/MILLI);
    }
}