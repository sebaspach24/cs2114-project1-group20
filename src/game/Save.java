package game;

/**
 * This class handles saving the game whenever it is done.
 *
 * @authors Sophie Linton, Sebastian Pacheco, Anna-Maria Renalds
 * @version 2026.09.22
 */

public class Save
{
    private String fileName;

    public Save();

    public Player loadPlayer(String name);

    public void savePlayer(Player player);

    public boolean playerExists(String name);
}