package org.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class RunnableYCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        // Define la tarea que retornará un resultado cuando el hilo termine
        return "Resultado de Callable";
    }

    public static void main(String[] args) {
        // Creación de una tarea con Runnable (no retorna resultado)
        Runnable runnableTask = () -> System.out.println("Ejecutando tarea con Runnable");

        // Crear e iniciar un hilo con Runnable
        Thread hiloRunnable = new Thread(runnableTask);
        hiloRunnable.start();

        // Crear una tarea Callable y un FutureTask para manejar el resultado
        Callable<String> callableTask = new RunnableYCallable();
        FutureTask<String> futureTask = new FutureTask<>(callableTask);

        // Crear e iniciar un hilo con Callable
        Thread hiloCallable = new Thread(futureTask);
        hiloCallable.start();

        try {
            // Espera el resultado del Callable
            System.out.println("Resultado de Callable: " + futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
