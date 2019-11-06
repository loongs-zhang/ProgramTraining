package SwordMeansOffer;

/**
 * @author SuccessZhang
 * <p>
 * 原题：输入一个链表，反转链表后，输出新链表的表头。
 * <p>
 * 思路：三个指针，一前一中一后，
 * 先记录中的后，再把中的后指向前，
 * 将前指向中，将中指向后。
 */
public class Solution15 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, current = head, next = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
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
        Solution15 solution = new Solution15();
        System.out.println(solution.ReverseList(root));
    }
}