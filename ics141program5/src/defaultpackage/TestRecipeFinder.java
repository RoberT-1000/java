/*
 * this is the application class
 */

import java.io.*;

public class TestRecipeFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String recipe = "";
		
		RecipeFinder myRecipe = new RecipeFinder();
		
		System.out.println("Welcome to Chinese recipe search program.");
		System.out.println("Enter 'stop' to end.");

		while (!((recipe.equals("stop")))) {
			InputStreamReader instream = new InputStreamReader(System.in);
			BufferedReader ins = new BufferedReader(instream);
			System.out.print("Enter a recipe name: ");
			try {
				recipe = ins.readLine();
				if (recipe.equals("stop")) { break; }
				System.out.println(myRecipe.readIngredients());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid input.");
			}
		}
		System.out.println("Bye");
	}

}
