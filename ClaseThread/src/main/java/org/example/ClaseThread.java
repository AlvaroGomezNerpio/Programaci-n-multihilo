package org.example;

public class ClaseThread extends Thread {
    public ClaseThread(String nombre) {
        super(nombre); // Configura el nombre del hilo
    }

    public void run() {
        // Este método se ejecuta cuando el hilo empieza su ejecución
        System.out.println("Ejecutando hilo: " + getName());
    }

    public static void main(String[] args) {
        // Crea y nombra el hilo, luego lo inicia
        ClaseThread hilo = new ClaseThread("HiloPersonalizado");
        hilo.start();
    }
}
