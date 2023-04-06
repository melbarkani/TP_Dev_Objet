package gamelibrary.games;

public abstract class Game {
    /**
     * Le nom du jeu
     */
    protected String name;
    
    /**
     * Le nom de l'éditeur du jeu
     */
    protected String publisher;
    
    /**
     * Le genre du jeu
     */
    protected String genre;
    
    /**
     * Constructeur de la classe Game
     * @param name le nom du jeu
     * @param publisher l'éditeur du jeu 
     * @param genre le genre du jeu
     */
    public Game(String name, String publisher, String genre) {
        this.name = name;
        this.publisher = publisher;
        this.genre = genre;
    }
        
    /**
     * Méthode qui permet de récupérer le nom du jeu 
     * @return le nom du jeu
     */
    public String getName() {
        return name;
    }
    
    /**
     * Méthode qui permet de récupérer l'éditeur du jeu
     * @return le nom de l'éditeur
     */
    public String getPublisher() {
        return publisher;
    }
    
    /**
     * Méthode qui permet de récupérer le genre du jeu
     * @return le genre du jeu
     */
    public String getGenre() {
        return genre;
    }

}

