package Sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Sort<Integer> quickSort = new QuickSort<>();
        Sort<Integer> mergeSort = new MergeSort<>();
        Integer[] arr = {5, 4, 3, 2, 0, 1};

        System.out.println(Arrays.stream(quickSort.sort(arr)).map(Object::toString).collect(Collectors.joining(" ")));
//        System.out.println(Arrays.stream(mergeSort.sort(arr)).map(Object::toString).collect(Collectors.joining(" ")));
    }
}
