package SwordMeansOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SuccessZhang
 * <p>
 * 原题：一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次
 * 序不同算不同的结果）。
 * <p>
 * 思路：跳上n级的跳法 = 跳上n-1阶的跳法 + 跳上n-2阶的跳法
 * 引入map进行优化，递归时如果已经计算过该值，直接返回
 * <p>
 * 其他解法：归纳查看规律发现实际上是求斐波那契数列第n项的值
 */
public class Solution8 {

    private Map<Integer, Integer> map = new HashMap<>();

    public int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        if (map.containsKey(target)) {
            return map.get(target);
        }
        map.put(target, JumpFloor(target - 1) + JumpFloor(target - 2));
        return map.get(target);
    }

    public static void main(String[] args) {
        Solution8 solution = new Solution8();
        System.out.println(solution.JumpFloor(50));
    }
}