package MapHeap;

import java.util.Arrays;

/**
 * @author Chanmoey
 */
public class Main {

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(100, Integer.class);


        for (int i = 0; i < 100; i++) {
            maxHeap.add(i);
        }
        System.out.print(maxHeap);

        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.removeFrist() + "->");
        }
    }
}
