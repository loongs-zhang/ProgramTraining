package SwordMeansOffer;

/**
 * @author SuccessZhang
 * <p>
 * 原题：一只青蛙一次可以跳上1级台阶，
 * 也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多
 * 少种跳法。
 * <p>
 * 思路：归纳查看规律发现实际上是求2^(n-1)
 */
public class Solution9 {

    public int JumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }

    public static void main(String[] args) {
        Solution9 solution = new Solution9();
        System.out.println(solution.JumpFloorII(3));
    }
}