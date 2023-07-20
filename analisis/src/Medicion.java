public class Medicion {
    public static void main(String[] args) {
        long inicial1, inicial2, final1, final2;
        int b = 10;
        int a = 100_000_000;

        inicial1 = System.nanoTime();
        Multiplicacion.version1(a, b);
        final1 = System.nanoTime();

        inicial2 = System.nanoTime();
        Multiplicacion.version2(a, b);
        final2 = System.nanoTime();

        System.out.println("Tiempo1: " + (final1-inicial1));
        System.out.println("Tiempo2: " + (final2-inicial2));

    }
}
