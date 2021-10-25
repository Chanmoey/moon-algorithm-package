package SortUtils;

import java.util.Arrays;

/**
 * @author Chanmoey
 */
public class Main {

    public static void main(String[] args) {

        int n = 10000;
//        Integer[] select = SortTestHelper.getRandomArray(n, 0, n);
//        Integer[] insert = Arrays.copyOf(select, select.length);
//        Integer[] bubble = Arrays.copyOf(select, select.length);
//        SortTestHelper.testSort("SortUtils.SortUtils", "selectSort", select);
//        SortTestHelper.testSort("SortUtils.SortUtils", "insertSort", insert);
//        SortTestHelper.testSort("SortUtils.SortUtils", "bubbleSort", bubble);

        int sortMethods = 3;
        String[] methodName = {"selectSort", "insertSort", "bubbleSort"};
        for (int i = 0; i < sortMethods; i++) {
            int finalI = i;
            new Thread(() -> {
                SortTestHelper.testSort("SortUtils.SortUtils", methodName[finalI], SortTestHelper.getRandomArray(n, 0, n));
            }).start();
        }
    }
}
