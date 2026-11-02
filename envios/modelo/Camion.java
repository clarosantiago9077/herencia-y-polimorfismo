package envios.modelo;

public class Camion extends Vehiculo {

    private int ejes;

    public Camion(String placa, int capacidadKg, int ejes) {
        super(placa, capacidadKg);
        this.ejes = ejes;
    }

    public int getEjes() {
        return ejes;
    }

    @Override
    public String describir() {
        return super.describir() + ", camión de " + ejes + " ejes";
    }
}

