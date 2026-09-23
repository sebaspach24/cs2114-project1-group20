package game;

/**
 * Where the PowerUp objects are created, keeps track of available ones.
 *
 * @authors Sophie Linton, Sebastian Pacheco, Anna-Maria Renalds
 * @version 2026.09.18
 */

public class PowerUp
{
    // ~ Fields ................................................................
    private String powerUpName;
    private String powerUpDescription;
    private boolean used;

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    /**
     * Create a powerUp object.
     * 
     * @param powerUpName
     *            Name of power up.
     * @param powerUpDescription
     *            Description of power up.
     */
    public PowerUp(String powerUpName, String powerUpDescription)
    {
        this.powerUpName = powerUpName;
        this.powerUpDescription = powerUpDescription;
        this.used = false;
    }


    /**
     * Getter method for powerUp name string.
     * 
     * @return Returns name of power up.
     */
    public String getPowerupName()
    {

        return powerUpName;
    }


    /**
     * Getter method for power up description.
     * 
     * @return Returns description of power up.
     */
    public String getPowerUpDescription()
    {
        return powerUpDescription;
    }


    /**
     * Returns if the power up is used.
     * 
     * @return Returns if the power-up is used.
     */
    public boolean isUsed()
    {
        return used;
    }


    /**
     * The player uses the power up.
     */
    public void use()
    {
        this.used = true;
    }


    /**
     * Resets the power ups to unused.
     */
    public void reset()
    {
        this.used = false;
    }
}
