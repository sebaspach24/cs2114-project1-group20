package game;

import java.util.ArrayList;
import java.util.Random;
/**
 * Tests the question bank class
 *
 * @authors Sophie Linton, Sebastian Pacheco, Anna-Maria Renalds
 * @version 2026.09.18
 */
public class QuestionBankTest extends student.TestCase
{
 
    /**
     * tests the get question method
     */

    
    public void testGetQuestion()
    {
        QuestionBank bank = new QuestionBank();
        
       
        
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
