package org.example;

class Contador {
    private int cuenta = 0;

    public synchronized void incrementar() {
        cuenta++;
    }

    public int getCuenta() {
        return cuenta;
    }
}

public class SincronizacionHilos {
    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();

        Runnable tarea = () -> {
            for (int i = 0; i < 1000; i++) {
                contador.incrementar(); // Incrementa de forma segura
            }
        };

        // Crear e iniciar dos hilos para incrementar el contador
        Thread hilo1 = new Thread(tarea);
        Thread hilo2 = new Thread(tarea);

        hilo1.start();
        hilo2.start();
        hilo1.join();
        hilo2.join();

        // Imprime el valor final del contador
        System.out.println("Cuenta final: " + contador.getCuenta());
    }
}
