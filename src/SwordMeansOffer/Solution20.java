package SwordMeansOffer;

import java.util.Stack;

/**
 * @author SuccessZhang
 * <p>
 * 原题：定义栈的数据结构，请在该类型中实现一个能够得到栈
 * 中所含最小元素的min函数(时间复杂度应为O(1))。
 * <p>
 * 每次压栈操作时, 如果压栈元素比当前最小元素更小，就把这
 * 个元素压入最小元素栈，原本的最小元素就成了次小元素。同
 * 理, 弹栈时，如果弹出的元素和最小元素栈的栈顶元素相等，
 * 就把最小元素的栈顶弹出。
 */
public class Solution20 {

    private Stack<Integer> data = new Stack<>();

    private Stack<Integer> min = new Stack<>();

    public void push(int node) {
        data.push(node);
        if (min.isEmpty() || node <= min.peek()) {
            min.push(node);
        }
    }

    public void pop() {
        if (min.peek().equals(data.peek())) {
            min.pop();
        }
        data.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }

    public static void main(String[] args) {
        Solution20 solution = new Solution20();
        solution.push(3);
        System.out.print(solution.min() + " ");
        solution.push(4);
        System.out.print(solution.min() + " ");
        solution.push(2);
        System.out.print(solution.min() + " ");
        solution.push(3);
        System.out.print(solution.min() + " ");
        solution.pop();
        System.out.print(solution.min() + " ");
        solution.pop();
        System.out.print(solution.min() + " ");
        solution.pop();
        System.out.print(solution.min() + " ");
        solution.push(0);
        System.out.println(solution.min());
    }
}