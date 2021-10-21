package SortUtils;

import java.util.Arrays;

/**
 * @author Chanmoey
 */
public class SortUtils {

    public static <E extends Comparable<? super E>> void selectSort(E[] arr) {
        SortUtils.selectSort(arr, 0, arr.length - 1);
    }

    /**
     * 默认且目前也只能升序排序。还可在优化，比如支持泛型(已经支持了)、传入自定义排序规则、升序倒序等待。
     *
     * @param arr        待排序的数组。
     * @param startIndex 开始排序的位置（包括此位置的元素）。
     * @param endIndex   结束排序的位置（包括此位置的元素）。
     */
    public static <E extends Comparable<? super E>> void selectSort(E[] arr, int startIndex, int endIndex) {

        if (startIndex > endIndex) {
            throw new IllegalArgumentException("startIndex应该小于endIndex！");
        }

        if (startIndex == endIndex || startIndex >= arr.length) {
            return;
        }

        if (endIndex >= arr.length) {
            endIndex = arr.length - 1;
        }

        int minIndex;
        for (int i = startIndex; i <= endIndex; i++) {
            minIndex = i;
            for (int j = i + 1; j <= endIndex; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);
        }
    }

    private static <E extends Comparable<? super E>> void swap(E[] nums, int firstIndex, int secondIndex) {

        if (firstIndex < 0 || secondIndex < 0 || firstIndex >= nums.length || secondIndex >= nums.length) {
            throw new IllegalArgumentException("交换元素索引必须在数组的合法范围内！");
        }

        if (firstIndex == secondIndex) {
            return;
        }
        E temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }

    public static <E extends Comparable<? super E>> boolean isSortedAsc(E[] arr) {
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

    public static <E extends Comparable<? super E>> void printArray(E[] arr) {
        printArray(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable<? super E>> void printArray(E[] arr, int start, int end) {

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
}
