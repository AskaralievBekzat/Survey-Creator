import java.io.*;
import java.util.*;

public class DataPersistence {

    private static final String QUESTIONS_FILE = "questions.txt";
    private static final String RESPONSES_FILE = "responses.txt";

    public static void loadQuestions(List<SurveyQuestion> questions) {
        try (BufferedReader reader = new BufferedReader(new FileReader(QUESTIONS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                questions.add(new SurveyQuestion(line));
            }
        } catch (IOException e) {
            System.out.println("Error loading questions.");
        }
    }

    public static void saveQuestions(List<SurveyQuestion> questions) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(QUESTIONS_FILE))) {
            for (SurveyQuestion question : questions) {
                writer.write(question.getQuestion());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving questions.");
        }
    }

    public static void loadResponses(List<SurveyResponse> responses) {
        try (BufferedReader reader = new BufferedReader(new FileReader(RESPONSES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    responses.add(new SurveyResponse(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading responses.");
        }
    }

    public static void saveResponses(List<SurveyResponse> responses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RESPONSES_FILE))) {
            for (SurveyResponse response : responses) {
                writer.write(response.getQuestion() + "," + response.getAnswer());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving responses.");
        }
    }
}
