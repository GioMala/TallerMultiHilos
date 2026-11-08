package co.edu.uptsoft.Version2;

public class Inventario {
    private int disponibles;
    private int vendidas = 0;

    public Inventario(int total) {
        this.disponibles = total;
    }

    public synchronized boolean venderConMetodo() {
        if (disponibles <= 0) {
            return false;
        }

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }

        disponibles--;
        vendidas++;
        return true;
    }

    public boolean venderConBloque() {
        synchronized (this) {
            if (disponibles <= 0) {
                return false;
            }
            disponibles--;
            vendidas++;
        }

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return true;
    }

    public synchronized int getDisponibles() {
        return disponibles;
    }

    public synchronized int getVendidas() {
        return vendidas;
    }
}
