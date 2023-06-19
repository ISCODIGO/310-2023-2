public class Main {
    public static void main(String[] args) {
        ListArray<Integer> enteros = new ListArray<>();  // capacidad 10

        enteros.append(10);
        //enteros.insert(10);  // < |10 >
        enteros.insert(20);  // < |20 10 >
        enteros.insert(30);  // < |30 20 10 >
        enteros.append(40);    // < |30 20 10 40 >
        enteros.remove();      // < |20 10 40 >
        enteros.remove();      // < |10 40 >
        enteros.remove();      // < |10 40 >
        System.out.println(enteros);

        /*enteros.clear();
        enteros.append(10);
        enteros.printArrayInterno();
        enteros.insert(55);

        System.out.println(enteros);  // <>
        enteros.printArrayInterno();*/

    }
}
