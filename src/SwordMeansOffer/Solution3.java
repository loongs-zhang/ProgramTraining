package SwordMeansOffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author SuccessZhang
 * <p>
 * 原题：输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * <p>
 * 思路：1、利用栈先进后出的特性；
 * 2、调转原有的ListNode，然后遍历。
 */
public class Solution3 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        if (listNode.next == null) {
            return new ArrayList<>(Collections.singletonList(listNode.val));
        }
        ListNode pre = null, mid = listNode, next;
        while (mid != null) {
            next = mid.next;
            mid.next = pre;
            pre = mid;
            mid = next;
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (pre != null) {
            result.add(pre.val);
            pre = pre.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(0);
        ListNode node1 = new ListNode(1);
        root.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        node4.next = new ListNode(5);
        Solution3 solution = new Solution3();
        System.out.println(solution.printListFromTailToHead(root));
    }
}