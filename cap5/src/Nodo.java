public class Nodo<T> {
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    private T dato;

    public Nodo<T> enlace;

    public Nodo(T dato) {
        this.dato = dato;
        this.enlace = null;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "dato=" + dato +
                '}';
    }
}
