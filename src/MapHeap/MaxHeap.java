package MapHeap;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Chanmoey
 */
public class MaxHeap<E extends Comparable<E>> {

    private E[] data;
    private int size;
    private int capacity;
    private static final int TWO = 2;

    @SuppressWarnings("unchecked")
    public MaxHeap(int capacity) {
        this.data = (E[]) new Comparable[capacity + 1];
        this.size = 0;
        this.capacity = capacity;
    }

    public MaxHeap() {
        this(16);
    }

    @SuppressWarnings("unchecked")
    public MaxHeap(E[] arr) {
        this.data = (E[]) new Comparable[arr.length + 1];
        this.capacity = arr.length;
        System.arraycopy(arr, 0, this.data, 1, arr.length);
        this.size = arr.length;

        for (int i = this.size / TWO; i >= 1; i--) {
            this.shiftDown(i);
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int length() {
        return this.size;
    }

    public void add(E e) {

        assert this.capacity >= this.size + 1;
        this.data[++this.size] = e;
        this.shiftUp(this.size);
    }

    private void shiftUp(int index) {

        E e = this.data[index];
        while (index > 1 && this.data[index / TWO].compareTo(e) < 0) {
            this.data[index] = this.data[index / TWO];
            index /= 2;
        }
        this.data[index] = e;
    }

    public E removeMax() {
        assert this.size > 0;
        E e = this.data[1];
        this.swap(this.data, 1, this.size);
        this.size--;
        this.shiftDown(1);
        return e;
    }

    private void shiftDown(int index) {

        E e = this.data[index];
        while (index * 2 <= this.size) {
            int j = 2 * index;
            if (j + 1 <= this.size && this.data[j + 1].compareTo(this.data[j]) > 0) {
                j++;
            }
            if (e.compareTo(this.data[j]) >= 0) {
                break;
            }

            this.data[index] = this.data[j];
            index = j;
        }
        this.data[index] = e;
    }

    private void swap(E[] arr, int firstIndex, int secondIndex) {
        E temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    @Override
    public String toString() {
        E[] temp = Arrays.copyOfRange(this.data, 1, this.size + 1);
        return Arrays.toString(temp);
    }
}
