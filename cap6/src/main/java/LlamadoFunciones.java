/*
Demostracion de que el llamado de funciones se realiza mediante una
estructura de tipo Pila (Stack). Donde el orden los llamados se realiza
de forma inversa a las finalizaciones de las funciones.


Orden de los llamados
main -> primera -> segunda -> tercera

Orden de las finalizaciones
tercera -> segunda -> primera -> main

*/
public class LlamadoFunciones {
    static void primera() {
        segunda();
        System.out.println("Llamado a primera");
    }

    static void segunda() {
        tercera();
        System.out.println("Llamado a la segunnda");
    }

    static void tercera() {
        System.out.println("Llamado a tercera");
    }
    public static void main(String[] args) {
        primera();
    }
}

/*



 */