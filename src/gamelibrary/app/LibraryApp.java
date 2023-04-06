package gamelibrary.app;

import gamelibrary.games.GameAccess;
import gamelibrary.loans.LoanAccess;
import gamelibrary.members.MemberAccess;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {

    public static final int MAX_PLAYERS = 20;
    private final GameAccess gAccess;
    private final MemberAccess mAccess;
    private final LoanAccess lAccess;
    private final Scanner scan;
    private final ArrayList<String> menuItems;
    

    LibraryApp() {
        gAccess = new GameAccess();
        mAccess = new MemberAccess(gAccess);
        lAccess = new LoanAccess(gAccess, mAccess);
        scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        menuItems = new ArrayList<>();
        menuItems.add("Quit");
        menuItems.add("List all games in the library");
        menuItems.add("Add new board game");
        menuItems.add("Add new video game");
        menuItems.add("Add new member");
        menuItems.add("Borrow board game");
        menuItems.add("Borrow video game");
        menuItems.add("Check all loans");
        menuItems.add("Search for board game by number of players");
        menuItems.add("Search for video game by platform");
        menuItems.add("Search for game by genre");
        menuItems.add("Return board game");
        menuItems.add("Return video game");
    }

    void addBoardGame(String name, String publisher, int minPlayers, int maxPlayers, String genre) {
        gAccess.addBoardGame(name, publisher, minPlayers, maxPlayers, genre);
    }

    void addVideoGame(String name, String platform, String publisher, String genre) {
        gAccess.addVideoGame(name, platform, publisher, genre);
    }

    void addMembers(String[] names) {
        for (String name : names) {
            mAccess.addMember(name);
        }
    }

    void run() {
        boolean quit = false;
        do {
            displayMenu();
            int choice = ARR_userNumericInput(0, menuItems.size() - 1, "Choose an action");
            quit = performAction(choice);
        } while (!quit);
    }

    private void displayMenu() {
        System.out.println("What do you want to do?");
        displayList(menuItems);
    }

    private void displayList(ArrayList<String> list) {
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); ++i) {
                System.out.println("" + i + "." + list.get(i));
            }
        } else {
            System.out.println("Giving up: no matches.");
        }
    }

    private int ARR_userNumericInput(int min, int max, String prompt) {
        int input = -1;
        do {
            System.out.format("%s.\nYour choice? [%d - %d]", prompt, min, max);
            System.out.println();
            input = scan.nextInt();
        } while (min > input || max < input);
        return input;
    }
    
    private int ARR_userChoiceInput(String prompt) {
        int input = -1;
        do {
            System.out.format("%s. \nYour choice? [%d - %d]\n", prompt, 0, 1);
            input = scan.nextInt();
        } while (0 > input || 2 < input);
        return input;
    }

    private String ARR_userStringInput(String prompt) {
        String input;
        do {
            System.out.format("Please enter %s:", prompt);
            System.out.println();
            input = scan.next();
        } while (input.length() < 1);
        return input;
    }

    private ArrayList<String> searchListByPart(String part, ArrayList<String> list) {
        ArrayList<String> res = new ArrayList<>();
        for (String item : list) {
            if (item.contains(part)) {
                res.add(item);
            }
        }
        return res;
    }

    private ArrayList<String> searchMemberByName(String partName) {
        ArrayList<String> members = mAccess.getAllMemberNames();
        ArrayList<String> memberNames = new ArrayList<>();
        for (String member : members) {
            memberNames.add(member);
        }
        return searchListByPart(partName, memberNames);
    }

    private ArrayList<String> searchBoardGameByName(String partName) {
        ArrayList<String> games = gAccess.getAllBoardGameNames();
        ArrayList<String> gameNames = new ArrayList<>();
        for (String game : games) {
            gameNames.add(game);
        }
        return searchListByPart(partName, gameNames);
    }
    
    private ArrayList<String> searchVideoGameByName(String partName) {
        ArrayList<String> games = gAccess.getAllVideoGameNames();
        ArrayList<String> gameNames = new ArrayList<>();
        for (String game : games) {
            gameNames.add(game);
        }
        return searchListByPart(partName, gameNames);
    }

    private boolean performAction(int choice) {
        boolean res = false;
        switch (choice)  {
            case 0:
                res = true;
                break;
            case 1:
                choiceDisplayGame();
                break;
            case 2:
                performNewBoardGameEntry();
                break;
            case 3:
                performNewVideoGameEntry();
                break;
            case 4:
                performNewMemberEntry();
                break;
            case 5:
                performNewBoardGameLoan();
                break;
            case 6:
                performNewVideoGameLoan();
                break;
            case 7:
                displayAllLoans();  // ----
                break;
            case 8:
                performBoardGameSearchByPlayers(); // ----
                break;
            case 9:
                //performVideoGameSearchByPlatform();
                break;
            case 10:
                //performSearchByGenre();
                break;
            case 11:
                performBoardGameReturn();
                break;
            case 12:
                //performVideoGameReturn();
                break;
        }
        return res;
    }
    
    private void choiceDisplayGame() {
        int choice = ARR_userChoiceInput("Choose 0 to display the Board Games or 1 to display the Video Games");
        if (choice == 0) {
            displayAllBoardGames();
        } else {
            displayAllVideoGames();
        }
    }

    private void performNewBoardGameEntry() {
        String name = ARR_userStringInput("the name");
        String publisher = ARR_userStringInput("the publisher");
        int minPlayers = ARR_userNumericInput(0, MAX_PLAYERS, "the minimum number of players.");
        int maxPlayers = ARR_userNumericInput(minPlayers, MAX_PLAYERS, "the maximum number of players.");
        String genre = ARR_userStringInput("the genre");
        gAccess.addBoardGame(name, publisher, minPlayers, maxPlayers, genre);
    }
    
    private void performNewVideoGameEntry() {
        String name = ARR_userStringInput("the name");
        String platform = ARR_userStringInput("the platform");
        String publisher = ARR_userStringInput("the publisher");
        String genre = ARR_userStringInput("the genre");
        gAccess.addVideoGame(name, platform, publisher, genre);
    }
    
    private void performNewMemberEntry() {
        String name = ARR_userStringInput("the name");
        mAccess.addMember(name);
    }
            
    private void performNewBoardGameLoan() {
        String partName = ARR_userStringInput("part of the name of the member");
        ArrayList<String> memberNames = searchMemberByName(partName);
        displayList(memberNames);
        if (memberNames.isEmpty()) {
            return;
        }
        String member = memberNames.get(ARR_userNumericInput(0, memberNames.size() - 1, "Which member?"));
        partName = ARR_userStringInput("part of the name of the game");
        ArrayList<String> gameNames = searchBoardGameByName(partName);
        displayList(gameNames);
        if (gameNames.isEmpty()) {
            return;
        }
        String gameName = gameNames.get(ARR_userNumericInput(0, gameNames.size() - 1, "Which game?"));
        lAccess.borrowBoardGame(member, gameName);
    }
    
    private void performNewVideoGameLoan() {
        String partName = ARR_userStringInput("part of the name of the member");
        ArrayList<String> memberNames = searchMemberByName(partName);
        displayList(memberNames);
        if (memberNames.isEmpty()) {
            return;
        }
        String member = memberNames.get(ARR_userNumericInput(0, memberNames.size() - 1, "Which member?"));
        partName = ARR_userStringInput("part of the name of the game");
        ArrayList<String> gameNames = searchVideoGameByName(partName);
        displayList(gameNames);
        if (gameNames.isEmpty()) {
            return;
        }
        String gameName = gameNames.get(ARR_userNumericInput(0, gameNames.size() - 1, "Which game?"));
        lAccess.borrowVideoGame(member, gameName);
    }

    private void displayAllLoans() {
        displayList(lAccess.getAllLoansAsStrings());
    }

    private void performBoardGameSearchByPlayers() {
        int players = ARR_userNumericInput(0, MAX_PLAYERS, "How many players?");
        ArrayList<String> theGames = gAccess.getAllBoardGameNames();
        ArrayList<String> selectedGames = new ArrayList<>();
        for (String game : theGames) {
            if (gAccess.getMinPlayersFor(game) <= players && gAccess.getMaxPlayersFor(game) >= players) {
                selectedGames.add(game);
            }
        }
        displayList(selectedGames);
    }

    private void performBoardGameReturn() {
        String partName = ARR_userStringInput("part of the name of the member");
        ArrayList<String> members = searchMemberByName(partName);
        displayList(members);
        if (members.isEmpty()) {
            return;
        }
        String member = members.get(ARR_userNumericInput(0, members.size() - 1, "Which member?"));
        ArrayList<String> games = mAccess.getBoardGameLoansForMemberAsStrings(member);
        displayList(games);
        if (games.isEmpty()) {
            return;
        }
        String game = games.get(ARR_userNumericInput(0, games.size() - 1, "Which game?"));
        lAccess.returnBoardGame(member, game);
    }

    private void displayAllBoardGames() {
        displayList(gAccess.getAllBoardGameNames());
    }
    
    private void displayAllVideoGames() {
        displayList(gAccess.getAllVideoGameNames());
    }
}
