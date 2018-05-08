package Domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class QuestionTest {

    Answer answer1 = new Answer("2");
    Answer answer2 = new Answer("3");
    Answer answer3 = new Answer("4");

    List<Answer> answers = new ArrayList<Answer>();

    String text = "1+1=";
    int weight = 100;

    Question questionGet;
    Question questionSet = new Question();

    @Before
    public void createQuestion(){
        questionGet = new Question(text, weight, answers, answer1);
    }

    @Test
    public void getAnswers() {
        assertEquals(questionGet.getAnswers(), answers);
    }

    @Test
    public void setAnswers() {
        questionSet.setAnswers(answers);

        assertEquals(questionSet.getAnswers(), answers);
    }

    @Test
    public void getText() {
        assertEquals(questionGet.getText(), text);
    }

    @Test
    public void setText() {
        questionSet.setText(text);

        assertEquals(questionSet.getText(), text);
    }

    @Test
    public void getWeight() {
        assertEquals(questionGet.getWeight(), weight);
    }

    @Test
    public void setWeight() {
        questionSet.setWeight(weight);

        assertEquals(questionSet.getWeight(), weight);
    }

    @Test
    public void getCorrectAnswer() {
        assertEquals(questionGet.getCorrectAnswer(), answer1);
    }

    @Test
    public void setCorrectAnswer() {
        questionSet.setCorrectAnswer(answer2);

        assertEquals(questionSet.getCorrectAnswer(), answer2);
    }
}