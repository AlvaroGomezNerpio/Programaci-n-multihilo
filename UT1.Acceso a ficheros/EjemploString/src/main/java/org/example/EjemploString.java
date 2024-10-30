package org.example;

public class EjemploString {

    public static void main(String[] args) {
        String texto = "Bienvenido al mundo de Java";

        // Obtener una subcadena
        String subcadena = texto.substring(0, 10);
        System.out.println("Subcadena: " + subcadena);

        // Reemplazar una palabra
        String reemplazado = texto.replace("Java", "programación");
        System.out.println("Texto reemplazado: " + reemplazado);

        // Dividir el texto en palabras
        String[] palabras = texto.split(" ");
        System.out.println("Palabras en el texto:");
        for (String palabra : palabras) {
            System.out.println(palabra);
        }

        // Convertir a mayúsculas
        System.out.println("Texto en mayúsculas: " + texto.toUpperCase());
    }
}
