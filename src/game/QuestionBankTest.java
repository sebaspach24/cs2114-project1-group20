package game;

import java.util.ArrayList;
import java.util.Random;

public class QuestionBankTest extends student.TestCase
{
    //~ Fields ................................................................

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    
    public void testGetQuestion()
    {
        QuestionBank bank = new QuestionBank();
        
        Question noMatch = bank.getQuestion("History", "Hard");
        
        Question q1 = bank.getQuestion("Math", "Easy");
        assertNotNull(q1);
        Question q2 = bank.getQuestion("Math", "Easy");
        assertNotNull(q2);
        Question q3 = bank.getQuestion("Math", "Easy");
        assertNotNull(q3);
        Question q4 = bank.getQuestion("Math", "Easy");
        assertNull(q4);
    }

}
