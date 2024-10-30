package org.example;

public class EstadosHilo extends Thread {
    public void run() {
        try {
            // Indica que el hilo ha comenzado y está en ejecución ('RUNNABLE')
            System.out.println("Estado: RUNNABLE");

            // Pausa el hilo por 1 segundo, cambiando su estado a 'TIMED_WAITING'
            Thread.sleep(1000);
            System.out.println("Estado: TIMED_WAITING");

        } catch (InterruptedException e) {
            // Manejo de interrupciones mientras el hilo está en espera
            System.out.println("Hilo interrumpido");
        }

        // El hilo termina su ejecución ('TERMINATED')
        System.out.println("Estado: TERMINATED");
    }

    public static void main(String[] args) {
        // Creación del hilo en estado 'NEW' (nuevo)
        EstadosHilo hilo = new EstadosHilo();
        System.out.println("Estado: NEW");
        hilo.start(); // Comienza el hilo, pasando a 'RUNNABLE'
    }
}
