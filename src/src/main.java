package src;

import java.util.*;
import java.io.*;

public class main {

	public static void main(String[] args) {
		int counter = 0;
		char searchChar = 'e';
		String source = "data/input.txt";
		counter = charCount(searchChar, source);
		System.out.println("Number of times char " + searchChar + " appeared in file: " + counter);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter first name:");
		String firstName = scanner.nextLine();
		System.out.println("Enter last name: ");
		String lastName = scanner.nextLine();
		registerNewUser(firstName, lastName);
	}

	public static int charCount(char searchChar, String source) {
		int count = 0;
		
		File input = new File(source);
		Scanner scanner;
		try {
			scanner = new Scanner(input);
			String data = scanner.next();
			for (int i = 0; i < input.length(); i++) {
				if (data.charAt(i) == searchChar)
					count += 1;
				scanner.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public static void registerNewUser(String firstName, String lastName) {
		File output = new File("data/output.txt");
		try {
			FileWriter fileWriter = new FileWriter(output);
			fileWriter.write(firstName);
			fileWriter.write(lastName);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
