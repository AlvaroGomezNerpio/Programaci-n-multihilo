package org.example;

public class CrearHilos implements Runnable {
    @Override
    public void run() {
        // Este método se ejecutará cuando el hilo inicie su ejecución
        System.out.println("El hilo está en ejecución: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        // Creación de dos hilos, cada uno ejecutando la misma instancia de la clase 'CrearHilos'
        Thread hilo1 = new Thread(new CrearHilos());
        Thread hilo2 = new Thread(new CrearHilos());

        // Inicia ambos hilos
        hilo1.start();
        hilo2.start();
    }
}
