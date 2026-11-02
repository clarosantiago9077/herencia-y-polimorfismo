package envios.app;

import envios.modelo.Bicicleta;
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

        // ---------- Etapa 3 ----------
        System.out.println(m1.costoEnvio(12));
        System.out.println(c1.costoEnvio(12));
        Bicicleta b1 = new Bicicleta("BIC001", 10);
        flota.agregar(b1);
        flota.mostrar();
        System.out.println(flota.masEconomico(8).getPlaca());
        System.out.println(flota.masEconomico(22).getPlaca());
        System.out.println(flota.masEconomico(500).getPlaca());
        System.out.println(flota.masEconomico(9000));
    }
}
