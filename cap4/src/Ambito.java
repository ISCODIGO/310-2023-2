public class Ambito {
    static void funcion(int x) {
        x = x * 2;
        System.out.println("Dentro de la funcion..." + x);
    }

    public static void main(String[] args) {
        int valor = 10;
        funcion(valor);
        System.out.println("Fuera de la funcion..." + valor);


    }

}
