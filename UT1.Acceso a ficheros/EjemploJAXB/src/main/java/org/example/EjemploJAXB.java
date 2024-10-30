package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.File;

@XmlRootElement
class Empleado {
    private String nombre;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}

public class EjemploJAXB {
    public static void main(String[] args) {
        try {
            // Crea un objeto Empleado y establece un valor en el campo nombre.
            Empleado empleado = new Empleado();
            empleado.setNombre("Juan");

            // Inicializa JAXBContext para la clase Empleado y crea un Marshaller.
            JAXBContext context = JAXBContext.newInstance(Empleado.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Convierte el objeto Empleado a XML y lo guarda en "empleado.xml".
            marshaller.marshal(empleado, new File("empleado.xml"));

            // Convierte el XML de nuevo en un objeto Empleado usando Unmarshaller.
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Empleado empleadoLeido = (Empleado) unmarshaller.unmarshal(new File("empleado.xml"));
            System.out.println("Nombre del empleado leído: " + empleadoLeido.getNombre());

        } catch (JAXBException e) {
            System.err.println("Ocurrió un error al procesar JAXB: " + e.getMessage());
        }
    }
}
