package org.example;

import java.nio.file.*;
import java.io.IOException;

public class EjemploJavaNIO {

    public static void main(String[] args) {
        Path directorio = Paths.get("DirectorioEjemplo");

        // Crear un directorio
        try {
            Files.createDirectories(directorio);
            System.out.println("Directorio creado: " + directorio.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Escribir en un archivo dentro del directorio
        Path archivo = directorio.resolve("archivoEjemploNIO.txt");
        String texto = "Texto de ejemplo usando java.nio";
        try {
            Files.write(archivo, texto.getBytes(), StandardOpenOption.CREATE);
            System.out.println("Texto escrito en el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Listar archivos en el directorio
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directorio)) {
            System.out.println("Contenido del directorio:");
            for (Path archivoPath : stream) {
                System.out.println(archivoPath.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
