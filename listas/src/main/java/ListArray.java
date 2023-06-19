import java.util.Arrays;
import java.util.NoSuchElementException;

public class ListArray<E> implements List<E> {
    // Atributos internos del ArrayList
    private E[] data;  // arreglo interno
    private int size;  // cantidad de elementos de la lista
    private int current;  // posicion actual

    private static int DEFAULT_CAPACITY = 10;

    public ListArray() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
        clear();
    }

    @Override
    public void clear() {
        size = 0;
        current = 0;
    }

    @Override
    public boolean insert(E it) {
        if (size == data.length) {
            return false;
        }

        for (int i = size - 1; i >= current; i--) {
            data[i + 1] = data[i];
        }
        data[current] = it;
        size++;
        return true;
    }

    @Override
    public boolean append(E it) {
        if (size == data.length) {
            return false;
        }

        data[size] = it;
        size++;
        return true;
    }

    @Override
    public E remove() throws NoSuchElementException {
        if (size == 0) throw new NoSuchElementException();

        E temp = data[current];

        // rescribiendo el elemento actual con el futuro
        for (int i = current; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        prev();  // moverse hacia atras para no perder current
        return temp;
    }

    @Override
    public void moveToStart() {
        current = 0;
    }

    @Override
    public void moveToEnd() {
        current = size - 1;
    }

    @Override
    public void prev() {
        if (current > 0) {
            current--;
        }
    }

    @Override
    public void next() {
        if (current < size - 1) {
            current++;
        }
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public int currPos() {
        return current;
    }

    @Override
    public boolean moveToPos(int pos) {
        if (isValidPosition(pos)) {
            current = pos;
            return true;
        }
        return false;
    }

    @Override
    public boolean isAtEnd() {
        if (current == size - 1) {
            return true;
        }
        return false;
    }

    @Override
    public E getValue() throws NoSuchElementException {
        if (isValidPosition(current) && !isEmpty()) {
            return data[current];
        }
        throw new NoSuchElementException();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // funciones fuera de la interface List

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("< ");

        for (int i = 0; i < size; i++) {
            if (i == current) {
                sb.append("|");
            }
            sb.append(data[i]);
            sb.append(" ");
        }

        sb.append(" >");
        return sb.toString();
    }

    public void printArrayInterno() {
        System.out.println(Arrays.toString(data));
    }

    private boolean isValidPosition(int pos) {
        return (pos >= 0 || pos <= size - 1);
    }
}
