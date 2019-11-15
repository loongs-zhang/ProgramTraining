package SwordMeansOffer;

import java.util.Arrays;

/**
 * @author SuccessZhang
 * <p>
 * 原题：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3,32,321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 * <p>
 * 思路：定义比较器规则，假设比较3和32，比较332和323的大小，小的在前，
 * 使用自定义的比较器，完成排序，遍历数组得到结果。
 */
public class Solution31 {

    public String PrintMinNumber(int[] numbers) {
        String[] array = new String[numbers.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(array, (o1, o2) -> Long.compare(
                Long.valueOf(o1 + o2),
                Long.valueOf(o2 + o1)
        ));
        StringBuilder sb = new StringBuilder();
        for (String s : array) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution31 solution = new Solution31();
        System.out.println(solution.PrintMinNumber(
                new int[]{3, 32, 321}));
    }
}