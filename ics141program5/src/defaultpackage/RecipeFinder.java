/*
 * this is the driver class
 */
import java.io.*;

public class RecipeFinder {
	/*
	 * instance variables
	 */
	private String recipe;
	private String ingredients;
	private BufferedReader br;
	
	/*
	 * class methods
	 */
	
	// constructor method
	public RecipeFinder() {

	}
	
	// setting value for recipe
	public void setRecipe (String recipe) {
		this.recipe = recipe;		
	}
	
	// reading value for the 
	public String readIngredients() {
		String str;
		try (BufferedReader br = new BufferedReader(new FileReader("recipefile.txt"))) {
			// reading until we get #this.recipe
			try {
				while ((str = br.readLine()) != null) {
					System.out.println(str);
					if (str.equals("#" + this.recipe)) {
						this.ingredients = br.readLine();
						br.close();
						return (this.ingredients);
					}
				} 
				return ("Recipe could not be found.");
			} catch (IOException recipenotfound) {
				return ("Recipe " + this.recipe + " could not be found.");
			}
		} catch (IOException filenotfound) {
			// TODO Auto-generated catch block
			return ("File could not be found.");
		}
	} 
}
