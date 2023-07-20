package lambda;

public class Implementacion {

    public static void main(String[] args) {
        Calculadora sumar = (int a, int b) -> {
            return a + b;
        };

        Calculadora restar = (int a, int b) -> a - b;

        Calculadora multiplicar = (x, y) ->  x * y;

        System.out.println(restar.calcular(10, 20));
        System.out.println(multiplicar.calcular(5, 6));

    }
}
