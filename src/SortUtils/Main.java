package SortUtils;

import java.util.Arrays;

/**
 * @author Chanmoey
 */
public class Main {

    public static void main(String[] args) {


        int n = 100000;
        SortTestHelper.testSort("SortUtils.SortUtils", "selectSort", SortTestHelper.getRandomArray(n, 0, n));
        SortTestHelper.testSort("SortUtils.SortUtils", "insertSort", SortTestHelper.getRandomArray(n, 0, n));
        SortTestHelper.testSort("SortUtils.SortUtils", "bubbleSort", SortTestHelper.getRandomArray(n, 0, n));
        SortTestHelper.testSort("SortUtils.SortUtils", "shellSort", SortTestHelper.getRandomArray(n, 0, n));
        SortTestHelper.testSort("SortUtils.SortUtils", "mergeSort", SortTestHelper.getRandomArray(n, 0, n));
        SortTestHelper.testSort("SortUtils.SortUtils", "mergeSortBU", SortTestHelper.getRandomArray(n, 0, n));
        SortTestHelper.testSort("SortUtils.SortUtils", "quickSort", SortTestHelper.getRandomArray(n, 0, n));
        SortTestHelper.testSort("SortUtils.SortUtils", "quickSort3Ways", SortTestHelper.getRandomArray(n, 0, n));
        SortTestHelper.testSort("SortUtils.SortUtils", "heapSort", SortTestHelper.getRandomArray(n, 0, n));

        // 这一段，在一个新的线程中测试排序算法。由于CPU对线程的调度，每个线程运行的效率变低，不过总体是会提高？没测试过.
//        String[] methodName = {"selectSort", "insertSort", "bubbleSort", "shellSort", "mergeSort", "mergeSortBU", "quickSort"};
//        int sortMethods = methodName.length;
//        for (int i = 0; i < sortMethods; i++) {
//            int finalI = i;
//            new Thread(() -> {
//                SortTestHelper.testSort("SortUtils.SortUtils", methodName[finalI], SortTestHelper.getRandomArray(n, 0, n));
//            }).start();
//        }

        // 这一段测试在排序元素小于多少时，停止继续切割，改为插入排序性能最好。
//        double[] times = new double[1000];
//        Comparable[] arr = SortTestHelper.getRandomArray(n, 0, n);
//        Comparable[] arrCopy = new Comparable[arr.length];
//        for (int i = 0; i < 1000; i++) {
//            SortUtils.setN(i + 2);
//            for (int j = 0; j < arr.length; j++) {
//                arrCopy[j] = arr[j];
//            }
//            times[i] = SortTestHelper.testSort("SortUtils.SortUtils", "mergeSort", arrCopy);
//        }
//
//        double min = 1.0;
//        int index = -1;
//        for (int i = 0; i < times.length; i ++) {
//            if (times[i] < min) {
//                min = times[i];
//                index = i;
//            }
//        }
//        System.out.println(index);
    }
}
