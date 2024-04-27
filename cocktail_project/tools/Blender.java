package hasan.aziz.cocktail_project.tools;

import hasan.aziz.cocktail_project.Ingredients.Ingredient;
import hasan.aziz.cocktail_project.Ingredients.Fruit;
import hasan.aziz.cocktail_project.Ingredients.Milk;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Blender {
    private final double capacity;
    private double currentVolume = 0.0;
    private final List<Ingredient> contents = new ArrayList<>();
    private boolean isBlended = false;

    public double getCapacity() {
        return capacity;
    }

    public List<Ingredient> getContents() {
        return contents;
    }

    public boolean isIsBlended() {
        return isBlended;
    }

    public Blender(double capacity) {
        this.capacity = capacity;
    }

    public void setCurrentVolume(double currentVolume) {
        this.currentVolume = currentVolume;
    }

    public void setIsBlended(boolean isBlended) {
        this.isBlended = isBlended;
    }

    public void addIngredient(Ingredient ingredient) {
        double additionalVolume = 0;
        if (ingredient instanceof Fruit) {
            additionalVolume = ((Fruit) ingredient).getVolume();
        } else if (ingredient instanceof Milk) {
            additionalVolume = ((Milk) ingredient).getVolume();
        }
        
        if (currentVolume + additionalVolume > capacity) {
            throw new IllegalArgumentException("Cannot add more ingredients, exceeds blender capacity.");
        }
        
        contents.add(ingredient);
        currentVolume += additionalVolume;
    }

    public String blend() {
        isBlended = true;
        return "Blended Cocktail with " + contents.size() + " ingredients.";
    }

    public int getTotalCalories() {
        if (!isBlended) throw new IllegalStateException("Blend the ingredients before getting calories.");
        return contents.stream().mapToInt(Ingredient::getCalories).sum();
    }

    public double getCurrentVolume() {
        return currentVolume;
    }

    public Color getColor() {
        int r = 0, g = 0, b = 0, count = 0;
        for (Ingredient i : contents) {
            if (i instanceof Fruit || i instanceof Milk) {
                Color c = ((Fruit) i).getColor();
                r += c.getRed();
                g += c.getGreen();
                b += c.getBlue();
                count++;
            }
        }
        if (count == 0) return new Color(255, 255, 255);
        return new Color(r / count, g / count, b / count);
    }

    public void pourCocktail(Cup cup) {
        if (!isBlended) throw new IllegalStateException("Blend the ingredients before pouring.");
        if (currentVolume == 0) throw new IllegalStateException("Blender is empty, nothing to pour.");

        double volumeToPour = Math.min(cup.getCapacity(), currentVolume);
        cup.fillCup(volumeToPour, getTotalCalories());
        currentVolume -= volumeToPour;
    }

    public String getInfo() {
        return String.format("Blender capacity: %.2f ml, Current volume: %.2f ml, Total Calories: %d", capacity, getCurrentVolume(), getTotalCalories());
    }
}
