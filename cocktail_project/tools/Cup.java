package hasan.aziz.cocktail_project.tools;

public class Cup {
    private double capacity;
    private double currentVolume = 0.0;
    private int calories = 0;

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void setCurrentVolume(double currentVolume) {
        this.currentVolume = currentVolume;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getCurrentVolume() {
        return currentVolume;
    }

    public int getCalories() {
        return calories;
    }

    public Cup(double capacity) {
        this.capacity = capacity;
    }

    public void fillCup(double volume, int calories) {
        this.currentVolume += volume;
        this.calories += calories;  
    }

    public double getCapacity() {
        return capacity;
    }

    public String getInfo() {
        return String.format("Cup with capacity: %.2f ml, Contains: %.2f ml, Calories: %d", capacity, currentVolume, calories);
    }

    public String getTotalCalories() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
