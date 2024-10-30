package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

class Empleado {
    private String nombre;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}

public class EjemploJSON {
    public static void main(String[] args) {
        try {
            // Inicializa ObjectMapper para manipular JSON.
            ObjectMapper mapper = new ObjectMapper();

            // Crea un objeto Empleado y establece un valor en el campo nombre.
            Empleado empleado = new Empleado();
            empleado.setNombre("Juan");

            // Convierte el objeto Empleado a JSON y lo guarda en "empleado.json".
            mapper.writeValue(new File("empleado.json"), empleado);
            System.out.println("Empleado guardado en formato JSON.");

            // Lee el archivo JSON y convierte el contenido de vuelta en un objeto Empleado.
            Empleado empleadoLeido = mapper.readValue(new File("empleado.json"), Empleado.class);
            System.out.println("Nombre del empleado leído (JSON): " + empleadoLeido.getNombre());

        } catch (IOException e) {
            System.err.println("Ocurrió un error al procesar el archivo JSON: " + e.getMessage());
        }
    }
}
