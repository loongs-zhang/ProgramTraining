package SwordMeansOffer;

/**
 * @author SuccessZhang
 * <p>
 * 原题：给定一个double类型的浮点数base和int
 * 类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 * <p>
 * 思路：求result=base^log(exponent)，然后求result的平方，
 * 如果exponent是奇数，再乘一次base；
 * 如求2^10=(2^5)*(2^5)=(2^2*2)*(2^2*2)
 */
public class Solution12 {

    public double Power(double base, int exponent) {
        int n = exponent > 0 ? exponent : -exponent;
        if (base == 0 && exponent <= 0) {
            throw new RuntimeException();
        } else if (base == 0 && exponent > 0) {
            return 0;
        } else if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        }
        //求base^log(exponent)
        double result = Power(base, n >> 1);
        result = result * result;
        //如果exponent为奇数，奇数次方最后还需要乘一下
        if ((n & 1) == 1) {
            result = result * base;
        }
        return exponent > 0 ? result : 1 / result;
    }

    public static void main(String[] args) {
        Solution12 solution = new Solution12();
        System.out.println(solution.Power(2, -4));
    }
}