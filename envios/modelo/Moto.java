package envios.modelo;

public class Moto extends Vehiculo {

    private int cilindraje;

    public Moto(String placa, int capacidadKg, int cilindraje) {
        super(placa, capacidadKg);
        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    @Override
    public String describir() {
        return super.describir() + ", moto de " + cilindraje + " cc";
    }

    @Override
    public double tarifaPorKm() {
        return 1200;
    }
}
