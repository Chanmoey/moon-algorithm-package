package SortUtils;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author Chanmoey
 */
public class SortTestHelper {

    private SortTestHelper() {
    }

    public static Integer[] getRandomArray(int size, int left, int right) {

        assert left <= right;

        Integer[] arr = new Integer[size];

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = left + random.nextInt(right + 1) % (right - left + 1);
        }

        return arr;
    }

    public static double testSort(String sortClassName, String methodName, Comparable[] arr) {

        try {
            Class<?> sortClass = Class.forName(sortClassName);
            Method sortMethod = sortClass.getMethod(methodName, Comparable[].class);

            long startTime = System.currentTimeMillis();
            sortMethod.invoke(null, (Object) arr);
            long endTime = System.currentTimeMillis();

            if (!isSortedAsc(arr)) {
                throw new AssertionError("排序失败");
            }

            System.out.println(sortClass.getSimpleName() + "-" + methodName + " : " + (endTime - startTime) / 1000.0 + "s");
            return (endTime - startTime) / 1000.0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1.0;
    }

    public static boolean isSortedAsc(Comparable[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("数组引用不能为null!");
        }

        int maxIndex = arr.length - 1;
        if (maxIndex == -1) {
            return true;
        }

        for (int i = 0; i < maxIndex; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }

        return true;
    }

    public static void printArray(Object[] arr) {
        printArray(arr, 0, arr.length - 1);
    }

    public static void printArray(Object[] arr, int start, int end) {

        if (arr == null) {
            System.out.println("null");
            return;
        }

        if (arr.length == 0) {
            System.out.println("[]");
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = start; ; i++) {
            b.append(arr[i]);
            if (i == end) {
                b.append(']');
                break;
            }
            b.append(", ");
        }

        System.out.println(b);
    }

    public static Integer[] getNearlyOrderedArray(int n, int swapTimes){

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        Random random = new Random();
        for (int i = 0; i < swapTimes; i++) {
            int firstIndex = random.nextInt(n);
            int secondIndex = random.nextInt(n);
            int t = arr[firstIndex];
            arr[firstIndex] = arr[secondIndex];
            arr[secondIndex] = arr[firstIndex];
        }

        return arr;
    }
}
