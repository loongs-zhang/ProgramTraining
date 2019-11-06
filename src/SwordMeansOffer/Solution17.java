package SwordMeansOffer;

/**
 * @author SuccessZhang
 * <p>
 * 原题：输入两棵二叉树A，B，判断B是不是A的子结构。
 * (ps：我们约定空树不是任意一个树的子结构)
 * <p>
 * 思路：先尝试比较当前节点，如果当前节点匹配，往下
 * 匹配子节点，如果都匹配，返回true；
 * 当前节点不匹配，则尝试左子树或右子树匹配；
 */
public class Solution17 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return IsEqualTree(root1, root2) ||
                HasSubtree(root1.left, root2) ||
                HasSubtree(root1.right, root2);
    }

    private boolean IsEqualTree(TreeNode root1, TreeNode root2) {
        //root2遍历完，不管root1是否遍历完
        if (root2 == null) {
            return true;
        }
        //root2还没遍历完，root1已经遍历完
        if (root1 == null) {
            return false;
        }
        //两个节点不相等
        if (root1.val != root2.val) {
            return false;
        }
        //根节点匹配上，去子节点匹配
        return IsEqualTree(root1.left, root2.left) &&
                IsEqualTree(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        Solution17 solution = new Solution17();
        System.out.println(solution.HasSubtree(root, new TreeNode(1)));
    }
}