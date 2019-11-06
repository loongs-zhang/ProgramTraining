package SwordMeansOffer;

/**
 * @author SuccessZhang
 * <p>
 * 原题：输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 * <p>
 * 思路：四个指针，一个用来遍历list1，一个用来遍历list2，
 * 一个用于记录合成后的链表头，一个用于记录新链表的最后一
 * 个节点。需要注意一边list已经遍历完成而另一边仍有剩余的
 * 情况。
 */
public class Solution16 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                p = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                p = list2;
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            p.next = list1;
            p = list1;
            list1 = list1.next;
        }
        while (list2 != null) {
            p.next = list2;
            p = list2;
            list2 = list2.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode root1 = new ListNode(0);
        ListNode node1 = new ListNode(2);
        root1.next = node1;
        node1.next = new ListNode(4);

        ListNode root2 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        root2.next = node2;
        node2.next = new ListNode(5);

        Solution16 solution = new Solution16();
        System.out.println(solution.Merge(root1, root2));
    }
}