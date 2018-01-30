
/* Lab 7
 * Emily Blanford 
 * 1/29/2018
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab7 {

	public static void main(String[] args) {
		// Create parallel arrays & index variable
		Scanner scan = new Scanner(System.in);
		String[] studentFirstName = { "Abdul", "Alex", "Andrew", "Anna", "Antonella", "Ben", "Blaise", "Brad", "Cara",
				"Celena", "Charlene", "Cody", "David", "Emily", "James", "Jennifer", "Jordan", "Kassondra", "Kim",
				"Maurice" };
		String[] studentLastName = { "Shaamala", "Brozovich", "Calabro-Cavin", "Farr", "Solomon", "Fogt", "PascalG",
				"Malarkey", "Reaume", "Mancina", "Donelson", "Grant", "Musko", "Blanford", "Drain", "Cline", "Zwart",
				"Jones", "Driscoll", "Tedder" };
		String[] hometown = { "Detroit, MI", "Chicago, IL", "Phoenix, AZ", "Hartford, CT", "Lansing, MI", "Detroit, MI",
				"Chicago, IL", "Phoenix, AZ", "Hartford, CT", "Lansing, MI", "Detroit, MI", "Chicago, IL",
				"Phoenix, AZ", "Hartford, CT", "Lansing, MI", "Detroit, MI", "Chicago, IL", "Phoenix, AZ",
				"Hartford, CT", "Lansing, MI" };
		String[] favoriteFood = { "pasta", "pizza", "everything", "anything homemade", "fried chicken", "pasta",
				"pizza", "everything", "anything homemade", "fried chicken", "pasta", "pizza", "everything",
				"anything homemade", "fried chicken", "pasta", "pizza", "everything", "anything homemade",
				"fried chicken" };
		int i;

		// Variables
		String cont = "yes";
		String info;
		
		// Greeting and prompt for index of student
		System.out.print(
				"Welcome to our Java class. Which student would you like to learn more about? (enter a number 1-20): ");

		while (cont.equalsIgnoreCase("yes")) {
			// store user index & output name, Prompt for desired information
			try {
				i = scan.nextInt();
				System.out.print("\nStudent " + i + " is " + studentFirstName[i - 1] + " " + studentLastName[i - 1]
						+ ". What would you like to know about " + studentFirstName[i - 1]
						+ "? (enter \"hometown\" or \"favorite food\"): ");
				scan.nextLine();
				// runs until 1-20 is entered
			} catch (IndexOutOfBoundsException e) {
				System.out.print("\nThat student does not exist. Please try again. (enter a number 1-20): ");
				scan.nextLine();
				continue;
			} catch (InputMismatchException e) {
				System.out.print("\nThat was not a number between 1 and 20. Please try again: ");
				scan.nextLine();
				continue;
			}

			// stores desired information field & outputs that field
			while (cont.equalsIgnoreCase("yes")) {
				try {
					info = scan.nextLine();
					switch (info) {
					case "hometown":
						System.out.println("\n" + studentFirstName[i - 1] + " is from " + hometown[i - 1] + ".");
						break;
					case "favorite food":
						System.out
								.println(
										"\n" + studentFirstName[i - 1] + " loves to eat " + favoriteFood[i - 1] + ". ");
						break;
					default:
						throw new IllegalArgumentException();
					}
				}
				// prompts until correct data field is entered
				catch (IllegalArgumentException e) {
					System.out.print(
							"\nThat data does not exist. Please try again. (enter \"hometown\" or \"favorite food\"): ");
					continue;
				}
				// breaks out when information is given
				cont = "no";

			}

			// continue with another student?
			System.out.print("\nWould you like to know more about another student? (enter \"yes\" or \"no\"): ");
			cont = scan.nextLine();
			// new prompt for user input 1-20 if yes, else break out of loop
			if (cont.equalsIgnoreCase("yes")) {
				System.out.print("\nWhich student would you like to learn more about? (enter a number 1-20): ");
			}
				
		}

		System.out.println("Thanks!");
		scan.close();

	}

}
