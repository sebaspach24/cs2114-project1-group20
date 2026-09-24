package game;
/**
 * Tests the powerup class
 *
 * @authors Sophie Linton, Sebastian Pacheco, Anna-Maria Renalds
 * @version 2026.09.18
 */
public class PowerUpTest extends student.TestCase
{
    // ----------------------------------------------------------
    /**
         tests the get powerup name and get power up description methods
     */
    public void testGetPowerUpNameandDescription()
    {
        Player play = new Player("play");
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
     * tests the is used method
     */
    public void testIsUsed()
    {
        PowerUp power = new PowerUp("power", "does a power");
        assertFalse(power.isUsed());
        power.use();
        assertTrue(power.isUsed());
    }
    
    // ----------------------------------------------------------
    /**
     * tests the reset method
     */
    public void testReset()
    {
        PowerUp power = new PowerUp("power", "does a power");
        power.use();
        power.reset();
        assertFalse(power.isUsed());
        
    }
    
    /*





    public void reset()
    {
        this.used = false;
    }
 */
}
