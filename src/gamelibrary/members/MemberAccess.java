package gamelibrary.members;

import gamelibrary.games.GameAccess;
import gamelibrary.loans.LoanAccess;
import java.util.ArrayList;
import java.util.HashMap;

public class MemberAccess {
    private GameAccess gAccess;
    private LoanAccess lAccess;
    /* AJOUT */
    ArrayList<String> allMembers;
    public MemberAccess(GameAccess gAccess) {
        this.gAccess = gAccess;
        gAccess.setMemberAccess(this);
        allMembers = new ArrayList<>();
    }
    public void setLoanAccess(LoanAccess lAccess) {
        this.lAccess = lAccess;
    }
    
    public void addMember(String name) {
        /* AJOUT */
        allMembers.add(name);
    }
    
    /* AJOUT */
    public ArrayList<String> getAllMemberNames() {
        ArrayList<String> list = new ArrayList<>();
        for (String s : allMembers) {
            list.add(s);
        }
        return list;
    }

    public ArrayList<String> getBoardGameLoansForMemberAsStrings(String member) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
