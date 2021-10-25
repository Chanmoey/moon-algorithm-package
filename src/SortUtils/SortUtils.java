package SortUtils;

import java.util.Arrays;

/**
 * @author Chanmoey
 */
public class SortUtils {

    private SortUtils() {
    }

    public static void selectSort(Comparable[] arr) {
        SortUtils.selectSort(arr, 0, arr.length - 1);
    }

    /**
     * 默认且目前也只能升序排序。还可在优化，比如支持泛型(已经支持了)、传入自定义排序规则、升序倒序等待。
     *
     * @param arr        待排序的数组。
     * @param startIndex 开始排序的位置（包括此位置的元素）。
     * @param endIndex   结束排序的位置（包括此位置的元素）。
     */
    public static void selectSort(Comparable[] arr, int startIndex, int endIndex) {

        if (!SortUtils.isLegalArgument(arr.length, startIndex, endIndex)) {
            throw new IllegalArgumentException("参数不对，请检查");
        }

        endIndex = SortUtils.formatEndIndex(arr.length, endIndex);

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

    public static void insertSort(Comparable[] arr) {
        SortUtils.insertSort(arr, 0, arr.length - 1);
    }

    /**
     * 插入排序的优化策略，交换操作比较耗时，通过减少交换来提升插入排序性能。
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void insertSort(Comparable[] arr, int startIndex, int endIndex) {

        if (!SortUtils.isLegalArgument(arr.length, startIndex, endIndex)) {
            throw new IllegalArgumentException("参数不对，请检查");
        }

        endIndex = SortUtils.formatEndIndex(arr.length, endIndex);

        for (int i = startIndex + 1; i <= endIndex; i++) {

            Comparable e = arr[i];
            int j = i;
            for (; j > startIndex && e.compareTo(arr[j - 1]) < 0; j--) {
//                    SortUtils.swap(arr, j - 1, j); 不要交换，改为下面的赋值。
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    public static void bubbleSort(Comparable[] arr) {
        bubbleSort(arr, 0, arr.length);
    }

    public static void bubbleSort(Comparable[] arr, int startIndex, int endIndex) {

        if (!SortUtils.isLegalArgument(arr.length, startIndex, endIndex)) {
            throw new IllegalArgumentException("参数不对，请检查");
        }

        endIndex = SortUtils.formatEndIndex(arr.length, endIndex);


        for (int i = startIndex; i < endIndex; i++) {
            int j;
            for (j = i + 1; j <= endIndex; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    swap(arr, i, j);
                }
            }

            // 前一次确定好的顺序，后一次就不需要再比较了。
            endIndex = j - 1;
        }

    }

    private static void swap(Object[] nums, int firstIndex, int secondIndex) {

        if (firstIndex < 0 || secondIndex < 0 || firstIndex >= nums.length || secondIndex >= nums.length) {
            throw new IllegalArgumentException("交换元素索引必须在数组的合法范围内！");
        }

        if (firstIndex == secondIndex) {
            return;
        }
        Object temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }

    private static boolean isLegalArgument(int arrLength, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return false;
        }

        return startIndex != endIndex && startIndex < arrLength;
    }

    private static int formatEndIndex(int arrLength, int endIndex) {

        if (endIndex >= arrLength) {
            return arrLength - 1;
        }

        return endIndex;
    }
}
