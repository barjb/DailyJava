package Algorithms;

import java.util.Arrays;

public class MergeSort implements Sort {
    @Override
    public Comparable[] sort(Comparable[] array) {
        return divide(array, 0, array.length - 1);
    }

    public Comparable[] divide(Comparable[] array, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            divide(array, l, m);
            divide(array, m + 1, r);
            merge(array, l, m, r);
        }
        return array;
    }

    public void merge(Comparable[] array, int l, int m, int r) {
        int llen = m - l + 1;
        int rlen = r - m;
        Comparable[] larr = Arrays.copyOfRange(array, l, l + llen);
        Comparable[] rarr = Arrays.copyOfRange(array, m + 1, m + rlen + 1);

        int i = 0;
        int j = 0;
        int k = l;
        while (i < llen && j < rlen) {
            if (larr[i].compareTo(rarr[j]) <= 0) {
                array[k] = larr[i];
                i++;
            } else {
                array[k] = rarr[j];
                j++;
            }
            k++;
        }
        while (i < llen) {
            array[k] = larr[i];
            i++;
            k++;
        }
        while (j < rlen) {
            array[k] = rarr[j];
            j++;
            k++;
        }
    }
}
