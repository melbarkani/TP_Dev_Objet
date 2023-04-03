package gamelibrary.loans;

import gamelibrary.games.BoardGame;
import gamelibrary.games.GameAccess;
import gamelibrary.members.Member;
import gamelibrary.members.MemberAccess;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoanAccess {
    private GameAccess gAccess;
    private MemberAccess mAccess;
    /* AJOUT */
    ArrayList<Loan> allLoans;
    public LoanAccess(GameAccess gAccess, MemberAccess mAccess) {
        this.gAccess = gAccess;
        this.mAccess = mAccess;
        mAccess.setLoanAccess(this);
        gAccess.setLoanAccess(this);
        allLoans = new ArrayList<>();
    }
    
    /* AJOUT */
    public void addLoans(Loan loan) {
        allLoans.add(loan);
    }
    
    /* A FAIRE */
    public void borrowBoardGame(String member, String game) {
        Member m = mAccess.getMember(member);
        BoardGame bg = gAccess.getBoardGame(game);
        Loan loan = new Loan(bg, m);
        allLoans.add(loan);
        /* AJOUTER UNE CONDITION SI LE JEU EST DEJA PRETE (if (!isBoardGameOnLoan)) */
    }

    public void returnBoardGame(String member, String game) {
    }
    
    public boolean isBoardGameOnLoan(String game){
        
        return false;
    }
    public boolean isVideoGameOnLoan(String game) {
        return false;
    }
    
    /* AJOUT */
    public ArrayList<String> getAllLoansAsStrings() {
        ArrayList<String> loansAsStrings = new ArrayList<>();
        for (Loan loans : allLoans) {
            String loan = loans.toString();
            loansAsStrings.add(loan);
        }
        return loansAsStrings;
    }
    
}
