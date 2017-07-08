
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
	
	/*
	 * constructor method...
	 */
	public RecipeFinder() {	}
	
	// setting value for recipe, input in TestRecipeFinder and passed as an argument here
	public void setRecipe (String recipe) {
		this.recipe = "#" + recipe;		
	}
	
	/*
	 * reading the ingredients or outputting an error that the recipe could not be found
	 */
	public void getIngredients() {
		String str;
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\recipefile\\recipefile.txt"))) {
			// reading until we get #this.recipe
			try {
				do {
					str = br.readLine();
					if (str.equals(this.recipe)) {
						this.ingredients = br.readLine();
						System.out.println(this.ingredients);
					}
				} while (str != null);
			} catch (NullPointerException recipenotfound) {
				System.out.println("Recipe not found.");
			}
		} catch (IOException filenotfound) {
			// TODO Auto-generated catch block
			System.out.println("File could not be found.");
			System.exit(-1);
		}
	} 
}
