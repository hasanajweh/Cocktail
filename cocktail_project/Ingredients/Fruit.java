/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hasan.aziz.cocktail_project.Ingredients;
import java.awt.Color;

public class Fruit extends Ingredient {
    private double volume;
    private Color color;

    public double getVolume() {
        return volume;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Fruit(String name, int calories, double volume, Color color) {
        super(name, calories);
        this.volume = volume;
        this.color = color;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Volume: " + volume + "ml, Color: " + color.toString();
    }
} 