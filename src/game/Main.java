package game;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Runs the trivia game and controls the overall game flow.
 *
 * @authors Sophie Linton, Sebastian Pacheco, Anna-Maria Renalds
 * @version 2026.09.22
 */
public class Main
{
    // ~ Fields ................................................................

    private ArrayList<Player> players;
    private QuestionBank questionBank;
    private Save save;
    private boolean gameOver;
    private Scanner scanner;
    private int currentRound;
    private static final int MAX_ROUNDS = 5;
    

    // ~ Constructors ..........................................................


    /**
     * Creates a new Main object and initializes the objects needed to run the
     * trivia game.
     */
    public Main()
    {
        players = new ArrayList<Player>();
        questionBank = new QuestionBank();
        save = new Save();
        gameOver = false;
        scanner = new Scanner(System.in);
        currentRound = 0;
    }

    // ~ Public Methods ........................................................


    /**
     * Launches the trivia game.
     *
     * @param args
     *            command-line arguments
     */
    public static void main(String[] args)
    {
        Main game = new Main();
        game.startGame();
    }


    /**
     * Starts the trivia game and handles player setup. Players may create a new
     * profile or use an existing profile. A maximum of four players may
     * participate in one game.
     */
    public void startGame()
    {
        System.out.println("Welcome to Trivia!");

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
            }
        }

        while (!gameOver)
        {
            playRound();
            currentRound++;

            if (currentRound >= MAX_ROUNDS)
            {
                gameOver = true;
            }
        }

        endGame();
    }
    
    
    /**
     * Plays one round of the trivia game. Each player selects a category
     * and difficulty and receives a matching question. If no questions
     * remain for the selected combination, the player chooses again.
     */
    public void playRound()
    {
        for (Player player : players)
        {
            System.out.println();
            System.out.println(player.getName() + "'s turn!");

            Question question = null;

            while (question == null)
            {
                String category = selectCategory();
                String difficulty = selectDifficulty();

                question = questionBank.getQuestion(category, difficulty);

                if (question == null)
                {
                    System.out.println(
                        "There are no questions remaining for that "
                            + "category and difficulty.");
                    System.out.println("Please choose again.");
                }
            }

            askQuestion(question, player);
        }
    }
    

    /**
     * Displays a question and its possible answer choices. The player
     * may answer normally or use one power-up before answering.
     *
     * @param question
     *     the question to display
     * @param player
     *     the player answering the question
     */
    public void askQuestion(Question question, Player player)
    {
        System.out.println();
        System.out.println(question.getQuestionText());

        String[] choices = question.getChoices();

        for (int i = 0; i < choices.length; i++)
        {
            System.out.println((i + 1) + ". " + choices[i]);
        }

        System.out.println();
        System.out.println("1. Answer question");
        System.out.println("2. Use power-up");
        System.out.print("Choose an option: ");

        String choice = scanner.nextLine();

        while (!choice.equals("1") && !choice.equals("2"))
        {
            System.out.println("Invalid choice. Please enter 1 or 2.");
            System.out.print("Choose an option: ");
            choice = scanner.nextLine();
        }

        boolean doublePoints = false;
        boolean secondChance = false;

        if (choice.equals("2"))
        {
            boolean powerUpSelected = false;

            while (!powerUpSelected)
            {
                String powerUp = selectPowerUp();

                if (player.usePowerUp(powerUp))
                {
                    powerUpSelected = true;

                    if (powerUp.equals("Hint"))
                    {
                        System.out.println(
                            "Hint: " + question.getHint());
                    }
                    else if (powerUp.equals("50/50"))
                    {
                        choices = question.getFiftyFiftyChoices();

                        System.out.println("Remaining choices:");

                        for (int i = 0; i < choices.length; i++)
                        {
                            System.out.println(
                                (i + 1) + ". " + choices[i]);
                        }
                    }
                    else if (powerUp.equals("Double Points"))
                    {
                        doublePoints = true;
                        System.out.println(
                            "Double Points activated!");
                    }
                    else if (powerUp.equals("Second Chance"))
                    {
                        secondChance = true;
                        System.out.println(
                            "Second Chance activated!");
                    }
                }
                else
                {
                    System.out.println(
                        "That power-up has already been used.");
                    System.out.println(
                        "Please choose another power-up.");
                }
            }
        }

        System.out.print("Enter your answer: ");
        String answer = scanner.nextLine();

        processAnswer(
            answer,
            question,
            player,
            choices,
            doublePoints,
            secondChance);
    }
    
    
    /**
     * Checks the player's answer and updates the player's points
     * and streak. Also handles Double Points and Second Chance.
     *
     * @param answer
     *     the answer choice entered by the player
     * @param question
     *     the question being answered
     * @param player
     *     the player answering the question
     * @param choices
     *     the answer choices currently available to the player
     * @param doublePoints
     *     whether Double Points is active
     * @param secondChance
     *     whether Second Chance is active
     */
    public void processAnswer(
        String answer,
        Question question,
        Player player,
        String[] choices,
        boolean doublePoints,
        boolean secondChance)
    {
        int numberOfChoices = choices.length;

        while (!validAnswer(answer, numberOfChoices))
        {
            System.out.println("Invalid answer.");
            System.out.print(
                "Enter a number between 1 and "
                    + numberOfChoices + ": ");
            answer = scanner.nextLine();
        }

        int choiceIndex = Integer.parseInt(answer) - 1;
        String selectedAnswer = choices[choiceIndex];

        boolean correct = question.checkAnswer(selectedAnswer);

        if (!correct && secondChance)
        {
            System.out.println(
                "Incorrect. Second Chance activated!");
            System.out.print("Enter another answer: ");
            answer = scanner.nextLine();

            while (!validAnswer(answer, numberOfChoices))
            {
                System.out.println("Invalid answer.");
                System.out.print(
                    "Enter a number between 1 and "
                        + numberOfChoices + ": ");
                answer = scanner.nextLine();
            }

            choiceIndex = Integer.parseInt(answer) - 1;
            selectedAnswer = choices[choiceIndex];
            correct = question.checkAnswer(selectedAnswer);
        }

        if (correct)
        {
            System.out.println("Correct!");

            int points = getQuestionPoints(question);

            if (doublePoints)
            {
                points = points * 2;
            }

            player.addPoints(points);
            player.processStreak(true);

            System.out.println(
                "You earned " + points + " points!");
        }
        else
        {
            System.out.println("Incorrect.");
            player.processStreak(false);
        }
    }
    
    
    /**
     * Ends the current game, determines the winner or winners,
     * displays final scores, and saves each player's profile.
     */
    public void endGame()
    {
        int highestScore = 0;

        for (Player player : players)
        {
            if (player.getPoints() > highestScore)
            {
                highestScore = player.getPoints();
            }
        }

        System.out.println();
        System.out.println("Game Over!");
        System.out.println("Final Scores:");

        for (Player player : players)
        {
            System.out.println(
                player.getName() + ": " + player.getPoints()
                    + " points");
        }

        System.out.println();
        System.out.println("Winner(s):");

        for (Player player : players)
        {
            if (player.getPoints() == highestScore)
            {
                System.out.println(player.getName());
                player.addWin();
            }
        }

        for (Player player : players)
        {
            save.savePlayer(player);
        }
    }

    // ~ Private Helper Methods ................................................


    /**
     * Creates a new player profile and adds the player to the current game.
     */
    private void createPlayer()
    {
        System.out.print(
            "Enter your name (15 Characters max, only lowercase English "
            + "letters.): ");
        String name = scanner.nextLine();

        while (!validName(name))
        {
            System.out.println(
                "Invalid name. Names must contain 1-15 lowercase letters only.");
            System.out.print("Enter your name: ");
            name = scanner.nextLine();
        }

        if (save.playerExists(name))
        {
            System.out.println("A profile with that name already exists.");
            return;
        }

        if (playerAlreadyAdded(name))
        {
            System.out.println("That player is already in the game.");
            return;
        }

        Player player = new Player(name);
        players.add(player);

        System.out.println("Profile created for " + name + ".");
    }


    /**
     * Loads an existing player profile and adds the player to the current game.
     */
    private void loadPlayer()
    {
        System.out.print("Enter your profile name: ");
        String name = scanner.nextLine();

        while (!validName(name))
        {
            System.out.println(
                "Invalid name. Names must contain 1-15 lowercase letters only.");
            System.out.print("Enter your profile name: ");
            name = scanner.nextLine();
        }

        if (playerAlreadyAdded(name))
        {
            System.out.println("That player is already in the game.");
            return;
        }

        if (!save.playerExists(name))
        {
            System.out.println("Profile not found.");
            return;
        }

        Player player = save.loadPlayer(name);
        players.add(player);

        System.out.println("Welcome back, " + player.getName() + "!");
    }


    /**
     * Checks whether a player name is valid. A valid name must contain only
     * lowercase letters and be between 1 and 15 characters long.
     *
     * @param name
     *            the player name to check
     * @return true if the name is valid, false otherwise
     */
    private boolean validName(String name)
    {
        return name.matches("[a-z]{1,15}");
    }


    /**
     * Checks whether a player profile is already participating in the current
     * game.
     *
     * @param name
     *            the name of the player to check
     * @return true if the player is already in the game, false otherwise
     */
    private boolean playerAlreadyAdded(String name)
    {
        for (Player player : players)
        {
            if (player.getName().equalsIgnoreCase(name))
            {
                return true;
            }
        }

        return false;
    }
    
    
    /**
     * Prompts the player to select a question category.
     *
     * @return the selected category as a String
     */
    private String selectCategory()
    {
        while (true)
        {
            System.out.println("Choose a category:");
            System.out.println("1. Math");
            System.out.println("2. Science");
            System.out.println("3. Sports");
            System.out.println("4. History");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            if (choice.equals("1"))
            {
                return "Math";
            }
            else if (choice.equals("2"))
            {
                return "Science";
            }
            else if (choice.equals("3"))
            {
                return "Sports";
            }
            else if (choice.equals("4"))
            {
                return "History";
            }
            else
            {
                System.out.println("Invalid choice. Please enter 1-4.");
            }
        }
    }
    
    
    /**
     * Prompts the player to select a question difficulty.
     *
     * @return the selected difficulty as a String
     */
    private String selectDifficulty()
    {
        while (true)
        {
            System.out.println("Choose a difficulty:");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            if (choice.equals("1"))
            {
                return "Easy";
            }
            else if (choice.equals("2"))
            {
                return "Medium";
            }
            else if (choice.equals("3"))
            {
                return "Hard";
            }
            else
            {
                System.out.println("Invalid choice. Please enter 1-3.");
            }
        }
    }
    
    
    /**
     * Prompts the player to select a power-up.
     *
     * @return the name of the selected power-up
     */
    private String selectPowerUp()
    {
        while (true)
        {
            System.out.println();
            System.out.println("Choose a power-up:");
            System.out.println("1. Hint");
            System.out.println("2. 50/50");
            System.out.println("3. Double Points");
            System.out.println("4. Second Chance");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            if (choice.equals("1"))
            {
                return "Hint";
            }
            else if (choice.equals("2"))
            {
                return "50/50";
            }
            else if (choice.equals("3"))
            {
                return "Double Points";
            }
            else if (choice.equals("4"))
            {
                return "Second Chance";
            }
            else
            {
                System.out.println(
                    "Invalid choice. Please enter 1-4.");
            }
        }
    }
    
    
    /**
     * Checks whether an answer is a valid numbered choice.
     *
     * @param answer
     *     the answer entered by the player
     * @param numberOfChoices
     *     the number of available choices
     * @return true if the answer is valid, false otherwise
     */
    private boolean validAnswer(String answer, int numberOfChoices)
    {
        try
        {
            int choice = Integer.parseInt(answer);
            return choice >= 1 && choice <= numberOfChoices;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
    
    
    /**
     * Determines the number of points a question is worth based
     * on its difficulty.
     *
     * @param question
     *     the question being scored
     * @return the number of points the question is worth
     */
    private int getQuestionPoints(Question question)
    {
        if (question.getDifficulty().equals("Easy"))
        {
            return 100;
        }
        else if (question.getDifficulty().equals("Medium"))
        {
            return 200;
        }
        else
        {
            return 300;
        }
    }
}
