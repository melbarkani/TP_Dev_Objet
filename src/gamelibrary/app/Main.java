package gamelibrary.app;

public class Main {

  public static void main(String[] args) {
    LibraryApp myLib = new LibraryApp();
    putExampleDataIn(myLib);
    myLib.run();
  }
  private static void putExampleDataIn(LibraryApp lib) {
    lib.addBoardGame("7 Wonders", "Repos Production", 3, 7, "Management");
    lib.addBoardGame("Love Letter", "Zman Games", 2, 6, "Party");
    lib.addBoardGame("Dixit", "Libellud", 3, 8, "Narrative");
    lib.addBoardGame("King of Tokyo", "Iello", 2, 6, "Tactical");
    lib.addBoardGame("Catan", "Kosmos", 3, 4, "Management");
    lib.addVideoGame("The Legend of Zelda: Link's Awakening", "GameBoy", "Nintendo", "Narrative");
    lib.addVideoGame("Kingdom Hearts", "PS2", "SquareSoft", "Narrative");
    lib.addVideoGame("Grand Theft Auto: San Andreas", "PS2", "Rockstar Games", "Narrative");
    lib.addVideoGame("Shenmue", "Dreamcast", "Sega", "Narrative");
    lib.addVideoGame("ChuChu Rocket", "Dreamcast", "Sega", "Puzzle");
    lib.addVideoGame("Sudoku", "PS2", "Success", "Puzzle");
    lib.addVideoGame("Mario Party", "N64", "Nintendo", "Party");
    lib.addVideoGame("Jeopardy!", "Commodore 64", "Sharedata", "Quizz");
    lib.addMembers(new String[]{"Alice", "Bob", "Carol", "Dave"});
  }
}
