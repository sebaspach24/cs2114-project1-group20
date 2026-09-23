package game;

import java.util.ArrayList;

/**
 * Where the player objects are created.
 *
 * @authors Sophie Linton, Sebastian Pacheco, Anna-Maria Renalds
 * @version 2026.09.18
 */

public class Player
{
    // ~ Fields ................................................................
    private String name;
    private int points;
    private int currentStreak;
    private int totalPoints;
    private int totalWins;
    private ArrayList<PowerUp> powerUps;
    private ArrayList<Achievement> achievements;

    // ~ Constructors ..........................................................
    /**
     * @param name
     */
    public Player(String name)
    {
        this.name = name;
        this.currentStreak = 0;
        this.totalPoints = 0;
        this.totalWins = 0;
        powerUps = new ArrayList<PowerUp>();
        achievements = new ArrayList<Achievement>();

    }

    // ~Public Methods ........................................................


    /**
     * Getter method for the player object.
     * 
     * @return Returns the name of the player.
     */
    public String getName()
    {
        return name;
    }


    /**
     * 
     */
    public void getStats()
    {
        /// Idk what this means
    }


    /**
     * Getter method for points object.
     * 
     * @return Returns the amount of points the player has.
     */
    public int getPoints()
    {
        return points;
    }


    /**
     * Add points to a players profile.
     * 
     * @param addedPoints
     *            The points being added to the players score.
     */
    public void addPoints(int addedPoints)
    {
        this.points = addedPoints;
    }


    /**
     * Adds a win to the players player stats.
     */
    public void addWin()
    {
        this.totalWins++;
    }


    /**
     * If they answer a question right, adds to their streak, if incorrect,
     * resets to zero
     * 
     * @param answer
     *            If the question is answered correctly or not.
     */
    public void processStreak(boolean answer)
    {
        if (answer)
        {
            this.currentStreak++;
        }
        else
        {
            this.currentStreak = 0;
        }
    }


    /**
     * Resets the per-game stats.
     */
    public void resetGameStats()
    {
        ///
    }


    /**
     * @param achievement
     */
    public void unlockAchievement(String achievement)
    {
        // ?
    }


    /**
     * Allows the user to use a powerUp.
     * 
     * @param powerUp
     *            The power up wanting to be used.
     * @return Returns if they can use the power up or not.
     */
    public boolean usePowerUp(String powerUp)
    {
        for (PowerUp item : powerUps)
        {
            if (item.getPowerupName().equalsIgnoreCase(powerUp))
            {
                return true;

            }
        }
        return false;
    }
}
