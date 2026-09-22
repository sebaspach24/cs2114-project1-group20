package game;

import java.util.ArrayList;
import java.util.Random;

/**
 * Stores the questions used in the trivia game and provides questions based on
 * category and difficulty.
 *
 * @authors Sophie Linton, Sebastian Pacheco, Anna-Maria Renalds
 * @version 2026.09.22
 */
public class QuestionBank
{
    // ~ Fields ................................................................

    private ArrayList<Question> questions;

    // ~ Constructors ..........................................................

    /**
     * Creates a new QuestionBank and initializes the list of questions.
     */
    public QuestionBank()
    {
        questions = new ArrayList<Question>();

        // ---------------------------------------------------------
        // Math - Easy
        // ---------------------------------------------------------

        questions.add(new Question(
            "What is 12 + 8?",
            "20",
            "Math",
            "Easy",
            new String[] { "18", "20", "22", "24" },
            "Add 10 and 8 first, then add 2."));

        questions.add(new Question(
            "What is 9 x 6?",
            "54",
            "Math",
            "Easy",
            new String[] { "45", "48", "54", "56" },
            "Think of 10 x 6, then subtract 6."));

        questions.add(new Question(
            "What is the square root of 81?",
            "9",
            "Math",
            "Easy",
            new String[] { "7", "8", "9", "10" },
            "What number multiplied by itself equals 81?"));


        // ---------------------------------------------------------
        // Math - Medium
        // ---------------------------------------------------------

        questions.add(new Question(
            "What is 15% of 200?",
            "30",
            "Math",
            "Medium",
            new String[] { "20", "25", "30", "35" },
            "10% of 200 is 20, and 5% is 10."));

        questions.add(new Question(
            "If 3x + 5 = 20, what is x?",
            "5",
            "Math",
            "Medium",
            new String[] { "3", "5", "7", "15" },
            "Subtract 5 from both sides first."));

        questions.add(new Question(
            "What is the area of a circle with radius 4?",
            "16pi",
            "Math",
            "Medium",
            new String[] { "8pi", "12pi", "16pi", "32pi" },
            "Use the formula A = pi times r squared."));


        // ---------------------------------------------------------
        // Math - Hard
        // ---------------------------------------------------------

        questions.add(new Question(
            "What is the derivative of x^3?",
            "3x^2",
            "Math",
            "Hard",
            new String[] { "x^2", "2x^2", "3x^2", "3x^3" },
            "Use the power rule."));

        questions.add(new Question(
            "What is the determinant of the matrix [[2, 3], [1, 4]]?",
            "5",
            "Math",
            "Hard",
            new String[] { "5", "6", "8", "11" },
            "For a 2 by 2 matrix, use ad - bc."));

        questions.add(new Question(
            "What is the sum of the interior angles of a hexagon?",
            "720 degrees",
            "Math",
            "Hard",
            new String[] {
                "540 degrees",
                "600 degrees",
                "720 degrees",
                "900 degrees"
            },
            "Use (n - 2) times 180 degrees."));


        // ---------------------------------------------------------
        // Science - Easy
        // ---------------------------------------------------------

        questions.add(new Question(
            "What planet is known as the Red Planet?",
            "Mars",
            "Science",
            "Easy",
            new String[] { "Venus", "Mars", "Jupiter", "Mercury" },
            "It is the fourth planet from the Sun."));

        questions.add(new Question(
            "What gas do humans need to breathe to survive?",
            "Oxygen",
            "Science",
            "Easy",
            new String[] { "Hydrogen", "Nitrogen", "Oxygen", "Helium" },
            "Its chemical symbol is O."));

        questions.add(new Question(
            "What is H2O commonly called?",
            "Water",
            "Science",
            "Easy",
            new String[] { "Salt", "Water", "Oxygen", "Hydrogen" },
            "You drink it every day."));


        // ---------------------------------------------------------
        // Science - Medium
        // ---------------------------------------------------------

        questions.add(new Question(
            "What organelle is known as the powerhouse of the cell?",
            "Mitochondria",
            "Science",
            "Medium",
            new String[] {
                "Nucleus",
                "Ribosome",
                "Mitochondria",
                "Golgi apparatus"
            },
            "It produces much of the cell's ATP."));

        questions.add(new Question(
            "What is the chemical symbol for gold?",
            "Au",
            "Science",
            "Medium",
            new String[] { "Ag", "Au", "Gd", "Go" },
            "The symbol comes from the Latin word aurum."));

        questions.add(new Question(
            "What force keeps planets in orbit around the Sun?",
            "Gravity",
            "Science",
            "Medium",
            new String[] {
                "Friction",
                "Magnetism",
                "Gravity",
                "Electricity"
            },
            "It is the same force that pulls objects toward Earth."));


        // ---------------------------------------------------------
        // Science - Hard
        // ---------------------------------------------------------

        questions.add(new Question(
            "What is the atomic number of carbon?",
            "6",
            "Science",
            "Hard",
            new String[] { "4", "6", "8", "12" },
            "It has six protons."));

        questions.add(new Question(
            "Which blood type is known as the universal red-cell donor?",
            "O negative",
            "Science",
            "Hard",
            new String[] {
                "A positive",
                "AB positive",
                "O positive",
                "O negative"
            },
            "This type lacks A, B, and Rh D antigens on its red cells."));

        questions.add(new Question(
            "What is the SI unit of electric resistance?",
            "Ohm",
            "Science",
            "Hard",
            new String[] { "Volt", "Ampere", "Ohm", "Watt" },
            "It is represented by the Greek letter omega."));


        // ---------------------------------------------------------
        // Sports - Easy
        // ---------------------------------------------------------

        questions.add(new Question(
            "How many points is a free throw worth in basketball?",
            "1",
            "Sports",
            "Easy",
            new String[] { "1", "2", "3", "4" },
            "It is the lowest-value scoring shot in basketball."));

        questions.add(new Question(
            "How many players from one team are on the court in basketball?",
            "5",
            "Sports",
            "Easy",
            new String[] { "4", "5", "6", "7" },
            "Think of the five traditional basketball positions."));

        questions.add(new Question(
            "In soccer, which body part may field players not intentionally "
                + "use to handle the ball?",
            "Hands",
            "Sports",
            "Easy",
            new String[] { "Head", "Chest", "Feet", "Hands" },
            "The goalkeeper is the major exception within the penalty area."));


        // ---------------------------------------------------------
        // Sports - Medium
        // ---------------------------------------------------------

        questions.add(new Question(
            "How many points is a touchdown worth in American football?",
            "6",
            "Sports",
            "Medium",
            new String[] { "3", "6", "7", "8" },
            "Do not include the extra-point attempt."));

        questions.add(new Question(
            "How many sets must a team win to win a standard best-of-five "
                + "volleyball match?",
            "3",
            "Sports",
            "Medium",
            new String[] { "2", "3", "4", "5" },
            "A team needs a majority of the five possible sets."));

        questions.add(new Question(
            "What is the regulation height of an NBA basketball hoop?",
            "10 feet",
            "Sports",
            "Medium",
            new String[] { "8 feet", "9 feet", "10 feet", "12 feet" },
            "The standard has remained unchanged for well over a century."));


        // ---------------------------------------------------------
        // Sports - Hard
        // ---------------------------------------------------------

        questions.add(new Question(
            "How many personal fouls cause an NBA player to foul out?",
            "6",
            "Sports",
            "Hard",
            new String[] { "4", "5", "6", "7" },
            "The NBA limit is one higher than the NCAA limit."));

        questions.add(new Question(
            "What is the maximum possible break in standard snooker?",
            "147",
            "Sports",
            "Hard",
            new String[] { "127", "137", "147", "157" },
            "It normally requires 15 reds with 15 blacks, then all six colors."));

        questions.add(new Question(
            "How long is an Olympic swimming pool?",
            "50 meters",
            "Sports",
            "Hard",
            new String[] {
                "25 meters",
                "40 meters",
                "50 meters",
                "100 meters"
            },
            "It is twice the length of a common short-course meter pool."));


        // ---------------------------------------------------------
        // History - Easy
        // ---------------------------------------------------------

        questions.add(new Question(
            "Who was the first president of the United States?",
            "George Washington",
            "History",
            "Easy",
            new String[] {
                "Thomas Jefferson",
                "George Washington",
                "Abraham Lincoln",
                "John Adams"
            },
            "He also commanded the Continental Army."));

        questions.add(new Question(
            "In what year did the United States declare independence?",
            "1776",
            "History",
            "Easy",
            new String[] { "1492", "1776", "1789", "1812" },
            "Think of the date celebrated every July 4."));

        questions.add(new Question(
            "Which ancient civilization built the pyramids at Giza?",
            "Egyptians",
            "History",
            "Easy",
            new String[] {
                "Romans",
                "Greeks",
                "Egyptians",
                "Vikings"
            },
            "They developed along the Nile River."));


        // ---------------------------------------------------------
        // History - Medium
        // ---------------------------------------------------------

        questions.add(new Question(
            "Which war was fought between the Union and Confederacy?",
            "American Civil War",
            "History",
            "Medium",
            new String[] {
                "War of 1812",
                "American Civil War",
                "Spanish-American War",
                "Revolutionary War"
            },
            "It took place from 1861 to 1865."));

        questions.add(new Question(
            "Who was the principal author of the Declaration of Independence?",
            "Thomas Jefferson",
            "History",
            "Medium",
            new String[] {
                "George Washington",
                "Benjamin Franklin",
                "Thomas Jefferson",
                "James Madison"
            },
            "He later became the third U.S. president."));

        questions.add(new Question(
            "Which empire used Constantinople as its capital for most of "
                + "its history?",
            "Byzantine Empire",
            "History",
            "Medium",
            new String[] {
                "Roman Republic",
                "Byzantine Empire",
                "Mongol Empire",
                "British Empire"
            },
            "It was the continuation of the Roman Empire in the east."));


        // ---------------------------------------------------------
        // History - Hard
        // ---------------------------------------------------------

        questions.add(new Question(
            "Which treaty formally ended World War I between Germany and "
                + "the Allied powers?",
            "Treaty of Versailles",
            "History",
            "Hard",
            new String[] {
                "Treaty of Paris",
                "Treaty of Versailles",
                "Treaty of Ghent",
                "Treaty of Utrecht"
            },
            "It was signed in 1919 near Paris."));

        questions.add(new Question(
            "Which empire was ruled by Mansa Musa in the 14th century?",
            "Mali Empire",
            "History",
            "Hard",
            new String[] {
                "Ottoman Empire",
                "Mali Empire",
                "Songhai Empire",
                "Roman Empire"
            },
            "It was a wealthy West African empire."));

        questions.add(new Question(
            "The Magna Carta was originally issued in what year?",
            "1215",
            "History",
            "Hard",
            new String[] { "1066", "1215", "1492", "1648" },
            "King John agreed to it in the early 13th century."));
    }

    // ~ Public Methods ........................................................


    /**
     * Returns a random question that matches the given category and difficulty.
     * The selected question is removed from the question bank so that it cannot
     * be selected again during the current game.
     *
     * @param category
     *            the category of the requested question
     * @param difficulty
     *            the difficulty of the requested question
     * @return a random matching Question, or null if no matching question
     *             exists
     */
    public Question getQuestion(String category, String difficulty)
    {
        ArrayList<Question> matchingQuestions = new ArrayList<Question>();

        // This loop goes through and finds all matching questions, populating
        // them into matchingQuestions

        for (Question question : questions)
        {
            if (question.getCategory().equals(category)
                && question.getDifficulty().equals(difficulty))
            {
                matchingQuestions.add(question);
            }
        }

        if (matchingQuestions.isEmpty())
        {
            return null;
        }

        // This then selects a random question, and then removes it from the
        // available list.
        Random random = new Random();
        int index = random.nextInt(matchingQuestions.size());

        Question selectedQuestion = matchingQuestions.get(index);

        questions.remove(selectedQuestion);

        return selectedQuestion;
    }
}
