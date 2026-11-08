package co.edu.uptsoft.Version1;

public class Inventario {
    private int disponibles;
    private int vendidas = 0;
    public Inventario(int total) {
        this.disponibles = total;
    }
    public boolean vender() {
        if (disponibles > 0) {
            try {
                Thread.sleep(1); // simula el procesamiento de la venta
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            disponibles--;
            vendidas++;
            return true;
        }
        return false;
    }
    public int getDisponibles() { return disponibles; }
    public int getVendidas() { return vendidas; }
}
