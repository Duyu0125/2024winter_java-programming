package Q3;

public class OverloadMethods {
	
	public static void main(String[] args) {
        // Call the overloaded Add methods and store their results in variables
        int result1 = add(5, 10);               // Calls Method 1
        int result2 = add(2, 4, 6);            // Calls Method 2
        int result3 = add(2, 4, 6, 8);         // Calls Method 3

        // Display the results
        System.out.println("Result of add(5, 10): " + result1);
        System.out.println("Result of add(2, 4, 6): " + result2);
        System.out.println("Result of add(2, 4, 6, 8): " + result3);
    }

    // Method 1: Add two integers
    public static int add(int a, int b) {
        return a + b; // Adds the two integers 'a' and 'b' and returns the result
    }

    // Method 2: Add three integers
    public static int add(int a, int b, int c) {
        return a + b + c; // Adds the three integers 'a', 'b', and 'c' and returns the result
    }

    // Method 3: Add four integers
    public static int add(int a, int b, int c, int d) {
        return a + b + c + d; // Adds the four integers 'a', 'b', 'c', and 'd' and returns the result
    }

}



