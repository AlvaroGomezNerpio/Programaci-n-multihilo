package org.example;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.File;

public class EjemploDOM {

    public static void main(String[] args) {
        try {
            // Crear un archivo XML (esto es solo un ejemplo simple de lectura)
            File archivoXML = new File("empleado.xml");

            // Configurar DocumentBuilder para procesar XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivoXML);

            // Normalizar estructura XML
            doc.getDocumentElement().normalize();

            // Obtener el nodo raíz y los elementos deseados
            System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("empleado");

            // Recorrer los elementos y obtener la información
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nNode;
                    System.out.println("Nombre: " + elemento.getElementsByTagName("nombre").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
