package Dao;

import Domain.Answer;
import Domain.Question;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Stateless
public class QuestionDaoJPA {

    @PersistenceContext
    EntityManager em;

    public Question getRandomQuestion() {
        try {
            Query countQuery = em.createNativeQuery("select count(*) from Question");
            long count = (Long)countQuery.getSingleResult();

            Random random = new Random();
            int number = random.nextInt((int)count);

            Query selectQuery = em.createQuery("select q from Question q");
            selectQuery.setFirstResult(number);
            selectQuery.setMaxResults(1);
            return (Question)selectQuery.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean isAnswerCorrect(int questionid, String answer) {

        Question question = em.find(Question.class, questionid);

        if(question.getCorrectAnswer().getText().equals(answer)){
            return true;
        } else {
            return false;
        }
    }

    public Answer getCorrectAnswer(int questionId) {
        Answer answer;

        Question question = em.find(Question.class, questionId);

        answer = question.getCorrectAnswer();

        return answer;
    }

    public void addQuestion(){
        //Question 1
        Answer answer1 = new Answer("2");
        Answer answer2 = new Answer("3");
        Answer answer3 = new Answer("4");

        List<Answer> Answers = new ArrayList<Answer>();

        Answers.add(answer1);
        Answers.add(answer2);
        Answers.add(answer3);

        Question question = new Question("1+1=", 100, Answers, answer1);

        em.persist(question);

        //Question 2
        Answer answer4 = new Answer("50");
        Answer answer5 = new Answer("25");
        Answer answer6 = new Answer("75");

        List<Answer> Answers2 = new ArrayList<Answer>();

        Answers2.add(answer4);
        Answers2.add(answer5);
        Answers2.add(answer6);

        Question question2 = new Question("5x5=", 200, Answers2, answer5);

        em.persist(question2);

        //Question 3
        Answer answer7 = new Answer("B");
        Answer answer8 = new Answer("C");
        Answer answer9 = new Answer("A");
        Answer answer10 = new Answer("D");

        List<Answer> Answers3 = new ArrayList<Answer>();

        Answers3.add(answer7);
        Answers3.add(answer8);
        Answers3.add(answer9);
        Answers3.add(answer10);

        Question question3 = new Question("After C comes...", 20, Answers3, answer10);

        em.persist(question3);
    }


}
