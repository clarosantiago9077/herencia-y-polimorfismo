package envios.modelo;

public abstract class Vehiculo {

    private String placa;
    private int capacidadKg;

    public Vehiculo(String placa, int capacidadKg) {
        this.placa = placa;
        this.capacidadKg = capacidadKg;
    }

    public String getPlaca() {
        return placa;
    }

    public int getCapacidadKg() {
        return capacidadKg;
    }

    public String describir() {
        return placa + " (" + capacidadKg + " kg)";
    }

    // Etapa 3: cada hija concreta debe escribirlo
    public abstract double tarifaPorKm();

    // Etapa 3: método concreto que usa lo que todavía no conoce
    public double costoEnvio(double km) {
        return km * tarifaPorKm();
    }
}
