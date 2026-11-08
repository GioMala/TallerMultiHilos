package co.edu.uptsoft.Version2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        boolean usarBloque = args.length > 0 && args[0].equalsIgnoreCase("bloque");
        String alternativa = usarBloque ? "bloque synchronized" : "método synchronized";
        Inventario inventario = new Inventario(100);
        Thread[] hilos = new Thread[5];
        long inicio = System.currentTimeMillis();

        for (int i = 0; i < hilos.length; i++) {
            Taquilla taquilla = new Taquilla("Taquilla " + (i + 1), inventario, usarBloque);
            hilos[i] = new Thread(taquilla);
            hilos[i].start();
        }

        for (Thread hilo : hilos) {
            hilo.join();
        }

        long fin = System.currentTimeMillis();
        System.out.println("Alternativa: " + alternativa);
        System.out.println("Vendidas: " + inventario.getVendidas());
        System.out.println("Disponibles: " + inventario.getDisponibles());
        System.out.println("Tiempo (ms): " + (fin - inicio));
    }
}