package envios.app;

import envios.modelo.Camion;
import envios.modelo.Flota;
import envios.modelo.Moto;

public class Main {

    public static void main(String[] args) {
        // ---------- Etapa 2 ----------
        Moto m1 = new Moto("MZL12A", 20, 150);
        Camion c1 = new Camion("WFT345", 8000, 2);
        Moto m2 = new Moto("KJH78B", 25, 200);

        Flota flota = new Flota("Envíos Caldas");
        flota.agregar(m1);
        flota.agregar(c1);
        flota.agregar(m2);
        System.out.println(flota.agregar(m1));
        flota.mostrar();
        System.out.println(flota.cantidadCamiones());
    }
}

