package game;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a question in the trivia game along with its associated
 * information.
 *
 * @authors Sophie Linton, Sebastian Pacheco, Anna-Maria Renalds
 * @version 2026.09.22
 */
public class Question
{
    //~ Fields ................................................................

    private String questionText;
    private String correctAnswer;
    private String category;
    private String difficulty;
    private String[] choices;
    private String hint;


    //~ Constructors ..........................................................

    /**
     * Creates a new Question object.
     *
     * @param questionText
     *     the text of the question
     * @param correctAnswer
     *     the correct answer to the question
     * @param category
     *     the category of the question
     * @param difficulty
     *     the difficulty of the question
     * @param choices
     *     the possible answer choices
     * @param hint
     *     the hint associated with the question
     */
    public Question(
        String questionText,
        String correctAnswer,
        String category,
        String difficulty,
        String[] choices,
        String hint)
    {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.category = category;
        this.difficulty = difficulty;
        this.choices = choices;
        this.hint = hint;
    }


    //~ Public Methods ........................................................

    /**
     * Returns the question text.
     *
     * @return the question as a String
     */
    public String getQuestionText()
    {
        return questionText;
    }


    /**
     * Returns the possible answer choices.
     *
     * @return an array containing the answer choices
     */
    public String[] getChoices()
    {
        return choices;
    }


    /**
     * Returns the category of the question.
     *
     * @return the category as a String
     */
    public String getCategory()
    {
        return category;
    }


    /**
     * Returns the difficulty of the question.
     *
     * @return the difficulty as a String
     */
    public String getDifficulty()
    {
        return difficulty;
    }


    /**
     * Checks whether the given answer is the correct answer.
     *
     * @param answer
     *     the answer to check
     * @return true if the answer is correct, false otherwise
     */
    public boolean checkAnswer(String answer)
    {
        return correctAnswer.equals(answer);
    }


    /**
     * Returns the hint associated with the question.
     *
     * @return the hint as a String
     */
    public String getHint()
    {
        return hint;
    }
    
    
    /**
     * Returns the correct answer and one randomly selected incorrect answer
     * in a random order for use with the 50/50 power-up.
     *
     * @return an array containing two possible answer choices
     */
    public String[] getFiftyFiftyChoices()
    {
        ArrayList<String> incorrectChoices = new ArrayList<String>();

        for (String choice : choices)
        {
            if (!choice.equals(correctAnswer))
            {
                incorrectChoices.add(choice);
            }
        }

        Random random = new Random();
        String incorrectAnswer =
            incorrectChoices.get(random.nextInt(incorrectChoices.size()));

        String[] fiftyFifty = new String[2];

        if (random.nextBoolean())
        {
            fiftyFifty[0] = correctAnswer;
            fiftyFifty[1] = incorrectAnswer;
        }
        else
        {
            fiftyFifty[0] = incorrectAnswer;
            fiftyFifty[1] = correctAnswer;
        }

        return fiftyFifty;
    }
}