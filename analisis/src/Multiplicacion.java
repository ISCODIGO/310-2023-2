public class Multiplicacion {
    public static int version1(int a, int b){
        return a*b;
        }
    public static int version2(int a, int b) {
        int total = 0;
        for(int i = 1; i <= b; i++) {
            total += a;
        }

        return total;
    }
}
