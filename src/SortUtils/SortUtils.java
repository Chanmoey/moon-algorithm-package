package SortUtils;

import java.util.Arrays;

/**
 * @author Chanmoey
 */
public class SortUtils {

    private static int minSplitLength = 15;

    public static void setMinSplitLength(int minSplitLength) {
        SortUtils.minSplitLength = minSplitLength;
    }

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

        if (SortUtils.isNotLegalArgument(arr.length, startIndex, endIndex)) {
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

        if (SortUtils.isNotLegalArgument(arr.length, startIndex, endIndex)) {
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

        if (SortUtils.isNotLegalArgument(arr.length, startIndex, endIndex)) {
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

    public static void shellSort(Comparable[] arr) {
        shellSort(arr, 0, arr.length - 1);
    }

    public static void shellSort(Comparable[] arr, int startIndex, int endIndex) {
        if (SortUtils.isNotLegalArgument(arr.length, startIndex, endIndex)) {
            throw new IllegalArgumentException("参数不对，请检查");
        }

        endIndex = SortUtils.formatEndIndex(arr.length, endIndex);

        int n = endIndex - startIndex + 1;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {

            // h-sort
            for (int i = h; i <= endIndex; i++) {

                Comparable e = arr[i];
                int j = i;
                for (; j >= h && e.compareTo(arr[j - h]) < 0; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = e;
            }

            h /= 3;
        }

    }

    public static void mergeSort(Comparable[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSortBU(Comparable[] arr) {
        mergeSortBU(arr, 0, arr.length);
    }

    public static void mergeSort(Comparable[] arr, int startIndex, int endIndex) {

        if ((endIndex - startIndex) <= minSplitLength) {
            insertSort(arr, startIndex, endIndex);
            return;
        }

        int mid = startIndex + (endIndex - startIndex) / 2;
        mergeSort(arr, startIndex, mid);
        mergeSort(arr, mid + 1, endIndex);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, startIndex, mid, endIndex);
        }
    }

    public static void mergeSortBU(Comparable[] arr, int startIndex, int endIndex) {
        if (SortUtils.isNotLegalArgument(arr.length, startIndex, endIndex)) {
            throw new IllegalArgumentException("参数不对，请检查");
        }

        endIndex = SortUtils.formatEndIndex(arr.length, endIndex);

        for (int sz = 1; sz <= endIndex + 1; sz += sz) {
            for (int i = 0; i + sz <= endIndex; i += sz + sz) {
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0) {
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, endIndex));
                }
            }
        }
    }

    private static void merge(Comparable[] arr, int startIndex, int mid, int endIndex) {

        Comparable[] temp = new Comparable[endIndex - startIndex + 1];
        int i = startIndex, j = mid + 1, index = 0;
        while (i <= mid && j <= endIndex) {
            if (arr[i].compareTo(arr[j]) < 0) {
                temp[index++] = arr[i++];
                continue;
            }
            temp[index++] = arr[j++];
        }

        while (i <= mid) {
            temp[index++] = arr[i++];
        }

        while (j <= endIndex) {
            temp[index++] = arr[j++];
        }

        i = startIndex;
        for (index = 0; index < temp.length; index++) {
            arr[i++] = temp[index];
        }

    }

    public static void quickSort(Comparable[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(Comparable[] arr, int startIndex, int endIndex) {

        if (startIndex >= endIndex) {
            return;
        }

        if ((endIndex - startIndex) <= minSplitLength) {
            insertSort(arr, startIndex, endIndex);
            return;
        }

        int p = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, p - 1);
        quickSort(arr, p + 1, endIndex);
    }

    private static int partition(Comparable[] arr, int startIndex, int endIndex) {

        swap(arr, startIndex, (int) (Math.random() * (endIndex - startIndex + 1)) + startIndex);
        Comparable v = arr[startIndex];

        //[startIndex + 1...i) <= e, (j...endIndex] >= e 。
        int i = startIndex + 1, j = endIndex;
        while (true) {
            while (i <= endIndex && arr[i].compareTo(v) < 0) {
                i++;
            }
            while (j >= startIndex + 1 && arr[j].compareTo(v) > 0) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, startIndex, j);
        return j;
    }

    public static void quickSort3Ways(Comparable[] arr) {
        quickSort3Ways(arr, 0, arr.length - 1);
    }

    public static void quickSort3Ways(Comparable[] arr, int startIndex, int endIndex) {

        if (startIndex >= endIndex) {
            return;
        }

        if (endIndex - startIndex <= minSplitLength) {
            insertSort(arr, startIndex, endIndex);
        }

        swap(arr, startIndex, (int) (Math.random() * (endIndex - startIndex + 1)) + startIndex);
        Comparable v = arr[startIndex];

        // arr[startIndex + 1 ... lt] < v, arr[gt ... endIndex] > v.
        // arr[lt + 1 ... i] == v
        int lt = startIndex, gt = endIndex + 1;
        int i = startIndex + 1;
        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, i++, ++lt);
            } else if (arr[i].compareTo(v) > 0) {
                swap(arr, i, --gt);
            } else {
                i++;
            }
        }

        swap(arr, startIndex, lt);
        quickSort3Ways(arr, startIndex, lt - 1);
        quickSort3Ways(arr, gt, endIndex);
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

    private static boolean isNotLegalArgument(int arrLength, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return true;
        }

        return startIndex == endIndex || startIndex >= arrLength;
    }

    private static int formatEndIndex(int arrLength, int endIndex) {

        if (endIndex >= arrLength) {
            return arrLength - 1;
        }

        return endIndex;
    }
}
