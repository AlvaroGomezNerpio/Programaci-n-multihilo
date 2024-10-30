package org.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class HilosVirtuales {
    public static void main(String[] args) {
        // Crear un ExecutorService que usa hilos virtuales (Java 19+)
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        // Definir y enviar una tarea al executor
        Runnable tarea = () -> System.out.println("Ejecutando en hilo virtual: " + Thread.currentThread());
        executor.submit(tarea);

        // Cierra el executor
        executor.shutdown();
    }
}
