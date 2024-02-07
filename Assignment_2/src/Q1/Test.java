package Q1;

import java.util.Random;
import javax.swing.JOptionPane;

public class Test {
	

    public static void main(String[] args) {
        Test test = new Test();
        test.inputAnswer(); // Start the test
    }

    private int correctAnswers = 0; // Counter for correct answers
    private int incorrectAnswers = 0; // Counter for incorrect answers
    private final Random randomNumber = new Random(); // Random number generator

    // Array to store the questions
    private String[] questions = 
    	{
            "What is the main function of a Java compiler?\n" +
                    "1. It examines the bytecodes to ensure that they are valid and do not violate Java’s security restrictions.\n" +
                    "2. It executes the bytecodes\n" +
                    "3. It places the program in memory to execute it\n" +
                    "4. It translates the Java source code into bytecodes that represent the tasks to execute.",
                    
            "Method arguments may be______________________________.\n" +
                    "1. only constants.\n" +
                    "2. only strings.\n" +
                    "3. constants, variables, or expressions.\n" +
                    "4. only variables",
                    
            "Which one of the following symbols indicates a single line comment in Java application source code:\n" +
                    "1. #!\n" +
                    "2. \\\n" +
                    "3. //\n" +
                    "4. ##",
                    
            "What does Math static method Math.ceil(x) do?\n" +
                    "1. Rounds x to the largest integer not greater than x.\n" +
                    "2. Round x to the smallest integer not less than x\n" +
                    "3. Rounds x to the smallest integer smaller than x.\n" +
                    "4. Rounds x to its absolute value.",
                    
            "Which of the following components does a Java application need to have at least one of?\n" +
                    "1. Non-static Method\n" +
                    "2. Local variable\n" +
                    "3. Class\n" +
                    "4. Instance variable"
    };
    
    // Getters and setters
    public int getCorrectAnswers() {
		return correctAnswers;
	}
	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public int getIncorrectAnswers() {
		return incorrectAnswers;
	}
	public void setIncorrectAnswers(int incorrectAnswers) {
		this.incorrectAnswers = incorrectAnswers;
	}

	public String[] getQuestions() {
		return questions;
	}

	public void setQuestions(String[] questions) {
		this.questions = questions;
	}

	public Random getRandomNumber() {
		return randomNumber;
	}

    // Simulates the question for the user
    private int simulateQuestion(String question) {
    	
        String[] questionOptions = {"1", "2", "3", "4"};
        // Display the question as a dialog with multiple choice options and get user's choice
        int userAnswer = JOptionPane.showOptionDialog(
        		null, // component
        		question, // message object 
        		"Question", // message title
        		JOptionPane.DEFAULT_OPTION, // option type
                JOptionPane.QUESTION_MESSAGE, // message type
                null, //icon
                questionOptions, //options
                null // default value
            ); 
        return userAnswer + 1; // increments userAnswer by one to match the questionOptions range
    }

    // Checks if the answer is correct or not
    private int checkAnswer(int questionNumber) {
        // Get the correct answer for the question based on the question number
        switch (questionNumber) {
            case 0:
                return 4;
            case 1:
                return 3;
            case 2:
                return 3;
            case 3:
                return 2;
            case 4:
                return 3;
            default:
                return -1;
        }
    }

    // Displays a random message to the user depending on the answer
    private String generateMessage(boolean isCorrect) {
        int responseNumber = getRandomNumber().nextInt(1, 4); // Generate a random number (1 to 4)
        switch (responseNumber) {
            case 1:
                return isCorrect ? "Excellent!" : "No. Please try again";
            case 2:
                return isCorrect ? "Good!" : "Wrong. Try once more";
            case 3:
                return isCorrect ? "Keep up the good work!" : "Don't give up!";
            case 4:
                return isCorrect ? "Nice work!" : "No. Keep trying..";
            default:
                return "";
        }
    }
    

    // Interacts with the user
    public void inputAnswer() {
    	int rightCount = 0, wrongCount = 0;
        for (int questionNumber = 0; questionNumber <= 4; questionNumber++) 
        {
            String question = getQuestions()[questionNumber];// Get the question
            int userAnswer = simulateQuestion(question); // Display the question and get user's answer
            int rightAnswer = checkAnswer(questionNumber); // Get the correct answer for the question

            if (userAnswer == rightAnswer) { // Check if the user's answer is correct
                String congratsMessage = generateMessage(true); // Generate a congratulatory message
                JOptionPane.showMessageDialog(null, congratsMessage); // Display the message
                rightCount++;
                setCorrectAnswers(rightCount);
                //correctAnswers++; // Increment correct answer count
            } 
            else 
            {
                String errorMessage = generateMessage(false); // Generate an error message
                JOptionPane.showMessageDialog(null, errorMessage); // Display the message
                wrongCount++;
                setIncorrectAnswers(wrongCount); // Increment incorrect answer count
            }
        }
        
        double percentage = (getCorrectAnswers() * 100.0) / 5; // Calculate the percentage of correct answers
        String resultMessage = // Display results to user
        		"Correct Answers: " + getCorrectAnswers() + "\n" +
                "Incorrect Answers: " + getIncorrectAnswers() + "\n" +
                "Percentage: " + percentage + "%";

        // Display the test results in a dialog
        JOptionPane.showMessageDialog(null, resultMessage, "Test Results", JOptionPane.INFORMATION_MESSAGE);
        
    }
}
