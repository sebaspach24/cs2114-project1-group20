package game;

// -------------------------------------------------------------------------
/**
 * Testing the main class
 *
 * @authors Sophie Linton, Sebastian Pacheco, Anna-Maria Renalds
 * @version 2026.09.18
 */
public class MainTest extends student.TestCase
{
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................
// ----------------------------------------------------------
/**
 * Create a new MainTest object.
 */
public MainTest()
{
   
}
    // ----------------------------------------------------------
    /**
     * test method checks if the game was started, maybe if
     * the correct objects were created that should be at start
     * 
     */


public void testStartGame(){
    
    /*System.out.println("Welcome to Trivia!");

        boolean addingPlayers = true;

        while (addingPlayers && players.size() < 4)
        {
            System.out.println();
            System.out.println("1. Create a new profile");
            System.out.println("2. Use an existing profile");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            if (choice.equals("1"))
            {
                createPlayer();
            }
            else if (choice.equals("2"))
            {
                loadPlayer();
            }
            else
            {
                System.out.println("Invalid choice. Please enter 1 or 2.");
                continue;
            }

            if (players.size() == 4)
            {
                System.out.println("Maximum number of players reached.");
                break;
            }

            if (!players.isEmpty())
            {
                System.out
                    .print("Would you like to add another player? (yes/no): ");

                String answer = scanner.nextLine();

                if (answer.equalsIgnoreCase("no"))
                {
                    addingPlayers = false;
                }
            }*/
}

// ----------------------------------------------------------
/**test method checks if game is ended and correct processes have been
     * carried out at game end
 */
public void testEndGame()
{
    //.
}

// ----------------------------------------------------------
/**
 * Checks if the game starts the
 * round, bad input would be if the game is just stopped.
 */
public void testPlayRound()
{
    //.
}

// ----------------------------------------------------------
/**
 * Proper input would be "Category, Difficulty", invalid input would be null
 */
public void testAskQuestion()
{
    //.
}

// ----------------------------------------------------------
/**
 * Proper input would be "Answer", invalid input also
 * can be null
 */
public void testProcessAnswer()
{
    //.
}

// ----------------------------------------------------------

    
}
