package SwordMeansOffer;

import java.util.Stack;

/**
 * @author SuccessZhang
 * <p>
 * 原题：用两个栈来实现一个队列，完成队列的Push和Pop操作。队列中的元素为int类型。
 * <p>
 * 思路：两个栈，一个作为入队栈，一个作为出队栈。
 */
public class Solution5 {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Solution5 solution=new Solution5();
        solution.push(1);
        System.out.println(solution.pop());
        solution.push(2);
        solution.push(3);
        solution.push(4);
        System.out.println(solution.pop());
    }
}