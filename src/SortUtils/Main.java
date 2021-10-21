package SortUtils;

/**
 * @author Chanmoey
 */
public class Main {

    public static void main(String[] args) {

        int n = 10000;

        Integer[] arr = SortTestHelper.getRandomArray(n, 0, n);
        SortUtils.printArray(arr);
        SortUtils.selectSort(arr);
        SortUtils.printArray(arr, 100, 200);
        System.out.println(SortUtils.isSortedAsc(arr));
    }
}
