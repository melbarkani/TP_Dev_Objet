package gamelibrary.games;

import gamelibrary.loans.Loan;

public class BoardGame extends Game {
    /**
     * Le nom du jeu de société
     */
    private final String name;
    
    /**
     * Le nom de l'éditeur du jeu 
     */
    private final String publisher;
    
    /**
     * Le nombre minimum de joueur du jeu 
     */
    private final int minPlayers;
    
    /**
     * Le nombre maximum de joueur du jeu 
     */
    private final int maxPlayers;
    
    /**
     * Le genre du jeu
     */
    private final String genre;
    
    /**
     * Constructeur de la classe BoardGame
     * @param name le nom du jeu
     * @param publisher l'éditeur du jeu 
     * @param minPlayers le nombre minimum de joueur du jeu
     * @param maxPlayers le nombre maximum de joueur du jeu
     * @param genre le genre du jeu
     */
    BoardGame(String name, String publisher, int minPlayers, int maxPlayers, String genre) {
        super(name, publisher, genre);
        this.name = name;
        this.publisher = publisher;
        this.maxPlayers = maxPlayers;
        this.minPlayers = minPlayers;
        this.genre = genre;
    }
    
    /**
     * Méthode qui permet de récupérer le nom du jeu 
     * @return le nom du jeu
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Méthode qui permet de récupérer l'éditeur du jeu
     * @return le nom de l'éditeur
     */
    @Override
    public String getPublisher() {
        return publisher;
    }
    
    /**
     * Méthode qui permet de récupérer le nombre minimum de joueurs
     * pour le jeu
     * @return le nombre minimum de joueurs 
     */
    int getMinPlayers() {
        return minPlayers;
    }

    /**
     * Méthode qui permet de récupérer le nombre maximum de joueurs
     * pour le jeu
     * @return le nombre maximum de joueurs 
     */
    int getMaxPlayers() {
        return maxPlayers;
    }
    
    /**
     * Méthode qui permet de récupérer le genre du 
     * @return le genre du jeu 
     */
    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "<"+ name + ">, by " + publisher + ", minPlayers=" + minPlayers + ", maxPlayers=" + maxPlayers + ", genre=" + genre;
    }
}