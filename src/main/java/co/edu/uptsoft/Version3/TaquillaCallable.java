package co.edu.uptsoft.Version3;

import java.util.concurrent.Callable;

public class TaquillaCallable implements Callable<Integer> {
    private final Inventario inventario;

    public TaquillaCallable(Inventario inventario) {
        this.inventario = inventario;
    }

    @Override
    public Integer call() {
        int ventas = 0;
        while (inventario.vender()) {
            ventas++;
        }
        return ventas;
    }
}
