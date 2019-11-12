package SwordMeansOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SuccessZhang
 * <p>
 * 原题：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现
 * 了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * <p>
 * 思路：用一个map保存数组中各元素出现的次数，再遍历map，尝试获取出现
 * 次数超过数组长度一半的数字，获取成功直接返回，获取失败返回0。
 */
public class Solution27 {

    public int MoreThanHalfNum_Solution(int[] array) {
        int result = 0;
        if (array == null || array.length == 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>(array.length);
        for (int integer : array) {
            if (map.containsKey(integer)) {
                map.put(integer, map.get(integer) + 1);
            } else {
                map.put(integer, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= array.length / 2 + 1) {
                return entry.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution27 solution = new Solution27();
        System.out.println(solution.MoreThanHalfNum_Solution(
                new int[]{4, 2, 1, 4, 2, 4}));
    }
}