package co.edu.uptsoft.Version2;

public class Taquilla implements Runnable {
    private final String nombre;
    private final Inventario inventario;
    private final boolean usarBloque;
    private int ventas = 0;

    public Taquilla(String nombre, Inventario inventario, boolean usarBloque) {
        this.nombre = nombre;
        this.inventario = inventario;
        this.usarBloque = usarBloque;
    }

    @Override
    public void run() {
        boolean vendio;
        do {
            vendio = usarBloque
                    ? inventario.venderConBloque()
                    : inventario.venderConMetodo();
            if (vendio) {
                ventas++;
            }
        } while (vendio);

        System.out.println(nombre + " vendió " + ventas + " boletas");
    }
}

