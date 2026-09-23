package game;

/**
 * Creating a few achievements for players to unlock in the game.
 *
 * @authors Sophie Linton, Sebastian Pacheco, Anna-Maria Renalds
 * @version 2026.09.18
 */

public class Achievement
{
    private boolean unlocked;
    private String name;
    private String description;

    // ----------------------------------------------------------
    /**
     * Create a new Achievement object.
     * 
     * @param name
     *            Name of the achievement.
     * @param description
     *            Description of the achievement.
     */
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................
    public Achievement(String name, String description)
    {
        this.name = name;
        this.description = description;
        this.unlocked = false;
    }
    // ----------------------------------------------------------

    // ~Public Methods ........................................................


    /**
     * Returns as string of the achievement name
     * 
     * @return string achievement name
     */
    public String getName()
    {
        return this.name;
    }


    // ----------------------------------------------------------
    /**
     * returns a string of the achievement description and what the player needs
     * to do
     * 
     * @return a string of the achievement description
     */
    public String getDescription()
    {
        return this.description;
    }


    // ----------------------------------------------------------
    /**
     * Returns a true false of unlocked status
     * 
     * @return boolean of unlocked status
     */
    public boolean isUnlocked()
    {
        return this.unlocked;
    }


    // ----------------------------------------------------------
    /**
     * Changes status to true to unlock the specific achievement
     */
    public void unlock()
    {
        this.unlocked = true;
    }
}
