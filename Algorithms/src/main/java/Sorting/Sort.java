package Sorting;

public interface Sort<T extends Comparable<T>> {
    Comparable<T>[] sort(Comparable<T>[]array);
}
