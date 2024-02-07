package Q2;


import java.util.Random;

import javax.swing.JOptionPane;

public class Lotto {

	public static void main(String[] args) 
	{
		int userChoice; // Variable to store the user's chosen number.
        int numberOfTries = 5; // Total attempts the user has.
        boolean userLost = true;

        JOptionPane.showMessageDialog(null, "Welcome to the Lotto game!"); // Display a welcome message.

        while (numberOfTries > 0) { // Loop until the user runs out of attempts.
            userChoice = Integer.parseInt(JOptionPane.showInputDialog("Choose a number between 3 and 27:")); // Prompt the user for input.
            
            if (userChoice < 3 || userChoice > 27) { // Check if the user's input is valid.
                JOptionPane.showMessageDialog(null, "Oops! Please choose a number between 3 and 27.");
                continue; // Continue the loop if the input is invalid.
            }

            Lotto lotto = new Lotto(); // Create a new Lotto object.
            int[] lottoNumbers = lotto.getNumbers(); // Get the randomly generated lotto numbers.

            int sumOfLotto = 0; // Variable to check if the user matches the lotto numbers.
            for (int num = 0; num < lottoNumbers.length; num++) {
            	sumOfLotto += lottoNumbers[num]; // Calculate the sum of lotto numbers.
            }

            JOptionPane.showMessageDialog(
            		null, 
            		"Lotto numbers: " + lottoNumbers[0] + ", " + lottoNumbers[1] + ", " + lottoNumbers[2] + "\n" +
            		"Sum of lotto numbers: " + sumOfLotto + "\n" +
            		"Your guess: " + userChoice
            	); // Display the lotto numbers.
  

            if (userChoice == sumOfLotto) { // Check if the user's number matches the sum of lotto numbers.
                JOptionPane.showMessageDialog(null, "Congratulations! You've won!"); // Display a win message.
                userLost = false;
                break; // Exit the loop if the user wins.
            }

            numberOfTries--; // Decrease the remaining attempts.
        }
        
        if (userLost) { // Check if the user has used all attempts and didn't win.
            JOptionPane.showMessageDialog(null, "Sorry, you've used all your attempts. The computer wins!"); // Display a message that the computer wins.
        }

        
    }

	private int[] numbers; // Array to hold three integers
	private final Random randomNumber = new Random(); // Random number generator
	
	// Getters and setters
	public Random getRandomNumber() {
		return randomNumber;
	}
	
	public int[] getNumbers() {
		return numbers;
	}
	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}
	
	public Lotto() { // Constructor to initialize the Lotto object.
		super();
		numbers = new int[3]; // Assign array a size of 3 to store lotto numbers.
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = randomNumber.nextInt(1, 9); // Generate 3 random numbers between 1 and 9 and store them in the 'numbers' array.
		}
	}

}
