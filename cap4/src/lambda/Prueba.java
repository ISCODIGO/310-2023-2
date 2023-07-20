package lambda;

public class Prueba {
    public static void main(String[] args) {
        Mensaje saludo = (nombre) -> "Hola, " + nombre;

        Mensaje despedida = cierre -> "Adios " + cierre;

        System.out.println(saludo.enviar("Francisco"));
        System.out.println(despedida.enviar("clase!"));
    }
}
