package Domain;

import javax.enterprise.inject.Model;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@Model
@XmlRootElement
@NamedQuery(name = "Question.all", query = "select u from Question u")
public class Question {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private int id;

    private String text;

    private int weight;

    @OneToMany(targetEntity = Answer.class, cascade = CascadeType.ALL)
    private List<Answer> Answers;

    @OneToOne(cascade = CascadeType.ALL)
    private Answer correctAnswer;


    public Question(String text, int weight, List<Answer> answers, Answer correctAnswer) {

        this.id = id;
        this.text = text;
        this.weight = weight;
        Answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public Question(String text, int weight, List<Answer> answers) {

        this.id = id;
        this.text = text;
        this.weight = weight;
        Answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public Question() {
    }

    public List<Answer> getAnswers() {
        return Answers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAnswers(List<Answer> answers) {
        Answers = answers;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getId() {
        return id;
    }
}
