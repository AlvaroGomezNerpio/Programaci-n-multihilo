package org.example;

import java.util.Scanner;

public class EjemploScanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer diferentes tipos de datos
        System.out.print("Introduce un nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Introduce tu edad: ");
        int edad = scanner.nextInt();

        System.out.print("Introduce tu altura (en metros, por ejemplo 1.75): ");
        double altura = scanner.nextDouble();

        // Mostrar los datos leídos
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Altura: " + altura);

        scanner.close();
    }
}
