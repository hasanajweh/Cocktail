package hasan.aziz.cocktail_project;
import hasan.aziz.cocktail_project.tools.Blender;
import hasan.aziz.cocktail_project.tools.Cup;
import hasan.aziz.cocktail_project.Ingredients.Fruit;
import hasan.aziz.cocktail_project.Ingredients.Ingredient;
import hasan.aziz.cocktail_project.Ingredients.Milk;
import hasan.aziz.cocktail_project.Ingredients.Sugar;
import hasan.aziz.cocktail_project.Logger.ConsoleLogger;
import hasan.aziz.cocktail_project.Logger.Logger;
import java.awt.Color;
import java.util.Scanner;
/**
 *
 * @author AJWEH
 */
public class Cocktail_project {
public static void main(String[] args) {
        Logger logger = new ConsoleLogger();
        Blender blender = new Blender(1000, logger); // Blender with 1000 ml capacity and logger
        Cup cup = new Cup(500); // Cup with 500 ml capacity

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Cocktail Maker!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add ingredient to Blender");
            System.out.println("2. Blend mixture");
            System.out.println("3. Pour cocktail into Cup");
            System.out.println("4. Check total calories in Cup");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1 -> addIngredient(scanner, blender);
                    case 2 -> System.out.println(blender.blend());
                    case 3 -> {
                        blender.pourCocktail(cup);
                        System.out.println("Cocktail poured into the cup.");
                    }
                    case 4 -> System.out.println("Total calories in Cup: " + cup.getTotalCalories());
                    case 5 -> {
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice! Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void addIngredient(Scanner scanner, Blender blender) {
        System.out.print("Enter ingredient name (Fruit, Milk, Sugar): ");
        String name = scanner.nextLine();
        System.out.print("Enter calories: ");
        int calories = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Ingredient ingredient = null;

        if (name.equalsIgnoreCase("Fruit") || name.equalsIgnoreCase("Milk")) {
            System.out.print("Enter volume (ml): ");
            double volume = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter color (RGB as r,g,b): ");
            String[] rgbValues = scanner.nextLine().split(",");
            Color color = new Color(
                Integer.parseInt(rgbValues[0].trim()),
                Integer.parseInt(rgbValues[1].trim()),
                Integer.parseInt(rgbValues[2].trim())
            );

            if (name.equalsIgnoreCase("Fruit")) {
                ingredient = new Fruit(name, calories, volume, color);
            } else { // Milk
                ingredient = new Milk(name, calories, volume, color);
            }
        } else if (name.equalsIgnoreCase("Sugar")) {
            ingredient = new Sugar(name, calories);
        }

        if (ingredient != null) {
            blender.addIngredient(ingredient);
            System.out.println("Ingredient added: " + ingredient.getInfo());
        } else {
            System.out.println("Invalid ingredient type entered.");
        }
    }
}