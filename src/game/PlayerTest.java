package game;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
  Tests the player class
 *
 * @authors Sophie Linton, Sebastian Pacheco, Anna-Maria Renalds
 * @version 2026.09.18
 */
public class PlayerTest extends student.TestCase
{
    
    // ----------------------------------------------------------
    /**
     * tests the player constructor, getName, getCurrentStreak, getTotalPoints, getTotalWins, getAchievements, getPowerUps
     */
    public void testPlayer()
    {
        Player play = new Player("play");
        assertEquals("play", play.getName());
        assertEquals(0, play.getCurrentStreak());
        assertEquals(0, play.getTotalPoints());
        assertEquals(0, play.getTotalWins());
        
        assertEquals("Newbie", play.getAchievements().get(0).getName());
        assertEquals("Smarty", play.getAchievements().get(1).getName());
        assertEquals("On Fire", play.getAchievements().get(2).getName());
        assertEquals("Genius", play.getAchievements().get(3).getName());
        
        assertEquals("Answer your first question", play.getAchievements().get(0).getDescription());
        assertEquals("Reach 500 points", play.getAchievements().get(1).getDescription());
        assertEquals("Get a streak of 5", play.getAchievements().get(2).getDescription());
        assertEquals("Reach 1000 points", play.getAchievements().get(3).getDescription());
        
        assertEquals("Hint", play.getPowerUps().get(0).getPowerupName());
        assertEquals("50/50", play.getPowerUps().get(1).getPowerupName());
        assertEquals("Double Points", play.getPowerUps().get(2).getPowerupName());
        assertEquals("Second Chance", play.getPowerUps().get(3).getPowerupName());
        
        assertEquals( "Gives a hint for the question.", play.getPowerUps().get(0).getPowerUpDescription());
        assertEquals("Removes half the answer chocies.", play.getPowerUps().get(1).getPowerUpDescription());
        assertEquals("Gives a double point reward.", play.getPowerUps().get(2).getPowerUpDescription());
        assertEquals("Gives two tries to answer the question", play.getPowerUps().get(3).getPowerUpDescription());
    }
    
    // ----------------------------------------------------------
    /**
     * testing the add points method
     */
    public void testAddPoints()
    {
        Player play = new Player("play");
        play.addPoints(2);
        assertEquals(play.getPoints(), 2);
        assertEquals(play.getTotalPoints(), 2);
        
    }
    
    // ----------------------------------------------------------
    /**
     * tests the addWin() method
     */
    public void testAddWin()
    {
        Player play = new Player("play");
        play.addWin();
        assertEquals(play.getTotalWins(), 1);
    }
    
    // ----------------------------------------------------------
    /**
     * tests the setter and getter methods for current streak
     */
    public void testCurrentStreak()
    {
        Player play = new Player("play");
        assertEquals(play.getCurrentStreak(), 0);
        play.setCurrentStreak(5);
        assertEquals(play.getCurrentStreak(),5);
        
    }
    
    // ----------------------------------------------------------
    /**
     * Test getter and setter methods for totalwins
     */
    public void testTotalWins()
    {
        Player play = new Player("play");
        assertEquals(play.getTotalWins(), 0);
        play.setTotalWins(5);
        assertEquals(play.getTotalWins(),5);
    }
    
    
    // ----------------------------------------------------------

    // ----------------------------------------------------------
    /**
     * testing the resetGameStats method
     */
    public void testResetGameStats()
    {
        Player play = new Player("play");
        play.resetGameStats();
        assertEquals(play.getTotalPoints(), 0);
        assertEquals(play.getCurrentStreak(), 0);
    }
    
    // ----------------------------------------------------------
    /**
     * Test set total points
     */
    public void testSetTotalPoints()
    {
        Player play = new Player("play");
        play.setTotalPoints(4);
    }
    // ----------------------------------------------------------
    /**
     * tests the unlockAchievement method
     */
    public void testUnlockAchievement()
    {
        Player play = new Player("play");
        play.unlockAchievement("Smarty");
     
      
        assertTrue(play.getAchievements().get(1).isUnlocked());
        
        assertFalse(play.getAchievements().get(3).isUnlocked());
        
        Player play2 = new Player("play2");
        play2.unlockAchievement("FAKE");
        assertFalse(play.getAchievements().get(0).isUnlocked());
        
       
    }
    
    // ----------------------------------------------------------
    /**
     * testing the getStats method
     */
    public void testGetStats()
    {
        Player play = new Player("play");
        play.getStats();
        String actual = systemOut().getHistory();

        String expected = "Player: play\n" +
                                "Current Points: 0\n" +
                                "Total Points: 0\n" +
                                "Current Streak: 0\n" +
                                "Total Wins: 0\n";

        assertEquals(expected, actual);
    }
    
    
    // ----------------------------------------------------------
    /**
     * testing the process streak method
     */
    public void testProcessStreak()
    {
        Player play = new Player("play");
        play.processStreak(true);
        assertEquals(play.getCurrentStreak(), 1);
        play.processStreak(false);
        assertEquals(play.getCurrentStreak(), 0);
    }
    
    
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testUsePowerUp()
    {
        Player play = new Player("play");
        assertTrue(play.usePowerUp("50/50"));
        assertFalse(play.usePowerUp("50/50"));
        assertFalse(play.usePowerUp("FAKE"));
    }
    


}
