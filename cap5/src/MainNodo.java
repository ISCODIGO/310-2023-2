public class MainNodo {
    public static void main(String[] args) {
        Nodo<Integer> n1 = new Nodo<>(10);
        Nodo<Integer> n2 = new Nodo<>(20);
        Nodo<Integer> n3 = new Nodo<>(30);

        n1.enlace = n2;  // copia superficial
        n1.enlace.setDato(40);  // modificando el dato de n2

        n2.enlace = n3;

        System.out.println(n1);
        System.out.println(n2);

        System.out.println(n1.enlace.enlace.enlace.getDato());
    }
}
