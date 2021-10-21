package SortUtils;

import java.util.Random;

/**
 * @author Chanmoey
 */
public class SortTestHelper {

    public static Integer[] getRandomArray(int size, int left, int right) {

        assert left <= right;

        Integer[] arr = new Integer[size];

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = left + random.nextInt(right + 1) % (right - left + 1);
        }

        return arr;
    }
}
