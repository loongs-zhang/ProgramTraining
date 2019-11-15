package SwordMeansOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SuccessZhang
 * <p>
 * 原题：把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。习惯上
 * 我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * <p>
 * 思路：一个丑数一定由另一个丑数 乘2 或 乘3 或 乘5得到的。
 * 于是，用3个下标分别记录因子包含2、3、5的丑数，每次比较
 * 3个下标各丑数扩大它们因子的倍数之后值(比如初值都为1，
 * 分别比较1*2、1*3、1*5的大小)，得出最小值，将对应的下标+1
 * ，将最小值加入到丑数list中，最终需要的就是list的最大值。
 */
public class Solution32 {

    public int GetUglyNumber_Solution(int index) {
        if (index < 1) {
            return 0;
        }
        int index2 = 0, index3 = 0, index5 = 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        while (list.size() < index) {
            int temp2 = list.get(index2) * 2;
            int temp3 = list.get(index3) * 3;
            int temp5 = list.get(index5) * 5;
            int min = Math.min(Math.min(temp2, temp3), temp5);
            list.add(min);
            if (min == temp2) {
                index2++;
            }
            if (min == temp3) {
                index3++;
            }
            if (min == temp5) {
                index5++;
            }
        }
        return list.get(index - 1);
    }

    public static void main(String[] args) {
        Solution32 solution = new Solution32();
        System.out.println(solution.GetUglyNumber_Solution(1));
    }
}