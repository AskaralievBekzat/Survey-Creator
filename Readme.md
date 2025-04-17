# Survey Questionnaire Creator

## Description
Survey Questionnaire Creator is a Java-based application designed to facilitate the creation, modification, and participation in survey questionnaires. It provides an intuitive console-based interface for users to manage survey questions and record responses while ensuring data persistence through file handling.

## Student Information
**Name:** Bekzat Askaraliev  
**Institution:** Ala-Too International University  
**Course:** Programming Languages II (Java)

## Objectives
- Allow users to create and manage survey questions.
- Enable respondents to provide answers to survey questions.
- Maintain persistent storage for survey questions and responses.
- Ensure easy retrieval and modification of survey data.
- Implement error handling for invalid user inputs.
- Provide a user-friendly and efficient survey management system.
## Project Requirement List
1. Implement a user interface for survey questionnaire management.
2. Develop functionality to create new survey questions.
3. Allow users to view existing survey questions.
4. Provide an option to edit and update survey questions.
5. Enable deletion of survey questions.
6. Allow users to submit responses to surveys.
7. Implement a feature to view recorded responses.
8. Ensure persistent storage of survey data using file handling.
9. Validate user inputs to prevent errors and inconsistencies.
10. Develop a well-structured object-oriented design for efficient management.
### **Algorithms Used**
1. **Data Persistence Algorithm**
    - File-based storage mechanism using BufferedReader and BufferedWriter.
    - Ensures that survey questions and responses remain available after the application is closed.

2. **Survey Management Algorithm**
    - Uses an ArrayList to store and retrieve survey questions efficiently.
    - Provides search and update functionalities for easy access.

### **Data Structures Used**
- **ArrayList:** Used to store survey questions and responses dynamically.
- **String Handling:** Used for input parsing and formatting.
- **File Handling:** Implements text file operations for storing survey data persistently.

### **Functions/Modules Implemented**
- **createQuestion()** – Adds new survey questions.
- **viewQuestions()** – Displays all available questions.
- **updateQuestion()** – Modifies existing survey questions.
- **deleteQuestion()** – Removes unwanted survey questions.
- **respondToSurvey()** – Allows users to provide responses to questions.
- **viewResponses()** – Displays collected survey responses.
- **saveData()** – Stores survey questions and responses to files.

### **Challenges Faced**
- Handling input validation to prevent invalid entries.
- Managing file reading/writing efficiently to avoid data corruption.
- Implementing structured error handling to improve system stability.
## Test Cases and Outputs
### **Test Case 1: Adding a New Survey Question**
**Input:**![Image](https://github.com/user-attachments/assets/656f4122-9071-410b-9a51-b081dbffdddd)

### **Test Case 2: Viewing Survey Questions**
**Input:**![Image](https://github.com/user-attachments/assets/b71a6d83-1d2a-4433-895b-f3c205877f6e)
