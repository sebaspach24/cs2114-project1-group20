package game;

/**
 * Where the question objects are created.
 *
 * @authors Sophie Linton, Sebastian Pacheco, Anna-Maria Renalds
 * @version 2026.09.18
 */

public class Question
{
    //~ Fields ................................................................

    //~ Constructors ..........................................................

// ----------------------------------------------------------
/**
 * Create a new Question object.
 */
public Question()
{
    
}
    // ----------------------------------------------------------
    /**
     * returns the question as a string.
     * @return the question as a String
     */
    //~Public  Methods ........................................................
public String getQuestionText()
{
    return null;
}

// ----------------------------------------------------------
/**
 * returns a list of choices
 * @return a list of choices
 */
public String[] getChoices()
{
    return null;
}
// ----------------------------------------------------------
/**
 * Returns the String category of a question object
 * @return the String category
 */
public String getCategory()
{
    return null;
}

// ----------------------------------------------------------
/**
 * Returns the string difficulty of a question object
 * @return String difficulty
 */
public String getDifficulty()
{
    return null;
}

// ----------------------------------------------------------
/**
 * Returns true or false if answer is right
 * @param answer is the answer
 * @return answer correctness
 */
public boolean checkAnswer(String answer)
{
    return false;
}

// ----------------------------------------------------------
/**
 * Returns the String hint of a question object
 * @return String hint
 */
public String getHint()
{
    return null;
}

}
