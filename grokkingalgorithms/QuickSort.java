package grokkingalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class QuickSort {

    // Test
    public static void main(String[] args) {
        int[] testArray = {5, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(quickSort(testArray)));
    }

    public static int[] quickSort(int[] arr) {
        if (arr.length < 2)
            return arr;
        else {
            int[] base = {arr[0]};
            ArrayList<Integer> greater = new ArrayList<>();
            ArrayList<Integer> less = new ArrayList<>();
            Arrays.stream(arr).filter(x -> x > base[0]).forEach(greater::add);
            Arrays.stream(arr).filter(x -> x <= base[0]).forEach(less::add);
            less.remove((Integer) base[0]);

            int[] sortedLess = quickSort(less.stream().mapToInt(x -> x).toArray());
            int[] sortedGreater = quickSort(greater.stream().mapToInt(x -> x).toArray());

            return Stream.concat(Stream.concat(Arrays.stream(sortedLess).boxed(), Arrays.stream(base).boxed()),
                    Arrays.stream(sortedGreater).boxed()).mapToInt(x -> x).toArray();
        }
    }
}
