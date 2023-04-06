/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gamelibrary.games;

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
public class BoardGameTest {

    /**
     * Test of getMinPlayers method, of class BoardGame.
     */
    @Test
    public void testGetMinPlayers() {
        System.out.println("getMinPlayers");
        String name = "toto";
        String publisher = "Iello";
        String genre = "Management";
        BoardGame bg = new BoardGame(name, publisher, 2, 10, genre);
        // Premier Test : valeur attendue = 2
        assertEquals(2, bg.getMinPlayers());
        
        BoardGame bg2 = new BoardGame(name, publisher, 0, 15, genre);
        // Deuxième Test : valeur attendue = 0
        assertEquals(0, bg2.getMinPlayers());
        
        BoardGame bg3 = new BoardGame(name, publisher, -2, 5, genre);
        // Troixième Test : valeur attendue (négative) = -2
        assertEquals(-2, bg3.getMinPlayers());
    }

    /**
     * Test of getMaxPlayers method, of class BoardGame.
     */
    @Test
    public void testGetMaxPlayers() {
        System.out.println("getMinPlayers");
        String name = "toto";
        String publisher = "Iello";
        String genre = "Management";
        BoardGame bg = new BoardGame(name, publisher, 2, 10, genre);
        // Premier Test : valeur attendue = 10
        assertEquals(10, bg.getMaxPlayers());
        
        BoardGame bg2 = new BoardGame(name, publisher, 0, 0, genre);
        // Deuxième Test : valeur attendue = 0
        assertEquals(0, bg2.getMaxPlayers());
        
        BoardGame bg3 = new BoardGame(name, publisher, -2, -5, genre);
        // Troixième Test : valeur attendue (négative) = -2
        assertEquals(-5, bg3.getMaxPlayers());
    }

}
