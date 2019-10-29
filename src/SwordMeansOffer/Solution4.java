package SwordMeansOffer;

import java.util.ArrayList;

/**
 * @author SuccessZhang
 * <p>
 * 原题：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前
 * 序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重
 * 建二叉树并返回。
 * <p>
 * 思路：前序遍历结果的第一个值一定是根节点的值，
 * 根据根节点的值去中序遍历结果中查找根节点的下标，
 * 又根据根节点的下标和中序遍历的结果，
 * 确定左子树和右子树的前序、中序遍历结果，
 * 依次往下递归，直到子树为空或者仅有一个“根节点”。
 */
public class Solution4 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if (pre.length == 1) {
            return root;
        }
        int index = -1;
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                index = i;
                break;
            }
        }
        //尝试构建左子树
        ArrayList<Integer> leftIn = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            leftIn.add(in[i]);
        }
        if (leftIn.size() > 0) {
            int[] newPre = new int[leftIn.size()];
            for (int i = 0; i < leftIn.size(); i++) {
                newPre[i] = pre[i + 1];
            }
            int[] newIn = new int[leftIn.size()];
            for (int i = 0; i < leftIn.size(); i++) {
                newIn[i] = in[i];
            }
            root.left = reConstructBinaryTree(newPre, newIn);
        }
        //尝试构建右子树
        ArrayList<Integer> rightIn = new ArrayList<>();
        for (int i = index + 1; i < in.length; i++) {
            rightIn.add(in[i]);
        }
        if (rightIn.size() > 0) {
            int[] newPre = new int[rightIn.size()];
            for (int i = 0; i < rightIn.size(); i++) {
                newPre[i] = pre[i + leftIn.size() + 1];
            }
            int[] newIn = new int[rightIn.size()];
            for (int i = 0; i < rightIn.size(); i++) {
                newIn[i] = in[i + index + 1];
            }
            root.right = reConstructBinaryTree(newPre, newIn);
        }
        return root;
    }

    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        System.out.println(solution.reConstructBinaryTree(
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{3, 2, 4, 1, 6, 5, 7}));
    }
}
