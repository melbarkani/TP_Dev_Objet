/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gamelibrary.games;

import gamelibrary.loans.LoanAccess;
import gamelibrary.members.MemberAccess;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author barka
 */
public class GameAccessTest {

    /**
     * Test of getMinPlayersFor method, of class GameAccess.
     */
    @Test
    public void testGetMinPlayersFor() {
        HashMap<String, BoardGame> allBoardGames = new HashMap<>();
        allBoardGames.put("Monopoly", new BoardGame("Monopoly", "toto", 12, 15, "adventure"));
        allBoardGames.put("Dixit", new BoardGame("Dixit", "Libellud", 0, 8, "Narrative"));
        allBoardGames.put("Catan", new BoardGame("Catan", "Kosmos", -4, 4, "Management"));
        
        GameAccess game = new GameAccess();
        // Test d'un chiffre quelconque
        assertEquals(12, game.getMinPlayersFor("Monopoly"));
        // Test du chiffre zéro
        assertEquals(0, game.getMinPlayersFor("Dixit"));
        // Test d'un chiffre négatif
        assertEquals(-4, game.getMinPlayersFor("Catan"));
    }

    /**
     * Test of getMaxPlayersFor method, of class GameAccess.
     */
    @Test
    public void testGetMaxPlayersFor() {
        HashMap<String, BoardGame> allBoardGames = new HashMap<>();
        allBoardGames.put("Monopoly", new BoardGame("Monopoly", "toto", 12, 15, "adventure"));
        allBoardGames.put("Dixit", new BoardGame("Dixit", "Libellud", -3, 0, "Narrative"));
        allBoardGames.put("Catan", new BoardGame("Catan", "Kosmos", -4, -2, "Management"));
        
        GameAccess game = new GameAccess();
        // Test d'un chiffre quelconque
        assertEquals(15, game.getMaxPlayersFor("Monopoly"));
        // Test du chiffre zéro
        assertEquals(0, game.getMaxPlayersFor("Dixit"));
        // Test d'un chiffre négatif
        assertEquals(-2, game.getMaxPlayersFor("Catan"));
    }

}
