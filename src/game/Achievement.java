package game;

/**
 * Creating a few achievements for players to unlock in the game.
 *
 * @authors Sophie Linton, Sebastian Pacheco, Anna-Maria Renalds
 * @version 2026.09.18
 */

public class Achievement
{
    // ----------------------------------------------------------
    /**
     * Create a new Achievement object.
     * 
     * @param x
     *            is a parameter
     * @param y
     *            is also a parameter
     */
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................
    public Achievement(String x, String y)
    {
        // idk what to call the variables
    }
    // ----------------------------------------------------------

    // ~Public Methods ........................................................

    /**
     * Returns as string of the achievement name 
     * @return string achievement name
     */
    public String getName()
    {
        return null;
    }
    
    // ----------------------------------------------------------
    /**
     * returns a string of the achievement description and what the player needs to do
     * @return a string of the achievement description
     */
    public String getDescription()
    {
        return null;
    }
    
    // ----------------------------------------------------------
    /**
     * Returns a true false of unlocked status
     * @return boolean of unlocked status
     */
    public boolean isUnlocked()
    {
        return false;
    }
    
    // ----------------------------------------------------------
    /**
     * Changes status to true/false of unlocked for the specific achievement
     */
    public void unlock()
    {
        //empty
    }
}
