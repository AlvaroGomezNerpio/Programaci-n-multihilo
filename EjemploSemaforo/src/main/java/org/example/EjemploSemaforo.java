package org.example;

import java.util.concurrent.Semaphore;

public class EjemploSemaforo {
    private static final Semaphore semaforo = new Semaphore(2);

    public static void main(String[] args) {
        Runnable tarea = () -> {
            try {
                semaforo.acquire(); // Solicita acceso al recurso
                System.out.println("Accediendo recurso: " + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Liberando recurso: " + Thread.currentThread().getName());
                semaforo.release(); // Libera el acceso al recurso
            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(tarea).start();
        }
    }
}
