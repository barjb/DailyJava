package Sorting;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public Comparable<T>[] sort(Comparable<T>[] array) {
        return qsort(array, 0, array.length - 1);
    }

    public Comparable<T>[] qsort(Comparable<T>[] array, int l, int r) {
        if (l < r) {
            int i = divide(array, l, r);
            qsort(array, l, i - 1);
            qsort(array, i + 1, r);
        }
        return array;
    }

    public int divide(Comparable<T>[] array, int l, int r) {
        int index = chooseIndex(l, r);
        Comparable<T> pivot = array[index];
        swap(array, index, r);

        int current = l;
        for (int i = l; i <= r - 1; i++) {
            if (array[i].compareTo((T) pivot) < 0) {
                swap(array, i, current);
                current = current + 1;
            }
        }
        swap(array, current, r);
        return current;
    }

    public void swap(Comparable<T>[] array, int i, int j) {
        if (i != j) {
            Comparable<T> temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public int chooseIndex(int l, int r) {
        return l + (r - l) / 2;
    }
}
