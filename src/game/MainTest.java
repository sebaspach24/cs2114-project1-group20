package game;

import java.util.ArrayList;
import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * Testing the main class
 *
 * @authors Sophie Linton, Sebastian Pacheco, Anna-Maria Renalds
 * @version 2026.09.18
 */
public class MainTest extends student.TestCase
{
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................
// ----------------------------------------------------------

    // ----------------------------------------------------------
    /**
     * test method checks if the game was started, maybe if
     * the correct objects were created that should be at start
     * 
     */


public void testStartGame(){
    
    StringBuilder inputs = new StringBuilder();
    inputs.append("1\nno\n"); 
    for (int i = 0; i < 5; i++) {
        inputs.append("Category\nDifficulty\n1\nAnswer\n");
    }
    
    System.setIn(new java.io.ByteArrayInputStream(inputs.toString().getBytes()));
    
    StringBuilder newer = new StringBuilder();
    newer.append("3\n1\nno\n"); 
    for (int i = 0; i < 5; i++) {
        newer.append("Category\nDifficulty\n1\nAnswer\n");
    }
    
    System.setIn(new java.io.ByteArrayInputStream(newer.toString().getBytes()));
    
    StringBuilder newthing = new StringBuilder();
    newthing.append("1\nyes\n"); // Player 1
    newthing.append("2\nyes\n"); // Player 2
    newthing.append("1\nyes\n"); // Player 3
    newthing.append("2\n");      // Player 4 (Hits cap, shouldn't ask "Would you like to add another...")
    
    // Followed by 5 rounds of dummy inputs * 4 players = 20 total turns
    for (int round = 0; round < 5; round++) {
        for (int p = 0; p < 4; p++) {
            newthing.append("Category\nDifficulty\n1\nAnswer\n");
        }
    }
    
    System.setIn(new java.io.ByteArrayInputStream(newthing.toString().getBytes()));
    
}

// ----------------------------------------------------------
/**test method checks if game is ended and correct processes have been
     * carried out at game end
 */
public void testEndGame()
{
    //.
}

// ----------------------------------------------------------
/**
 * Checks if the game starts the
 * round, bad input would be if the game is just stopped.
 */
public void testPlayRound()
{
    //.
}

// ----------------------------------------------------------
/**
 * Proper input would be "Category, Difficulty", invalid input would be null
 */
public void testAskQuestion()
{
    //.
}

// ----------------------------------------------------------
/**
 * Proper input would be "Answer", invalid input also
 * can be null
 */
public void testProcessAnswer()
{
    //.
}

// ----------------------------------------------------------

    
}
