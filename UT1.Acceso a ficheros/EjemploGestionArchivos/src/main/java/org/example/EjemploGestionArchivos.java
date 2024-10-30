package org.example;

import java.io.File;
import java.io.IOException;

public class EjemploGestionArchivos {

    public static void main(String[] args) {
        File archivo = new File("archivoEjemplo.txt");

        // Crear archivo si no existe
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Obtener información del archivo
        System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
        System.out.println("¿Es archivo? " + archivo.isFile());
        System.out.println("¿Es directorio? " + archivo.isDirectory());
        System.out.println("¿Se puede leer? " + archivo.canRead());
        System.out.println("¿Se puede escribir? " + archivo.canWrite());

        // Renombrar el archivo
        File nuevoArchivo = new File("nuevoArchivoEjemplo.txt");
        if (archivo.renameTo(nuevoArchivo)) {
            System.out.println("Archivo renombrado a: " + nuevoArchivo.getName());
        }

        // Eliminar el archivo
        if (nuevoArchivo.delete()) {
            System.out.println("Archivo eliminado.");
        }
    }
}
