package SwordMeansOffer;

/**
 * @author SuccessZhang
 * <p>
 * 原题：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * <p>
 * 思路：head用来存放头节点，tail用来存放尾节点，中序遍历二叉树。
 */
public class Solution25 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    private TreeNode head;

    private TreeNode tail;

    public TreeNode Convert(TreeNode pRootOfTree) {
        intermediateTraversal(pRootOfTree);
        return head;
    }

    private void intermediateTraversal(TreeNode pRootOfTree) {
        if (pRootOfTree != null) {
            if (pRootOfTree.left != null) {
                intermediateTraversal(pRootOfTree.left);
            }
            if (head == null) {
                head = pRootOfTree;
                tail = pRootOfTree;
            } else {
                tail.right = pRootOfTree;
                pRootOfTree.left = tail;
                tail = pRootOfTree;
            }
            if (pRootOfTree.right != null) {
                intermediateTraversal(pRootOfTree.right);
            }
        }
    }

    public static void main(String[] args) {
        Solution25 solution = new Solution25();
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(6);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);
        right.left = new TreeNode(5);
        right.right = new TreeNode(7);
        System.out.println(solution.Convert(root));
    }
}