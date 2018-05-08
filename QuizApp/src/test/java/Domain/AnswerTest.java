package Domain;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AnswerTest {

    String text = "2";

    Answer answerGet = new Answer(text);
    Answer answerSet = new Answer();


    @Test
    public void getText() {
        assertEquals(answerGet.getText(), text);
    }

    @Test
    public void setText() {
        answerSet.setText(text);

        assertEquals(answerSet.getText(), text);
    }
}