# herencia-y-polimorfismo

PARTE B RETO 1
error: Vehiculo is abstract; cannot be instantiated
Por qué: Vehiculo es una clase abstracta, o sea, una idea general que no se puede crear con new. Tiene un método sin código (tarifaPorKm()) y Java no sabe qué hacer con él. Solo se pueden crear objetos de las hijas, como Moto, Camion o Bicicleta.
RETO 2
error: Bicicleta is not abstract and does not override abstract method tarifaPorKm() in Vehiculo
Por qué: Vehiculo obliga a todas sus hijas a escribir tarifaPorKm(). Si Bicicleta no lo hace, Java no la deja compilar, porque quedaría una clase con un método sin código. La solución fue volver a escribir el método con la tarifa de 600.
RETO 3
error: cannot find symbol
  symbol:   method getEjes()
  location: variable w of type Vehiculo
  Por qué: Java revisa el tipo de la variable, no el del objeto. w es de tipo Vehiculo, y Vehiculo no tiene getEjes(), aunque por dentro haya un Camion.
Corregido:
Vehiculo w = c1;
if (w instanceof Camion c) {
    System.out.println(c.getEjes());
}
Imprime 2. Primero se pregunta si w es un Camion, y si lo es, c lo trata como camión y ya puede usar getEjes().
RETO 4
public double costoEnvio(double km, boolean urgente) {
    double costo = costoEnvio(km);
    if (urgente) {
        costo = costo * 1.5;
    }
    return costo;
}
¿Sobrecarga o sobrescritura? Es sobrecarga. Está en la misma clase, tiene el mismo nombre que costoEnvio(km) pero con parámetros distintos (agrega el boolean). La sobrescritura sería que una hija reescribiera un método del padre con exactamente los mismos parámetros.
RETO 5
- BIC001 (10 kg)
Por qué compiló: sin @Override, Java no revisa nada. describr() se toma como un método nuevo y distinto, no como una reescritura. Entonces Bicicleta sigue usando el describir() del padre, que es el que llama mostrar().
Qué habría pasado con @Override: habría dado error al compilar:

error: method does not override or implement a method from a supertype
RETO 6
Vehiculo v = new Moto("AAA11A", 20, 100);
:

Vehiculo v = new Moto(“AAA11A”, 20, 100);
System.out.println(v.describir());
System.out.println(v.costoEnvio(10));
System.out.println(v instanceof Asegurable);
System.out.println(v instanceof Camion);
Asegurable a = new Bodega(“Bodega Norte”, 50);
System.out.println(a.valorSeguro());

Predicción antes de ejecutar:

v.describir() imprime: AAA11A (20 kg), moto de 100 cc. Aunque la variable es de tipo Vehiculo, el objeto es una Moto, y se ejecuta el describir() de la Moto (polimorfismo).
v.costoEnvio(10) imprime: 12000.0. La moto cobra 1200 por km, así que 10 por 1200 da 12000.0.
v instanceof Asegurable imprime: true. Moto implementa la interfaz Asegurable.
v instanceof Camion imprime: false. El objeto es una Moto, no un Camion.
a.valorSeguro() imprime: 100000.0. La bodega calcula metros por 2000, o sea 50 por 2000.

Pregunta 1. ¿Por qué Bicicleta funcionó en mostrar() y en masEconomico() sin cambiar Flota?

Porque Flota trabaja con el tipo Vehiculo, y Bicicleta también es un Vehiculo. Solo usa métodos que todos los vehículos tienen, y cada objeto responde a su manera (polimorfismo).

Pregunta 2. ¿Por qué Vehiculo es abstracta y Moto no? ¿Qué pasaría si Moto también lo fuera?

Vehiculo es una idea general: no puede calcular su tarifa, así que la deja sin código para que cada hija la defina. Moto es algo concreto y tiene todo definido, por eso se pueden crear motos. Si Moto fuera abstracta, no se podría hacer new Moto(...) y daría error.

Pregunta 3. ¿Por qué Bodega implementa Asegurable pero no hereda de Vehiculo?

Porque una bodega no es un vehículo (no tiene placa ni se mueve), pero sí se puede asegurar. La herencia dice qué es algo, y la interfaz dice qué puede hacer. Por eso puede estar en la misma lista de Asegurable junto con el camión.

Pregunta 4. ¿Qué diferencia hay entre super(placa, capacidadKg) y super.describir()?

super(placa, capacidadKg) llama al constructor del padre. Va en el constructor de la hija, en la primera línea, para guardar la placa y la capacidad.

super.describir() llama al método del padre. Sirve para reutilizar lo que ya hace y agregarle lo propio, como ", moto de 150 cc".

Pregunta 5. ¿Qué es la POO y un ejemplo de cada pilar?

La POO es una forma de programar usando objetos que trabajan juntos. Cada objeto tiene sus datos y sus métodos, y sale de una clase, que es el molde.

Abstracción: Vehiculo deja tarifaPorKm() sin código y solo muestra lo esencial.
Encapsulamiento: los atributos son private y se usan con métodos como getPlaca(). La lista de Flota solo cambia con agregar().
Herencia: Moto, Camion y Bicicleta usan extends Vehiculo y reciben la placa y la capacidad sin repetir código.
Polimorfismo: en mostrar(), un solo for-each llama a describir() y cada vehículo responde distinto.


<img width="2289" height="989" alt="diagrama_clases" src="https://github.com/user-attachments/assets/cc10a1ee-0ca4-49bf-8fee-b7899f34ee55" />
