public class BusquedaLineal {
    static int iteraciones;
    static int busqueda(int[] a, int v) {
        for(int i = 0; i < a.length; i++) {
            iteraciones++;
            if (v == a[i]) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {10, 23, 12, 4, 56, 2, 6, 2, 33};
        int x = 10;
        iteraciones = 0;

        System.out.println(busqueda(arr, x));
        System.out.printf("N=%d, iteraciones=%d", arr.length, iteraciones);
    }
}
