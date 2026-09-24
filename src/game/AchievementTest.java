package game;
// -------------------------------------------------------------------------
/**
 * tests the achievement class
 *
 * @authors Sophie Linton, Sebastian Pacheco, Anna-Maria Renalds
 * @version 2026.09.18
 */
public class AchievementTest extends student.TestCase
{

    
    
    
    // ----------------------------------------------------------
    /**
     * tests that an achievement object is created properly and the getName, getDescription and isUnlocked
     */
    public void testAchievement()
    {
        Achievement achieve = new Achievement("achieve", "allows you to achieve");
        assertEquals(achieve.getName(),"achieve");
        assertEquals(achieve.getDescription(), "allows you to achieve");
        assertFalse(achieve.isUnlocked());
        
    }
    
   
    
    // ----------------------------------------------------------
    /**
     * Tests whether the unlock registers when called.
     */
    public void testUnlock()
    {
        Achievement achieve = new Achievement("achieve", "allows you to achieve");
        achieve.unlock();
        assertTrue(achieve.isUnlocked());
    }
  

    
}
