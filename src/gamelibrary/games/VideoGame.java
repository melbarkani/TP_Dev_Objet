package gamelibrary.games;

public class VideoGame extends Game {
    /**
     * Le nom du jeu vidéo
     */
    private final String name;
    
    /**
     * La platform du jeu vidéo
     */
    private final String platform;
    
    /**
     * Le nom de l'éditeur du jeu vidéo
     */
    private final String publisher;
    
    /**
     * Le nombre maximum de joueur du jeu vidéo
     */
    
    /**
     * Le genre du jeu vidéo
     */
    private final String genre;
    
    /**
     * Constructeur de la classe VideoGame
     * @param name le nom du jeu 
     * @param platform la platform du jeu
     * @param publisher l'éditeur du jeu
     * @param genre le genre du jeu
     */
    VideoGame(String name, String platform, String publisher, String genre) {
        super(name, publisher, genre);
        this.name = name;
        this.platform = platform;
        this.publisher = publisher;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "VideoGame{" + "name=" + name + ", platform=" + platform + ", publisher=" + publisher + ", genre=" + genre + '}';
    }
}
