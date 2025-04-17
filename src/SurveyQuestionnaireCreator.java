import java.util.*;

public class SurveyQuestionnaireCreator {

    private static SurveyManager surveyManager = new SurveyManager();

    public static void main(String[] args) {
        DataPersistence.loadQuestions(surveyManager.getQuestions());
        DataPersistence.loadResponses(surveyManager.getResponses());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSurvey Questionnaire System");
            System.out.println("1. Create Survey Question");
            System.out.println("2. View Survey Questions");
            System.out.println("3. Update Survey Question");
            System.out.println("4. Delete Survey Question");
            System.out.println("5. Respond to Survey");
            System.out.println("6. View Responses");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    createQuestion(scanner);
                    break;
                case 2:
                    viewQuestions();
                    break;
                case 3:
                    updateQuestion(scanner);
                    break;
                case 4:
                    deleteQuestion(scanner);
                    break;
                case 5:
                    respondToSurvey(scanner);
                    break;
                case 6:
                    viewResponses();
                    break;
                case 7:
                    saveData();
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void createQuestion(Scanner scanner) {
        System.out.println("Enter the survey question:");
        String question = scanner.nextLine();
        surveyManager.addQuestion(question);
        System.out.println("Survey question added successfully.");
    }

    private static void viewQuestions() {
        if (surveyManager.getQuestions().isEmpty()) {
            System.out.println("No questions found.");
        } else {
            System.out.println("Survey Questions:");
            for (int i = 0; i < surveyManager.getQuestions().size(); i++) {
                System.out.println((i + 1) + ". " + surveyManager.getQuestions().get(i));
            }
        }
    }

    private static void updateQuestion(Scanner scanner) {
        System.out.print("Enter the number of the question to update: ");
        int questionNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (questionNumber < 1 || questionNumber > surveyManager.getQuestions().size()) {
            System.out.println("Invalid question number.");
        } else {
            System.out.println("Enter the new question:");
            String newQuestion = scanner.nextLine();
            surveyManager.updateQuestion(questionNumber - 1, newQuestion);
            System.out.println("Survey question updated successfully.");
        }
    }

    private static void deleteQuestion(Scanner scanner) {
        System.out.print("Enter the number of the question to delete: ");
        int questionNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (questionNumber < 1 || questionNumber > surveyManager.getQuestions().size()) {
            System.out.println("Invalid question number.");
        } else {
            surveyManager.deleteQuestion(questionNumber - 1);
            System.out.println("Survey question deleted successfully.");
        }
    }

    private static void respondToSurvey(Scanner scanner) {
        if (surveyManager.getQuestions().isEmpty()) {
            System.out.println("No questions available for survey.");
            return;
        }

        System.out.println("Respond to the following questions:");

        for (SurveyQuestion question : surveyManager.getQuestions()) {
            System.out.println(question.getQuestion());
            System.out.print("Your answer: ");
            String response = scanner.nextLine();
            surveyManager.respondToSurvey(question.getQuestion(), response);
        }

        System.out.println("Your responses have been recorded.");
    }

    private static void viewResponses() {
        if (surveyManager.getResponses().isEmpty()) {
            System.out.println("No responses found.");
        } else {
            System.out.println("Survey Responses:");
            for (SurveyResponse response : surveyManager.getResponses()) {
                System.out.println(response);
            }
        }
    }

    private static void saveData() {
        DataPersistence.saveQuestions(surveyManager.getQuestions());
        DataPersistence.saveResponses(surveyManager.getResponses());
    }
}
