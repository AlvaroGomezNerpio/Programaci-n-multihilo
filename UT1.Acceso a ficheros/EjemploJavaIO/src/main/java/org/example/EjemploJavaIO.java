package org.example;

import java.io.*;

public class EjemploJavaIO {

    public static void main(String[] args) {
        String nombreArchivo = "ejemploTextoIO.txt";

        // Escribir en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("Primera línea de texto.");
            writer.newLine();
            writer.write("Segunda línea de texto.");
            System.out.println("Texto escrito en el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leer desde el archivo
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            System.out.println("Leyendo archivo:");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
