package Domain;

import javax.enterprise.inject.Model;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Model
@XmlRootElement
@NamedQuery(name = "Answer.all", query = "select a from Answer a")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String text;

    public Answer(String text){
        this.text = text;
    }

    public Answer(){

    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
