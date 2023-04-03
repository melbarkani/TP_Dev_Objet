package gamelibrary.games;

import gamelibrary.loans.LoanAccess;
import gamelibrary.members.MemberAccess;
import java.util.ArrayList;
import java.util.HashMap;

public class GameAccess {
    HashMap<String, BoardGame> allBoardGames;
    private MemberAccess mAccess;
    private LoanAccess lAccess;
    public GameAccess() {
        allBoardGames = new HashMap<>();
    }
    public void addBoardGame(String name, String publisher, int minPlayers, int maxPlayers, String genre) {
        allBoardGames.put(name, new BoardGame(name, publisher, minPlayers, maxPlayers, genre));
    }
    public void addVideoGame(String name, String platform, String publisher, String genre) {
    }

    public ArrayList<String> getAllBoardGameNames() {
        ArrayList<String> res = new ArrayList<>();
        for (BoardGame bg : allBoardGames.values()) {
            res.add(bg.toString());
        }
        return res;
    }

    public int getMinPlayersFor(String game) {
        return -1;
    }

    public int getMaxPlayersFor(String game) {
        return -1;
    }

    public void setMemberAccess(MemberAccess mAccess) {
        this.mAccess = mAccess;
    }

    public void setLoanAccess(LoanAccess lAccess) {
        this.lAccess = lAccess;
    }
}
