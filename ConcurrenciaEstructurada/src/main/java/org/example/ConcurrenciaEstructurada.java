package org.example;

import java.util.concurrent.*;

public class ConcurrenciaEstructurada {
    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            // Enviar varias tareas y obtener sus resultados
            Future<String> futuro1 = executor.submit(() -> "Tarea 1 completada");
            Future<String> futuro2 = executor.submit(() -> "Tarea 2 completada");

            // Imprime los resultados de las tareas
            System.out.println(futuro1.get());
            System.out.println(futuro2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
