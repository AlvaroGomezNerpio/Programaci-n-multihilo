package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EjemploExecutorService {
    public static void main(String[] args) {
        // Crear un pool de hilos con capacidad de 3 hilos simultáneos
        ExecutorService pool = Executors.newFixedThreadPool(3);

        // Definir una tarea que imprimirá el nombre del hilo actual
        Runnable tarea = () -> System.out.println("Hilo: " + Thread.currentThread().getName());

        // Ejecutar la tarea varias veces en el pool de hilos
        for (int i = 0; i < 5; i++) {
            pool.execute(tarea);
        }

        // Finaliza el pool de hilos
        pool.shutdown();
    }
}
