package game;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 *  Tests the player class
 * 
 *  @author srena
 *  @version Sep 23, 2026
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
        assertTrue(play.getPoints() == 2);
        assertTrue(play.getTotalPoints() == 2);
        
    }
    
    // ----------------------------------------------------------
    /**
     * tests the addWin() method
     */
    public void testAddWin()
    {
        Player play = new Player("play");
        play.addWin();
        assertTrue(play.getTotalWins()== 1);
    }
    
    // ----------------------------------------------------------
    /**
     * tests the processStreak method
     * @param answer
     */
    public void  testProcessStreak(boolean answer)
    {
        Player play = new Player("play");
        play.processStreak(true);
        assertTrue(play.getCurrentStreak() == 1);
        play.processStreak(false);
        assertTrue(play.getCurrentStreak() == 0);
    }
    
    // ----------------------------------------------------------
    /**
     * testing the resetGameStats method
     */
    public void testResetGameStats()
    {
        Player play = new Player("play");
        play.resetGameStats();
        assertTrue(play.getTotalPoints() == 0);
        assertTrue(play.getCurrentStreak() == 0);
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
        
       
    }
    /*   




    public void unlockAchievement(String achievement)
    {
        for (Achievement item : achievements)
        {
            if (item.getName().equalsIgnoreCase(achievement))
            {
                item.unlock();
                break;
            }
        } */


}
