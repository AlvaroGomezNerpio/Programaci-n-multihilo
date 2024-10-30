package org.example;

class Monitor {
    public synchronized void recursoCompartido() {
        System.out.println("Acceso al recurso: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class EjemploMonitor {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();

        Runnable tarea = () -> monitor.recursoCompartido();

        // Inicia varios hilos que intentan acceder al recurso monitoreado
        for (int i = 0; i < 3; i++) {
            new Thread(tarea).start();
        }
    }
}
