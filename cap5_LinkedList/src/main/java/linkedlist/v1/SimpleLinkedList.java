package linkedlist.v1;

import linkedlist.List;
import java.util.NoSuchElementException;

public class SimpleLinkedList<T> implements List<T> {
    // Atributos de la lista enlazada;
    private Nodo<T> head;  // apunta el primer nodo
    private Nodo<T> tail;  // apunta al ultimo nodo
    private int size;  // cantidad de nodos

    private int curr;  // posicion del nodo actual

    public SimpleLinkedList() {
        clear();
    }

    private boolean insertFirstNode(Nodo n) {
        this.head = n;
        this.tail = n;
        this.size++;
        return true;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
        curr = 0;
    }

    @Override
    public boolean insert(T it) {
        /*
        Algo particular de esta funcion es que no permite insertar al final
        puede ser al inicio o enmedio pero no al final.
         */
        var newNodo = new Nodo<>(it);

        // insertar primer nodo
        if (this.isEmpty()) {
            return this.insertFirstNode(newNodo);
        }

        // insertar al inicio
        if (getNode() == head) {
            newNodo.siguiente = head;
            head = newNodo;
        }
        // insertar nodos intermedios
        else {
            this.prev();
            var previo = getNode();
            curr++;  // para recuperar el curr
            newNodo.siguiente = previo.siguiente;
            previo.siguiente = newNodo;
        }

        size++;
        return true;
    }

    @Override
    public boolean append(T it) {
        var newNode = new Nodo<>(it);

        if (this.isEmpty()) {
            return this.insertFirstNode(newNode);
        }

        tail.siguiente = newNode;
        tail = newNode;

        size++;
        return true;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (this.isEmpty())
            throw new NoSuchElementException();

        T dato = getValue();

        // remover el primer nodo
        if (getNode() == head) {
            head = getNode().siguiente;
        }
        else {
            // situarse justo antes de curr
            prev();
            Nodo<T> previo = getNode();

            // remover el ultimo nodo
            if (previo.siguiente == null) {
                previo.siguiente = null;
                tail = previo;
                moveToEnd();  // evitar que curr sea un valor invalido
            }
            // remover nodos interiores
            else {
                previo.siguiente = previo.siguiente.siguiente;
            }
        }
        size--;
        return dato;
    }

    @Override
    public void moveToStart() {
        curr = 0;
    }

    @Override
    public void moveToEnd() {
        curr = size - 1;
    }

    @Override
    public void prev() {
        if (curr == 0) return;

        curr--;
    }

    @Override
    public void next() {
        if (curr == size - 1) return;

        curr++;
    }

    @Override
    public int length() {
        return this.size;
    }

    @Override
    public int currPos() {
        return curr;
    }

    @Override
    public boolean moveToPos(int pos) {
        if (pos < 0 || pos >= size) {
            return false;
        }
        curr = pos;
        return true;
    }

    @Override
    public boolean isAtEnd() {
        return curr == size - 1;
    }

    @Override
    public T getValue() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        return this.getNode().getDato();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Nodo<T> getNode() {
        if (this.isEmpty()) return  null;
        Nodo<T> aux;
        int pos = 0;

        for (aux = head; aux != null; aux = aux.siguiente) {
            if (pos == curr) break;
            pos++;
        }
        return aux;
    }
    public class Nodo<T> {
        public T getDato() {
            return dato;
        }

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }

        @Override
        public String toString() {
            return dato.toString();
        }

        private T dato;
        Nodo<T> siguiente;
    }
}
