package SwordMeansOffer;

import java.util.Arrays;

/**
 * @author SuccessZhang
 * <p>
 * 原题：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * <p>
 * 思路：插入排序，往后遍历时，若遇到偶数，扩大偶数序列；
 * 若遇到奇数，将偶数序列后第一个奇数插入到偶数序列的前面
 */
public class Solution13 {

    public void reOrderArray(int[] array) {
        int start = 0, end = 0;
        int temp;
        //初始化start,end
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 0) {
                start = i;
                break;
            }
        }
        for (int i = start; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                end = i;
                break;
            }
        }
        //处理边界情况
        if (start >= end) {
            return;
        }
        while (end != array.length - 1) {
            //寻找偶数队列结尾
            for (int i = start; i < array.length; i++) {
                if ((array[i] & 1) == 1) {
                    end = i;
                    break;
                }
            }
            //将奇数插入到当前偶数序列的前面
            temp = array[end];
            for (int i = end; i > start; i--) {
                array[i] = array[i - 1];
            }
            array[start] = temp;
            start++;
        }
        //处理边界情况
        if ((array[end] & 1) == 1) {
            temp = array[end];
            for (int i = end; i > start; i--) {
                array[i] = array[i - 1];
            }
            array[start] = temp;
        }
    }

    public static void main(String[] args) {
        Solution13 solution = new Solution13();
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        solution.reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
}