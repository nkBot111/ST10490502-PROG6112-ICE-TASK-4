package quizapp;

import org.junit.jupiter.api.Test;
import quizapp.ChoiceQuestion;
import quizapp.TrueFalseQuestion;
import quizapp.Question;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionTest {

    @Test
    public void testTrueFalseQuestion_CorrectAnswer() {
        TrueFalseQuestion q = new TrueFalseQuestion("The human heart has four chambers.", "true");
        assertTrue(q.checkAnswer("true"));
    }

    @Test
    public void testTrueFalseQuestion_WrongAnswer() {
        TrueFalseQuestion q = new TrueFalseQuestion("Plants produce oxygen during photosynthesis.", "true");
        assertFalse(q.checkAnswer("false"));
    }

    @Test
    public void testChoiceQuestion_CorrectAnswer() {
        ChoiceQuestion q = new ChoiceQuestion("Which part of the plant conducts photosynthesis?");
        q.addChoice("Roots", false);
        q.addChoice("Leaves", true);
        q.addChoice("Stems", false);
        q.addChoice("Flowers", false);

        assertTrue(q.checkAnswer("2")); //Correct choice
    }

    @Test
    public void testChoiceQuestion_WrongAnswer() {
        ChoiceQuestion q = new ChoiceQuestion("Which organ filters blood in humans?");
        q.addChoice("Liver", false);
        q.addChoice("Kidneys", true);
        q.addChoice("Lungs", false);

        assertFalse(q.checkAnswer("1")); //Wrong choice
    }

    @Test
    public void testCaseInsensitiveTrueFalse() {
        TrueFalseQuestion q = new TrueFalseQuestion("Humans are mammals.", "true");
        assertTrue(q.checkAnswer("TRUE")); //Uppercase still correct
    }

    @Test
    public void testInvalidChoiceAnswer() {
        ChoiceQuestion q = new ChoiceQuestion("What gas do humans exhale?");
        q.addChoice("Oxygen", false);
        q.addChoice("Carbon Dioxide", true);

        assertFalse(q.checkAnswer("3")); //Out of range choice
    }
}
