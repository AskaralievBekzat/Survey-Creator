import java.util.*;

public class SurveyManager {
    private List<SurveyQuestion> questions;
    private List<SurveyResponse> responses;

    public SurveyManager() {
        this.questions = new ArrayList<>();
        this.responses = new ArrayList<>();
    }

    // Add a new question
    public void addQuestion(String questionText) {
        SurveyQuestion question = new SurveyQuestion(questionText);
        questions.add(question);
    }

    // View all questions
    public List<SurveyQuestion> getQuestions() {
        return questions;
    }

    // Respond to the survey
    public void respondToSurvey(String question, String answer) {
        SurveyResponse response = new SurveyResponse(question, answer);
        responses.add(response);
    }

    // Get all responses
    public List<SurveyResponse> getResponses() {
        return responses;
    }

    // Update a question
    public boolean updateQuestion(int index, String newQuestionText) {
        if (index >= 0 && index < questions.size()) {
            questions.get(index).setQuestion(newQuestionText);
            return true;
        }
        return false;
    }

    // Delete a question
    public boolean deleteQuestion(int index) {
        if (index >= 0 && index < questions.size()) {
            questions.remove(index);
            return true;
        }
        return false;
    }
    public void exportToCSV() {
        DataPersistence.exportQuestionsToCSV(questions);
        DataPersistence.exportResponsesToCSV(responses);
    }

    public void importFromCSV() {
        DataPersistence.importQuestionsFromCSV(questions);
        DataPersistence.importResponsesFromCSV(responses);
    }
}
