package SwordMeansOffer;

/**
 * @author SuccessZhang
 * <p>
 * 原题：操作给定的二叉树，将其变换为源二叉树的镜像。
 * <p>
 * 思路：前序遍历，遍历时先交换左右子树，
 * 再往下遍历左右子树的左右子树。
 */
public class Solution18 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        Solution18 solution=new Solution18();
        solution.Mirror(root);
        System.out.println(root);
    }
}