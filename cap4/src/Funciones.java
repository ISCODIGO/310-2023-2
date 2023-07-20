import java.util.Arrays;
import java.util.Random;

public class Funciones {

    static void historiaLanzamientos(int[] historia, int lanzamiento) {
        historia[lanzamiento]++;
    }
    static int lanzamientoDado() {
        // devolver un numero aleatorio entre 1 y 6
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public static void main(String[] args) {
        int valor = lanzamientoDado();
        final int N = 1000;
        int[] historial = new int[7];

        for (int i = 0; i < N; i++) {
            int lanzamiento = lanzamientoDado();
            historiaLanzamientos(historial, lanzamiento);
        }

        System.out.println(Arrays.toString(historial));
    }
}

