package SwordMeansOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SuccessZhang
 * <p>
 * 原题：输入一个整数数组，判断该数组是不是某二叉搜索树的
 * 后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的
 * 数组的任意两个数字都互不相同。
 * <p>
 * 思路：BST的后序序列的合法序列是，对于一个序列S，最后一
 * 个元素是x（也就是根），如果去掉最后一个元素的序列为T，
 * 那么T满足：T可以分成两段，前一段（左子树）小于x，后一
 * 段（右子树）大于x，且这两段（子树）都是合法的后序序列。
 */
public class Solution23 {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return isFromBST(sequence);
    }

    public boolean isFromBST(int[] sequence) {
        if (sequence.length <= 1) {
            return true;
        }
        //最后一个必定是根节点
        int root = sequence[sequence.length - 1];
        //比根节点小的是左子树，比根节点大的是右子树
        List<Integer> lList = new ArrayList<>();
        List<Integer> rList = new ArrayList<>();
        int index;
        for (index = 0; index < sequence.length - 1; index++) {
            if (sequence[index] < root) {
                lList.add(sequence[index]);
            } else {
                break;
            }
        }
        for (; index < sequence.length - 1; index++) {
            if (sequence[index] < root) {
                return false;
            }
            rList.add(sequence[index]);
        }
        //list转化为array
        int[] left = new int[lList.size()];
        int[] right = new int[rList.size()];
        for (int i = 0; i < left.length; i++) {
            left[i] = lList.get(i);
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = rList.get(i);
        }
        return isFromBST(left) && isFromBST(right);
    }

    public static void main(String[] args) {
        Solution23 solution = new Solution23();
        System.out.println(solution.VerifySquenceOfBST(
                new int[]{}));
    }
}