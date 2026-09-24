package game;

import java.util.ArrayList;
import java.util.Random;
/**
 * Tests the Question class
 * @authors Sophie Linton, Sebastian Pacheco, Anna-Maria Renalds
 * @version 2026.09.18
 */
public class QuestionTest extends student.TestCase
{
    //~ Fields ................................................................

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    

    // ----------------------------------------------------------
    /**
     * tests getQuestionText(), getCategory(), getDifficulty(), getHint() and get Choices()
     */
    public void testGetMethods()
    {
        String[] initialChoices = new String[] { "Paris", "London", "Berlin", "Madrid" };
        
        
        Question question = new Question(
            "What is the capital of France?",
            "Paris",
            "Geography",
            "Easy",
            initialChoices,
            "It starts with a P"
        );
       assertEquals("What is the capital of France?", question.getQuestionText());
       assertEquals("Geography", question.getCategory());
       assertEquals("Easy", question.getDifficulty());
       assertEquals("It starts with a P", question.getHint());
       assertSame(initialChoices, question.getChoices());
    }
        
      // ----------------------------------------------------------
    /**
     * tests the check answer method.
     */
    public void testCheckAnswer()
      {
          String[] initialChoices = new String[] { "Paris", "London", "Berlin", "Madrid" };
          
          
          Question question = new Question(
              "What is the capital of France?",
              "Paris",
              "Geography",
              "Easy",
              initialChoices,
              "It starts with a P"
          );
          
          assertTrue(question.checkAnswer("Paris"));
          assertFalse(question.checkAnswer("London"));
      }
  
      // ----------------------------------------------------------
    /**
     * tests the get fifty fifty choices method
     */
    public void testGetFiftyFiftyChoices()
      {
       String[] initialChoices = new String[] { "Paris", "London", "Berlin", "Madrid" };
          
          
          Question question = new Question(
              "What is the capital of France?",
              "Paris",
              "Geography",
              "Easy",
              initialChoices,
              "It starts with a P"
          );
          boolean truth = false;
          boolean falsehood = false;
          
          for(int i = 0; i < 100; i++)
          {
              String[] result = question.getFiftyFiftyChoices();
              
              assertEquals(2, result.length);
              
              boolean containsCorrect = result[0].equals("Paris")|| result[1].equals("Paris");
              assertTrue(containsCorrect);
              
              if
              (result[0].equals("Paris"))
              {
                  truth = true;
              }
              else if(result[1].equals(("Paris")))
              {
                  falsehood = true;
              }
          }
          
          assertTrue(truth);
          assertTrue(falsehood);
      }
    }


