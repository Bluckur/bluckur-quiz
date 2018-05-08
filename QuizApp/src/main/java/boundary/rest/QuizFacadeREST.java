package boundary.rest;

import Domain.Answer;
import Domain.Question;
import Service.QuestionService;
import com.google.gson.JsonObject;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("Rest")
public class QuizFacadeREST {

    @Inject
    QuestionService qs;

    @GET
    @Path("getQuestion")
    @Produces(MediaType.APPLICATION_JSON)
    public String getQuestion(){
        try {
            return getQuestionInJsonObject().toString();
        } catch (Exception e){
            return "{\"error\": \"0 Questions returned.\"}";
        }
    }

    @GET
    @Path("getQuestions/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getQuestions(@PathParam("amount")int amountOfQuestions){

        try {
            JsonObject questions = new JsonObject();
            for (int i = 0; i < amountOfQuestions; i++) {
                questions.add("question" + (i+1),getQuestionInJsonObject());
            }
            return questions.toString();
        } catch (Exception e){
            return "{\"error\": \"0 Questions returned.\"}";
        }

    }

    @POST
    @Path("addQuestion")
    @Produces(MediaType.APPLICATION_JSON)
    public void addQuestion(){
        qs.addQuestion();
    }

    @POST
    @Path("isAnswerCorrect/{questionid}/{answer}/{publickey}")
    @Produces(MediaType.APPLICATION_JSON)
    public String isAnswerCorrect(@PathParam("questionid")int questionId, @PathParam("answer")String answer, @PathParam("publickey")String publicKey){
        JsonObject json = new JsonObject();
        json.addProperty("id", questionId);

        try {
            boolean isQuestionCorrect = qs.isAnswerCorrect(questionId, answer);
            json.addProperty("correct", isQuestionCorrect);
        } catch (Exception e) {
            return "{\"error\": \"Could not process request.\"}";
        }

        Answer correctAnswer = qs.getCorrectAnswer(questionId);

        json.addProperty("correctAnswer", correctAnswer.getText());

        json.addProperty("secret", "afcbcedabcdadbecabedaabcbdeabcbbedabbadbcbadebadcbbfffaabc"); //TODO: define how this secret is made and implement it.

        return json.toString();
    }

    private JsonObject getQuestionInJsonObject(){
        Question question = qs.getRandomQuestion();

        JsonObject json = new JsonObject();

        json.addProperty("id", question.getId());
        json.addProperty("text", question.getText());
        json.addProperty("weight", question.getWeight());

        JsonObject jsonanswers = new JsonObject();

        for(Answer a : question.getAnswers()){
            jsonanswers.addProperty("text" + a.getId(), a.getText());
        }

        json.add("answers", jsonanswers);

        return json;
    }
}
