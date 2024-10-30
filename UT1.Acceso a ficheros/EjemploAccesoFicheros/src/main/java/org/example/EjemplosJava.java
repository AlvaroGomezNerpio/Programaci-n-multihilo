package org.example;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
import java.util.regex.*;
import javax.xml.parsers.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.w3c.dom.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EjemplosJava {

    public static void main(String[] args) {
        try {
            ejemploFile();
            ejemploJavaIO();
            ejemploJavaNIO();
            ejemploScanner();
            ejemploString();
            ejemploExpresionesRegulares();
            ejemploDOM();
            ejemploJAXB();
            ejemploJSON();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 1. Clases asociadas a las operaciones de gestión de ficheros
    public static void ejemploFile() throws IOException {
        // Crea un objeto File que representa un archivo llamado "miArchivo.txt"
        File archivo = new File("miArchivo.txt");

        // Intenta crear el archivo y verifica si se creó exitosamente
        if (archivo.createNewFile()) {
            System.out.println("Archivo creado: " + archivo.getName());
        } else {
            System.out.println("El archivo ya existe.");
        }
    }

    // 2. Ejemplo de uso de java.io para leer un archivo de texto
    public static void ejemploJavaIO() {
        // Intenta abrir el archivo en modo lectura usando BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader("miArchivo.txt"))) {
            String linea;

            // Lee el archivo línea por línea y muestra el contenido en la consola
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 3. Ejemplo de uso de java.nio para escribir en un archivo
    public static void ejemploJavaNIO() {
        // Define la ruta del archivo "otroArchivo.txt" utilizando la clase Path
        Path ruta = Paths.get("otroArchivo.txt");
        try {
            // Escribe una cadena en el archivo especificado, creando el archivo si no existe
            Files.write(ruta, "Texto de ejemplo".getBytes(), StandardOpenOption.CREATE);
            System.out.println("Archivo creado con éxito");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 4. Uso de la clase Scanner para leer datos desde la consola
    public static void ejemploScanner() {
        // Crea un objeto Scanner para leer desde la entrada estándar (teclado)
        Scanner scanner = new Scanner(System.in);

        // Solicita al usuario que introduzca un número
        System.out.print("Introduce un número: ");
        int numero = scanner.nextInt();

        // Muestra el número introducido
        System.out.println("Número introducido: " + numero);

        // Cierra el Scanner para liberar el recurso
        scanner.close();
    }

    // 5. Métodos de String para manipular y modificar cadenas de texto
    public static void ejemploString() {
        // Crea una cadena de ejemplo
        String texto = "Hola, mundo";

        // Extrae una subcadena ("Hola")
        System.out.println(texto.substring(0, 4));

        // Reemplaza "mundo" con "Java"
        System.out.println(texto.replace("mundo", "Java"));

        // Divide la cadena en partes separadas por coma y muestra la segunda parte
        System.out.println(texto.split(",")[1].trim());
    }

    // 6. Expresiones regulares para validar un email
    public static void ejemploExpresionesRegulares() {
        // Define un email de prueba
        String email = "ejemplo@correo.com";

        // Define un patrón de expresión regular para un formato de email
        Pattern pattern = Pattern.compile("^[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$");

        // Verifica si el email cumple con el patrón
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            System.out.println("Email válido");
        } else {
            System.out.println("Email no válido");
        }
    }

    // 7. Trabajo con ficheros XML usando DOM
    public static void ejemploDOM() {
        try {
            // Cargar el archivo XML existente
            File archivo = new File("archivo.xml");

            // Configura un DocumentBuilder para procesar el XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parsear el archivo XML y convertirlo en un documento DOM
            Document doc = dBuilder.parse(archivo);
            doc.getDocumentElement().normalize();

            // Muestra el nombre del elemento raíz
            System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());

            // Obtiene todos los elementos "empleado" y recorre la lista
            NodeList lista = doc.getElementsByTagName("empleado");
            for (int i = 0; i < lista.getLength(); i++) {
                Node nodo = lista.item(i);

                // Verifica que el nodo sea un ELEMENT_NODE antes de convertirlo a Element
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;

                    // Obtiene el nombre del empleado y lo imprime
                    System.out.println("Nombre: " + elemento.getElementsByTagName("nombre").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 8. Uso de JAXB para convertir un objeto Java a XML y viceversa
    public static void ejemploJAXB() {
        try {
            // Crea un objeto Empleado y establece un valor en el campo nombre
            Empleado empleado = new Empleado();
            empleado.setNombre("Juan");

            // Inicializa JAXBContext para la clase Empleado y crea un Marshaller
            JAXBContext context = JAXBContext.newInstance(Empleado.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Convierte el objeto Empleado a XML y lo guarda en "empleado.xml"
            marshaller.marshal(empleado, new File("empleado.xml"));

            // Convierte el XML de nuevo en un objeto Empleado usando Unmarshaller
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Empleado empleadoLeido = (Empleado) unmarshaller.unmarshal(new File("empleado.xml"));
            System.out.println("Nombre del empleado leído: " + empleadoLeido.getNombre());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    // 9. Trabajo con ficheros JSON usando Jackson
    public static void ejemploJSON() {
        try {
            // Inicializa ObjectMapper para manipular JSON
            ObjectMapper mapper = new ObjectMapper();

            // Crea un objeto Empleado y establece un valor en el campo nombre
            Empleado empleado = new Empleado();
            empleado.setNombre("Juan");

            // Convierte el objeto Empleado a JSON y lo guarda en "empleado.json"
            mapper.writeValue(new File("empleado.json"), empleado);

            // Lee el archivo JSON y convierte el contenido de vuelta en un objeto Empleado
            Empleado empleadoLeido = mapper.readValue(new File("empleado.json"), Empleado.class);
            System.out.println("Nombre del empleado leído (JSON): " + empleadoLeido.getNombre());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Clase Empleado para los ejemplos de JAXB y JSON
@XmlRootElement
class Empleado {
    private String nombre;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
