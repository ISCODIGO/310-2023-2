import java.util.Arrays;

public class Ambito2 {
    static void funcion(int[] arr) {
        arr[0] = arr[0] * 2;
    }

    public static void main(String[] args) {
        int[] valor = {10, 20, 30};
        funcion(valor);
        System.out.println("Fuera de la funcion..." + Arrays.toString(valor));
    }
}
