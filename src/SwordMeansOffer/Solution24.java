package SwordMeansOffer;

import java.util.ArrayList;

/**
 * @author SuccessZhang
 * <p>
 * 原题：输入一颗二叉树的跟节点和一个整数，打印出
 * 二叉树中结点值的和为输入整数的所有路径。路径定
 * 义为从树的根结点开始往下一直到叶结点所经过的结
 * 点形成一条路径。(注意：在返回值的list中，数组
 * 长度大的数组靠前)
 * <p>
 * 思路：回溯思想，遍历时，比较当前路径的和和target的大小，
 * 如果当前路径节点和小于target，继续往下遍历；
 * 如果当前路径节点和大于target，回退。
 */
public class Solution24 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    private ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();

    private ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return pathList;
        }
        path.add(root.val);
        if (target == root.val && root.left == null && root.right == null) {
            pathList.add(new ArrayList<>(path));
        }
        if (root.val < target && root.left != null) {
            FindPath(root.left, target - root.val);
        }
        if (root.val < target && root.right != null) {
            FindPath(root.right, target - root.val);
        }
        //回退到父节点
        path.remove(path.size() - 1);
        return pathList;
    }

    public static void main(String[] args) {
        Solution24 solution = new Solution24();
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(6);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);
        right.left = new TreeNode(5);
        right.right = new TreeNode(7);
        for (ArrayList<Integer> list : solution.FindPath(root, 11)) {
            System.out.println(list);
        }
    }
}