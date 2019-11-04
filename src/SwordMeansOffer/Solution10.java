package SwordMeansOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SuccessZhang
 * <p>
 * 原题：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多
 * 少种方法？
 * <p>
 * 思路：覆盖2*n的方法 = 覆盖2*(n-1)的方法(一次放一个) +
 *                       覆盖2*(n-2)的方法(一次放两个)
 * 引入map进行优化，递归时如果已经计算过该值，直接返回
 */
public class Solution10 {

    private Map<Integer, Integer> map = new HashMap<>();

    public int RectCover(int target) {
        if (target <= 2) {
            return target;
        }
        if (map.containsKey(target)) {
            return map.get(target);
        }
        map.put(target, RectCover(target - 1) + RectCover(target - 2));
        return map.get(target);
    }

    public static void main(String[] args) {
        Solution10 solution = new Solution10();
        System.out.println(solution.RectCover(10));
    }
}