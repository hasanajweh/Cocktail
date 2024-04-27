package hasan.aziz.cocktail_project;
import hasan.aziz.cocktail_project.tools.Blender;
import hasan.aziz.cocktail_project.tools.Cup;
import hasan.aziz.cocktail_project.Ingredients.Fruit;
import hasan.aziz.cocktail_project.Ingredients.Milk;
import hasan.aziz.cocktail_project.Ingredients.Sugar;
import java.awt.Color;
import java.util.Scanner;
/**
 *
 * @author AJWEH
 */
public class Cocktail_project {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Blender blender = new Blender(1000.0);  
        Cup cup = new Cup(300.0); 

        try {
            // example
            System.out.println("Adding Apple to the Blender...");
            blender.addIngredient(new Fruit("Apple", 52, 150.0, new Color(255, 85, 85)));
            System.out.println("Adding Banana to the Blender...");
            blender.addIngredient(new Fruit("Banana", 89, 118.0, new Color(255, 255, 100)));
            System.out.println("Adding Milk to the Blender...");
            blender.addIngredient(new Milk("Milk", 42, 200.0, new Color(255, 255, 255)));
            

            System.out.println(blender.blend());
            

            System.out.println("Pouring cocktail into the cup...");
            blender.pourCocktail(cup);
            System.out.println(cup.getInfo());
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}

