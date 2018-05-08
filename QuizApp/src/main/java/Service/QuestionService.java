package Service;

import Dao.QuestionDaoJPA;
import Domain.Answer;
import Domain.Question;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class QuestionService {

    @Inject
    private QuestionDaoJPA questionDao;

    public Question getRandomQuestion() { return questionDao.getRandomQuestion();}

    public void addQuestion(){ questionDao.addQuestion(); }

    public boolean isAnswerCorrect(int questionId, String answer) { return questionDao.isAnswerCorrect(questionId, answer); }

    public Answer getCorrectAnswer(int questionId) { return questionDao.getCorrectAnswer(questionId); }
}
