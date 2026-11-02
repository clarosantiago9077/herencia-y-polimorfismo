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
}

