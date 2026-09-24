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
     * Creates a new player object to play the game.
     * 
     * @param name
     *            The name of the player
     */
    public Player(String name)
    {
        this.name = name;
        this.currentStreak = 0;
        this.totalPoints = 0;
        this.totalWins = 0;
        powerUps = new ArrayList<PowerUp>();
        achievements = new ArrayList<Achievement>();

        // Adding possible achievements
        achievements
            .add(new Achievement("Newbie", "Answer your first question"));
        achievements.add(new Achievement("Smarty", "Reach 500 points"));
        achievements.add(new Achievement("On Fire", "Get a streak of 5"));
        achievements.add(new Achievement("Genius", "Reach 1000 points"));

        // Adding PowerUps
        powerUps.add(new PowerUp("Hint", "Gives a hint for the question."));
        powerUps.add(new PowerUp("50/50", "Removes half the answer chocies."));
        powerUps
            .add(new PowerUp("Double Points", "Gives a double point reward."));
        powerUps.add(
            new PowerUp(
                "Second Chance",
                "Gives two tries to answer the question"));
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
     * Prints all of the players game stats.
     */
    public void getStats()
    {
        System.out.println("Player: " + name);
        System.out.println("Current Points: " + points);
        System.out.println("Total Points: " + totalPoints);
        System.out.println("Current Streak: " + currentStreak);
        System.out.println("Total Wins: " + totalWins);
    }


    /**
     * Getter method for currentStreak object.
     * 
     * @return Returns the current streak the player has.
     */
    public int getCurrentStreak()
    {
        return currentStreak;
    }


    /**
     * Getter method for totalPoints object.
     * 
     * @return Returns the amount of total points the player has.
     */
    public int getTotalPoints()
    {
        return totalPoints;
    }


    /**
     * Getter method for totalWins object.
     * 
     * @return Returns the amount of wins the player has.
     */
    public int getTotalWins()
    {
        return totalWins;
    }


    /**
     * Getter method for powerUps list.
     * 
     * @return Returns the ArrayList of powerUps the player has.
     */
    public ArrayList<PowerUp> getPowerUps()
    {
        return powerUps;
    }


    /**
     * Getter method for Achievement list.
     * 
     * @return Returns the ArrayList of achievements the player has.
     */
    public ArrayList<Achievement> getAchievements()
    {
        return achievements;
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

    // ----------------------------------------------------------
    /**
     * Setter method for points
     * @param points the desired points
     */
    public void setTotalPoints(int points)
    {
        this.points = points;
    }
    // ----------------------------------------------------------
    /**
     * setter method for the streak
     * @param streak the desired streak
     */
    public void setCurrentStreak(int streak )
    {
        currentStreak = streak;
    }
    // ----------------------------------------------------------
    /**
     * the setter method for the total wins
     * @param wins the desired wins
     */
    public void setTotalWins(int wins)
    {
        totalWins = wins;
    }

    /**
     * Add points to a players profile.
     * 
     * @param addedPoints
     *            The points being added to the players score.
     */
    public void addPoints(int addedPoints)
    {
        this.points += addedPoints;
        this.totalPoints += addedPoints;
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
        this.points = 0;
        this.currentStreak = 0;
    }


    /**
     * Unlocks an achievement for the player.
     * 
     * @param achievement
     *            The achievement being unlocked.
     */
    public void unlockAchievement(String achievement)
    {
        for (Achievement item : achievements)
        {
            if (item.getName().equalsIgnoreCase(achievement))
            {
                item.unlock();
                break;
            }
        }
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
