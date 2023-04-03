package gamelibrary.loans;

import gamelibrary.games.GameAccess;
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
        ArrayList<String> loanAsStrings = new ArrayList<>();
        for (Loan loans : allLoans) {
            String loan = loans.toString();
            loanAsStrings.add(loan);
        }
        return loanAsStrings;
    }
    
}
