package SwordMeansOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author SuccessZhang
 * <p>
 * 原题：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4。
 * <p>
 * 思路：用最大堆保存这k个数，每次只和堆顶比，如果比堆顶小，
 * 删除堆顶，新数入堆。
 */
public class Solution28 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k <= 0 || input.length < k) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int value : input) {
            if (maxHeap.size() != k) {
                maxHeap.offer(value);
            } else if (maxHeap.peek() > value) {
                maxHeap.poll();
                maxHeap.offer(value);
            }
        }
        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) {
        Solution28 solution = new Solution28();
        System.out.println(solution.GetLeastNumbers_Solution(
                new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4));
    }
}