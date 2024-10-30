package org.example;

import java.util.regex.*;

public class EjemploExpresionesRegulares {

    public static void main(String[] args) {
        // Validar formato de email
        String email = "correo@ejemplo.com";
        Pattern emailPattern = Pattern.compile("^[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$");
        Matcher emailMatcher = emailPattern.matcher(email);
        System.out.println("Email válido: " + emailMatcher.matches());

        // Validar formato de número de teléfono
        String telefono = "123-456-7890";
        Pattern telefonoPattern = Pattern.compile("^\\d{3}-\\d{3}-\\d{4}$");
        Matcher telefonoMatcher = telefonoPattern.matcher(telefono);
        System.out.println("Número de teléfono válido: " + telefonoMatcher.matches());
    }
}
