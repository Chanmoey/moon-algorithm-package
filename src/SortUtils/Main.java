package SortUtils;

import java.util.Arrays;

/**
 * @author Chanmoey
 */
public class Main {

    public static void main(String[] args) {

        int n = 100000;
        Integer[] arr = SortTestHelper.getNearlyOrderedArray(n, 10);
        Integer[] copy = Arrays.copyOf(arr, arr.length);

        SortTestHelper.testSort("SortUtils.SortUtils", "selectSort", arr);
        SortTestHelper.testSort("SortUtils.SortUtils", "insertSort", copy);



    }
}
