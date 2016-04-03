package se.nordh.bookstore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

import se.nordh.bookstore.ui.ConsoleUI;

public class Main {

	public static void main(String[] args) throws ParseException {
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		
		ConsoleUI.Welcome();
		
		while(true) {
			try {
				
				ConsoleUI.Standby();
				
				String[] command = userInput.readLine().split(" ");
				
				switch (command[0]) {
				case "HELP":
				case "Help":
				case "help":
					ConsoleUI.Help();
					break;
				case "LIST":
				case "List":
				case "list":
					System.out.println("Comming soon");
					break;
				case "ADDTOCART":
				case "AddToCart":
				case "addtocart":
					System.out.println("Comming soon");
					break;
				case "REMOVEFROMCART":
				case "RemoveFromCart":
				case "removefromcart":
					System.out.println("Comming soon");	
					break;
				case "ADDTOSTORE":
				case "AddToStore":
				case "addtostore":
					System.out.println("Comming soon");	
					break;
				case "EXIT":
				case "Exit":
				case "exit":
					ConsoleUI.endScreen();
					userInput.close();
					System.exit(0);
					break;
				default:
					System.out.println("Unknown command. Please try again or type in 'Help'");
				}
				
			}
			
			catch(IOException e) {
				e.printStackTrace();
			}
			
		}

	}

}
