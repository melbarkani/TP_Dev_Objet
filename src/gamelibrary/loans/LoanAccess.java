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
    HashMap<String, String> boardGameBorrowed;
    HashMap<String, String> videoGameBorrowed;
    public LoanAccess(GameAccess gAccess, MemberAccess mAccess) {
        this.gAccess = gAccess;
        this.mAccess = mAccess;
        mAccess.setLoanAccess(this);
        gAccess.setLoanAccess(this);
        allLoans = new ArrayList<>();
        boardGameBorrowed = new HashMap<>();
        videoGameBorrowed = new HashMap<>();
    }
    
    /* AJOUT */
    public void addLoans(Loan loan) {
        allLoans.add(loan);
    }
    
    /* A FAIRE */
    public void borrowBoardGame(String member, String game) {
        if (!isBoardGameOnLoan(game)) {
            boardGameBorrowed.put(game, member);
            Loan loan = new Loan(gAccess.getBoardGame(game), mAccess.getMember(member));
            allLoans.add(loan);
        } else {
            System.out.println("Le jeu est déjà emprunté !");
        }
    }
    
    public void borrowVideoGame(String member, String game) {
        if (!isVideoGameOnLoan(game)) {
            boardGameBorrowed.put(game, member);
            Loan loan = new Loan(gAccess.getVideoGame(game), mAccess.getMember(member));
            allLoans.add(loan);
        } else {
            System.out.println("Le jeu est déjà emprunté !");
        }
    }

    /* A corriger */
    public void returnBoardGame(String member, String game) {
        if (isBoardGameOnLoan(game)) {
            boardGameBorrowed.remove(game);
            
        } else {
            System.out.println("Le jeu n'a pas été emprunté");
        }
    }
    
    /* A VERIFIER */
    public boolean isBoardGameOnLoan(String game){
        return boardGameBorrowed.containsKey(game);
    }
    
    public boolean isVideoGameOnLoan(String game) {
        return videoGameBorrowed.containsKey(game);
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
