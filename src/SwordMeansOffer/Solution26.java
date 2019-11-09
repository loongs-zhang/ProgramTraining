package SwordMeansOffer;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author SuccessZhang
 * <p>
 * 原题：输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串
 * abc,acb,bac,bca,cab和cba。
 * <p>
 * 思路：1.初始化pre为空字符数组、left为str转化成的字符数组；
 * 2.遍历left数组，将遍历的字符添加到pre，同时left数组删除该字符串；
 * 3.往下递归，直到left数组为空，pre数组就是多个结果之一。
 */
public class Solution26 {

    private Set<String> result = new TreeSet<>();

    public ArrayList<String> Permutation(String str) {
        if ("".equals(str)) {
            return new ArrayList<>(result);
        }
        Permutation(new char[]{}, str.toCharArray());
        return new ArrayList<>(result);
    }

    public void Permutation(char[] pre, char[] left) {
        if (left.length == 0) {
            result.add(new String(pre));
            return;
        }
        for (int i = 0; i < left.length; i++) {
            char[] newPre = new char[pre.length + 1];
            for (int j = 0; j < pre.length; j++) {
                newPre[j] = pre[j];
            }
            newPre[pre.length] = left[i];
            char[] newLeft = new char[left.length - 1];
            for (int j = 0; j < i; j++) {
                newLeft[j] = left[j];
            }
            for (int j = i + 1; j < left.length; j++) {
                newLeft[j - 1] = left[j];
            }
            Permutation(newPre, newLeft);
        }
    }

    public static void main(String[] args) {
        Solution26 solution = new Solution26();
        System.out.println(solution.Permutation("abcd"));
    }
}