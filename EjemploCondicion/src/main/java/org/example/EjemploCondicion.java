package org.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EjemploCondicion {
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static boolean listo = false;

    public static void main(String[] args) {
        Thread productor = new Thread(() -> {
            lock.lock();
            try {
                listo = true;
                condition.signal(); // Notifica al consumidor
            } finally {
                lock.unlock();
            }
        });

        Thread consumidor = new Thread(() -> {
            lock.lock();
            try {
                while (!listo) {
                    condition.await(); // Espera la señal del productor
                }
                System.out.println("Consumidor activo");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        consumidor.start();
        productor.start();
    }
}
