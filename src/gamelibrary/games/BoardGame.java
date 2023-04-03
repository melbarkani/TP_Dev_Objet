package gamelibrary.games;

import gamelibrary.loans.Loan;

public class BoardGame extends Game {
    private final String name;
    private final String publisher;
    private final int minPlayers;
    private final int maxPlayers;
    private final String genre;
    BoardGame(String name, String publisher, int minPlayers, int maxPlayers, String genre) {
        this.name = name;
        this.publisher = publisher;
        this.maxPlayers = maxPlayers;
        this.minPlayers = minPlayers;
        this.genre = genre;
    }
    
    String getName() {
        return name;
    }

    String getPublisher() {
        return publisher;
    }

    int getMinPlayers() {
        return minPlayers;
    }

    int getMaxPlayers() {
        return maxPlayers;
    }

    String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "<"+ name + ">, by " + publisher + ", minPlayers=" + minPlayers + ", maxPlayers=" + maxPlayers + ", genre=" + genre;
    }
    
}
