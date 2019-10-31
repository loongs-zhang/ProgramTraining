package SwordMeansOffer;

/**
 * @author SuccessZhang
 * <p>
 * 原题：大家都知道斐波那契数列，现在要求输入一个整数n(n<=39)，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * <p>
 * 思路：利用三个变量，从小到大依次计算
 */
public class Solution7 {

    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int result = 0, temp1 = 1, temp2 = 1;
        for (int i = 2; i < n; i++) {
            result = temp1 + temp2;
            temp1 = temp2;
            temp2 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution7 solution = new Solution7();
        System.out.println(solution.Fibonacci(4));
    }
}