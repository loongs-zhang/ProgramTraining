package SwordMeansOffer;

/**
 * @author SuccessZhang
 * <p>
 * 原题：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * <p>
 * 思路：先判断是否真的搬运了若干个元素到数组的末尾，
 * 若真的搬运了，遍历数组，一旦找到array[i]>array[i+1]，
 * 直接返回array[i+1]；否则，说明搬运的若干个元素的个数为0
 * 或者恰好为array.length，此时直接返回array[0]
 */
public class Solution6 {

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        if (array[0] >= array[array.length - 1]) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] > array[i + 1]) {
                    return array[i + 1];
                }
            }
        }
        return array[0];
    }

    public static void main(String[] args) {
        Solution6 solution = new Solution6();
        System.out.println(solution.minNumberInRotateArray(new int[]{3, 4, 5, 1, 2}));
    }
}