package org.example;

public class InterrupcionHilos extends Thread {
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Hilo en ejecución");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Interrupción detectada, saliendo del hilo...");
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InterrupcionHilos hilo = new InterrupcionHilos();
        hilo.start();
        Thread.sleep(2000);
        hilo.interrupt(); // Envía una señal de interrupción al hilo
    }
}
