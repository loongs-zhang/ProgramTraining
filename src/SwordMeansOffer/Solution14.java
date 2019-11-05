package SwordMeansOffer;

/**
 * @author SuccessZhang
 * <p>
 * 原题：输入一个链表，输出该链表中倒数第k个结点。
 * <p>
 * 思路：让一个指针先往后走k次，再让另一个指针和
 * 该指针一起往下走，直到先走的指针为空，后边的指
 * 针就是倒数第k个节点。
 */
public class Solution14 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode p = head;
        for (int i = 0; i < k; i++) {
            if (p == null) {
                return null;
            }
            p = p.next;
        }
        while (p != null) {
            head = head.next;
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(0);
        ListNode node1 = new ListNode(1);
        root.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        node3.next = new ListNode(4);
        Solution14 solution = new Solution14();
        System.out.println(solution.FindKthToTail(root, 5));
    }
}