package grokkingalgorithms;

import java.util.Arrays;

public class SelectionSort {

    // Test
    public static void main(String[] args) {
        int[] array = {3, 34, 15, 2, 1, 367};
        System.out.println(Arrays.toString(selectSort(array)));
    }

    private static int findSmallest(int[] array) {
        int smallest = array[0];
        int smallestIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    private static int[] selectSort(int[] array) {
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[findSmallest(array)];
            array[findSmallest(array)] = Integer.MAX_VALUE;
        }
        return sortedArray;
    }
}
