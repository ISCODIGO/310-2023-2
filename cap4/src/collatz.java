import java.util.Scanner;

public class collatz {
    static void generarSecuencia(int n) {
        do {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3*n + 1;
            }
            System.out.println(n);
        } while(n != 1);
    }

    public static void main(String[] args) {
        System.out.print("Escriba un entero: ");
        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();
        generarSecuencia(n);
    }
}
