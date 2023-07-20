import java.util.Arrays;
import java.util.Collections;

public class BusquedaBinaria {
    static int iteraciones;
    static int busqueda(int[] a, int v) {
        int inicial = 0;
        int fin = a.length - 1;

        while (inicial <= fin) {
            iteraciones++;
            int mitad = (fin - inicial) / 2 + inicial;
            if (a[mitad] == v) {
                return mitad;
            } else if (v < a[mitad]) {
                fin = mitad - 1;
            } else {
                inicial = mitad + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int x = 100;
        int[]  arr = {10, 2, 31, 5, 7, 3, 45, 33, 2, 1};
        iteraciones = 0;

        // Reordenar arr para que funcion la busqueda binaria
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(busqueda(arr, x));
        System.out.printf("N=%d, iteraciones=%d", arr.length, iteraciones);

    }
}
