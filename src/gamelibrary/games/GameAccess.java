package gamelibrary.games;

import gamelibrary.loans.LoanAccess;
import gamelibrary.members.MemberAccess;
import java.util.ArrayList;
import java.util.HashMap;

public class GameAccess {
    /**
     * Collection de tous les jeux de société
     */
    HashMap<String, BoardGame> allBoardGames;
    
    /**
     * Collection de tous les jeux vidéos
     */
    HashMap<String, VideoGame> allVideoGames;
    
    /**
     * Accès au membres
     */
    private MemberAccess mAccess;
    
    /**
     * Accès aux emprunts
     */
    private LoanAccess lAccess;
    
    /**
     * Constructeur de la classe GameAccess
     */
    public GameAccess() {
        allBoardGames = new HashMap<>();
        allVideoGames = new HashMap<>();
    }
    
    /**
     * Méthode qui permet d'ajouter un jeu à la collection de jeux
     * @param name le nom du jeu 
     * @param publisher l'éditeur du jeu
     * @param minPlayers le nombre minimum de joueurs
     * @param maxPlayers le nombre maximum de joueurs
     * @param genre le genre du jeu 
     */
    public void addBoardGame(String name, String publisher, int minPlayers, int maxPlayers, String genre) {
        allBoardGames.put(name, new BoardGame(name, publisher, minPlayers, maxPlayers, genre));
    }
    
    /**
     * Méthode qui permet d'ajouter un jeu vidéo à la collection de jeux vidéos
     * @param name le nom du jeu 
     * @param platform la plataforme sur laquelles le jeu est disponible
     * @param publisher l'éditeur du jeu
     * @param genre le genre du jeu
     */
    public void addVideoGame(String name, String platform, String publisher, String genre) {
        allVideoGames.put(name, new VideoGame(name, platform, publisher, genre));
    }

    /**
     * Méthode qui permet de récuérer les noms de tous les jeux de la collection des 
     * jeux de société
     * @return une liste de chaînes de caractères contenant les nom de tous les jeux de société
     */
    public ArrayList<String> getAllBoardGameNames() {
        ArrayList<String> res = new ArrayList<>();
        for (BoardGame bg : allBoardGames.values()) {
            res.add(bg.toString());
        }
        return res;
    }
    
    /**
     * Méthode qui permet de récuérer les noms de tous les jeux de la collection des 
     * jeux vidéos
     * @return une liste de chaînes de caractères contenant les nom de tous les jeux vidéos
     */
    public ArrayList<String> getAllVideoGameNames() {
        ArrayList<String> res = new ArrayList<>();
        for (VideoGame vg : allVideoGames.values()) {
            res.add(vg.toString());
        }
        return res;
    }

    /**
     * Méthode qui permet de récupérer le nombre minimum de joueurs pour un jeu donné
     * @param game le nom du jeu recherché
     * @return le nombre minimum de joueurs poue un jeu donné, -1 s'il n'existe pas
     */
    public int getMinPlayersFor(String game) {
        BoardGame bg = allBoardGames.get(game);
        if (bg != null) {
            return bg.getMinPlayers();
        } else {
            return -1;
        }        
    }

    /**
     * Méthode qui permet de récupérer le nombre maximum de joueurs pour un jeu donné
     * @param game le nom du jeu recherché
     * @return le nombre maximum de joueurs poue un jeu donné, -1 s'il n'existe pas
     */
    public int getMaxPlayersFor(String game) {
        BoardGame bg = allBoardGames.get(game);
        if (bg != null) {
            return bg.getMaxPlayers();
        } else {
            return -1;
        }
    }

    /**
     * Méthode qui permet de définir l'objet MemberAccess qui permettra d'accéder
     * aux membres
     * @param mAccess l'objet MemberAccess  
     */
    public void setMemberAccess(MemberAccess mAccess) {
        this.mAccess = mAccess;
    }
    
    /**
     * Méthode qui permet de définir l'objet LoanAccess qui permettra d'accéder
     * aux membres
     * @param lAccess l'objet LoanAccess 
     */
    public void setLoanAccess(LoanAccess lAccess) {
        this.lAccess = lAccess;
    }
    
    /**
     * Méthode qui permet de récupérer le jeu de société au nom donné
     * @param game le nom du jeu à récupérer
     * @return le jeu correspondant au nom donné, null s'il n'existe pas
     */
    public BoardGame getBoardGame(String game) {
        if (allBoardGames.containsKey(game)) {
            return allBoardGames.get(game);
        } else {
            return null;
        }
    }
    
    /**
     * Méthode qui permet de récupérer le jeu de société au nom donné
     * @param game le nom du jeu à récupérer
     * @return le jeu correspondant au nom donné, null s'il n'existe pas
     */
    public VideoGame getVideoGame(String game) {
        if (allBoardGames.containsKey(game)) {
            return allVideoGames.get(game);
        } else {
            return null;
        }
    }
}
