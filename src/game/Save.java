package game;

import java.io.*;
import java.util.Scanner;

/**
 * This class handles saving the game whenever it is done.
 *
 * @authors Sophie Linton, Sebastian Pacheco, Anna-Maria Renalds
 * @version 2026.09.22
 */

public class Save
{
    // ----------------------------------------------------------
    /**
     * Create a new Save object.
     */
    public Save()
    {
        
    }
    
    // ----------------------------------------------------------
    /**
     * Checks if player exists
     * @param name name of the player
     * @return a boolean
     */
    public boolean playerExists(String name)
    {
        File file = new File(name + "_save.txt");
        return file.exists();
    }
    
    // ----------------------------------------------------------
    /**
     * saves the player 
     * @param player the player object to be saved
     */
    public void savePlayer(Player player)
    {
        
        String fileName = player.getName()+ "_save.txt";
        File file = new File(fileName);
        
        try(PrintWriter writer = new PrintWriter(file))
        {
            writer.println(player.getName());
            writer.println(player.getTotalPoints());
            writer.println(player.getCurrentStreak());
            writer.println(player.getTotalWins());
            
            for(Achievement ach : player.getAchievements())
            {
                writer.println(ach.getName()+","+ach.isUnlocked());
                
            }
        }
        catch (IOException e)
        {
            System.out.println("Error saving player profile: " + e.getMessage());
        }
    }
  

    // ----------------------------------------------------------
    /**
     * loads the player 
     * @param name the name of the player
     * @return the player object with saved data
     */
   public Player loadPlayer(String name)
    {
        
        if (!playerExists(name))
        {
            return new Player(name);
        }

        File file = new File(name + "_save.txt");
        
       
        try (Scanner scanner = new Scanner(file))
        {
            String playerName = scanner.nextLine();
            int totalPoints = Integer.parseInt(scanner.nextLine());
            int currentStreak = Integer.parseInt(scanner.nextLine());
            int totalWins = Integer.parseInt(scanner.nextLine());
            
            Player player = new Player(playerName);
            player.setTotalPoints(totalPoints);
            player.setCurrentStreak(currentStreak);
            player.setTotalWins(totalWins);
            return player;
        }
            

            catch (Exception e)
            {
                
                e.printStackTrace(); 
                return new Player(name); 
            }
        
    }
    }


