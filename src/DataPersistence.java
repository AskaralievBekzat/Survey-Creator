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



        private static final String QUESTIONS_CSV = "questions.csv";
        private static final String RESPONSES_CSV = "responses.csv";

        // Export questions to CSV file
        public static void exportQuestionsToCSV(List<SurveyQuestion> questions) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(QUESTIONS_CSV))) {
                writer.write("Question\n");
                for (SurveyQuestion question : questions) {
                    writer.write(question.getQuestion() + "\n");
                }
                System.out.println("Survey questions exported successfully to questions.csv.");
            } catch (IOException e) {
                System.out.println("Error exporting questions to CSV: " + e.getMessage());
            }
        }

        // Export responses to CSV file
        public static void exportResponsesToCSV(List<SurveyResponse> responses) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(RESPONSES_CSV))) {
                writer.write("Question,Answer\n");
                for (SurveyResponse response : responses) {
                    writer.write(response.getQuestion() + "," + response.getAnswer() + "\n");
                }
                System.out.println("Survey responses exported successfully to responses.csv.");
            } catch (IOException e) {
                System.out.println("Error exporting responses to CSV: " + e.getMessage());
            }
        }


        // Import questions from CSV file
        public static void importQuestionsFromCSV(List<SurveyQuestion> questions) {
            try (BufferedReader reader = new BufferedReader(new FileReader(QUESTIONS_CSV))) {
                String line;
                reader.readLine(); // Skip header
                while ((line = reader.readLine()) != null) {
                    questions.add(new SurveyQuestion(line));
                }
                System.out.println("Survey questions imported successfully from questions.csv.");
            } catch (IOException e) {
                System.out.println("Error importing questions from CSV: " + e.getMessage());
            }
        }

        // Import responses from CSV file
        public static void importResponsesFromCSV(List<SurveyResponse> responses) {
            try (BufferedReader reader = new BufferedReader(new FileReader(RESPONSES_CSV))) {
                String line;
                reader.readLine(); // Skip header
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",", 2);
                    if (parts.length == 2) {
                        responses.add(new SurveyResponse(parts[0], parts[1]));
                    }
                }
                System.out.println("Survey responses imported successfully from responses.csv.");
            } catch (IOException e) {
                System.out.println("Error importing responses from CSV: " + e.getMessage());
            }
        }
}
