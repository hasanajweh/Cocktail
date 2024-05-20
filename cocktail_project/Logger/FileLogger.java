/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hasan.aziz.cocktail_project.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author AJWEH
 */
public class FileLogger implements Logger{
    private PrintWriter writer;

    public FileLogger(String filePath) throws IOException {
        writer = new PrintWriter(new FileWriter(filePath, true));
    }

    public void log(String message) {
        writer.println("File Log: " + message);
        writer.flush();
    }
}

