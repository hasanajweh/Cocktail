/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hasan.aziz.cocktail_project.Logger;

/**
 *
 * @author AJWEH
 */
public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Console Log: " + message);
    }
}
