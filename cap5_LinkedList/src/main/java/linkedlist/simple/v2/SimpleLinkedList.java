/*

El asunto de esta version es utilizar curr como una referencia de tipo Nodo en
lugar de un entero que ubica las posiciones.

Objetivo: Cambiar en las funciones existentes este rol. También se removió la
función getNode para utilizar directamente curr.
 */

package linkedlist.simple.v2;

import linkedlist.List;

import java.util.NoSuchElementException;

public class SimpleLinkedList<T> implements List<T> {
    // Atributos de la lista enlazada;
    private Nodo<T> head;  // apunta el primer nodo
    private Nodo<T> tail;  // apunta al ultimo nodo
    private int size;  // cantidad de nodos

    private Nodo<T> curr;  // posición del nodo actual

    public SimpleLinkedList() {
        clear();
    }

    private boolean insertFirstNode(Nodo<T> n) {
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

        Nodo<T> oldCurr = getNode();  // guardar el valor del nodo a eliminar

        // remover el primer nodo
        if (oldCurr == head) {
            head = head.siguiente;
        }
        else {
            // situarse justo antes de curr
            prev();
            Nodo<T> prevNodo = getNode();
            prevNodo.siguiente = prevNodo.siguiente.siguiente;

            // remover el ultimo nodo
            if (oldCurr == tail) {
                tail = prevNodo;
            }
        }
        size--;
        return oldCurr.getDato();
    }

    @Override
    public void moveToStart() {
        curr = head;
    }

    @Override
    public void moveToEnd() {
        curr = tail;
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
        return curr == tail;
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

        private final T dato;
        Nodo<T> siguiente;
    }
}
