package envios.modelo;

import java.util.ArrayList;

public class Flota {

    private String nombre;
    private ArrayList<Vehiculo> vehiculos;

    public Flota(String nombre) {
        this.nombre = nombre;
        this.vehiculos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public boolean agregar(Vehiculo vehiculo) {
        if (vehiculo == null || vehiculos.contains(vehiculo)) {
            return false;
        }
        vehiculos.add(vehiculo);
        return true;
    }

    // Polimorfismo: el ciclo no pregunta la clase, cada objeto sabe describirse
    public void mostrar() {
        System.out.println(nombre + ":");
        for (Vehiculo v : vehiculos) {
            System.out.println("- " + v.describir());
        }
    }

    public int cantidadCamiones() {
        int cantidad = 0;
        for (Vehiculo v : vehiculos) {
            if (v instanceof Camion) {
                cantidad++;
            }
        }
        return cantidad;
    }

    // Etapa 3: entre los que sirven para el peso, el de menor tarifa por km
    public Vehiculo masEconomico(int pesoKg) {
        Vehiculo mejor = null;
        for (Vehiculo v : vehiculos) {
            if (v.getCapacidadKg() >= pesoKg) {
                if (mejor == null || v.tarifaPorKm() < mejor.tarifaPorKm()) {
                    mejor = v;
                }
            }
        }
        return mejor;
    }

    // Etapa 4: solo suma los que cumplen el contrato Asegurable
    public double totalSeguros() {
        double total = 0;
        for (Vehiculo v : vehiculos) {
            if (v instanceof Asegurable a) {
                total += a.valorSeguro();
            }
        }
        return total;
    }
}
