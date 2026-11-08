package co.edu.uptsoft.Version3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        Inventario inventario = new Inventario(100);
        ExecutorService pool = Executors.newFixedThreadPool(5);
        List<Future<Integer>> resultados = new ArrayList<>();
        long inicio = System.currentTimeMillis();

        for (int i = 0; i < 5; i++) {
            resultados.add(pool.submit(new TaquillaCallable(inventario)));
        }

        int totalPorTaquillas = 0;
        for (int i = 0; i < resultados.size(); i++) {
            int ventas = resultados.get(i).get();
            totalPorTaquillas += ventas;
            System.out.println("Taquilla " + (i + 1) + " vendió " + ventas + " boletas");
        }

        pool.shutdown();
        long fin = System.currentTimeMillis();
        System.out.println("Vendidas según inventario: " + inventario.getVendidas());
        System.out.println("Vendidas según taquillas: " + totalPorTaquillas);
        System.out.println("Disponibles: " + inventario.getDisponibles());
        System.out.println("Tiempo (ms): " + (fin - inicio));
    }
}