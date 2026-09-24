package game;
import java.io.File;
import java.io.IOException;
// -------------------------------------------------------------------------

public class SaveTest extends student.TestCase
{
  // ----------------------------------------------------------
/**
 * tests loading and saving the save method
 * @throws Exception an error
 */
    public void testLoadPlayerAllBranches() throws Exception
    {
        Save save1 = new Save();
      
        Player freshPlayer = save1.loadPlayer("FakePlayerNameXYZ");
        assertNotNull(freshPlayer);
        assertEquals("FakePlayerNameXYZ", freshPlayer.getName());
        assertEquals(0, freshPlayer.getTotalPoints());

        
        Player p1 = new Player("TestPlayer");
        p1.setTotalPoints(500);
        p1.setCurrentStreak(3);
        p1.setTotalWins(5);
        
        
        save1.savePlayer(p1);
        
        Player loaded = save1.loadPlayer("TestPlayer");
        assertNotNull(loaded);
        assertEquals("TestPlayer", loaded.getName());
        assertEquals(500, loaded.getTotalPoints());
        assertEquals(3, loaded.getCurrentStreak());
        assertEquals(5, loaded.getTotalWins());
    }
    
    // ----------------------------------------------------------
    /**
     * Tests the save player exception
     */
    public void testSavePlayerException()
    {
        Save save1 = new Save();
        
       
        Player invalidPlayer = new Player("nonexistentFolder/BrokenName");
        
       
        save1.savePlayer(invalidPlayer);
        
        
        assertFalse(save1.playerExists("nonexistentFolder/BrokenName"));
    }
    
    // ----------------------------------------------------------
    /**
     * tests the load player class specifically the catch block
     * @throws IOException when invalid input
     */
    public void testLoadPlayerException() throws java.io.IOException
    {
        Save save1 = new Save();
        
       
        java.io.File file = new java.io.File("CorruptPlayer_save.txt");
        java.io.PrintWriter writer = new java.io.PrintWriter(file);
        
        writer.println("CorruptPlayer");
        writer.println("NOT_A_NUMBER"); 
        writer.close();

      
        Player loaded = save1.loadPlayer("CorruptPlayer");
        
      
        assertNotNull(loaded);
        assertEquals("CorruptPlayer", loaded.getName());
        assertEquals(0, loaded.getTotalPoints());

       
        file.delete();
    }
}
