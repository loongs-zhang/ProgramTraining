package SwordMeansOffer;

/**
 * @author SuccessZhang
 * <p>
 * 原题：在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从
 * 上到下递增的顺序排序。请完成一个函数，输入这样的一
 * 个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 思路：从左下角开始找，
 * 由于矩阵从左到右、从上到下都是增加的，
 * 如果比当前值比target大，往上找，即y--；
 * 如果比当前值比target小，往右找，即x++；
 */
public class Solution1 {

    public boolean Find(int target, int[][] array) {
        int x = 0, y = array.length - 1;
        while (x < array[0].length && y >= 0) {
            if (target < array[y][x]) {
                y--;
            } else if (target > array[y][x]) {
                x++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        int[] array1 = new int[]{1, 2, 8, 9};
        int[] array2 = new int[]{2, 4, 9, 12};
        int[] array3 = new int[]{4, 7, 10, 13};
        int[] array4 = new int[]{6, 8, 11, 15};
        matrix[0] = array1;
        matrix[1] = array2;
        matrix[2] = array3;
        matrix[3] = array4;
        Solution1 solution = new Solution1();
        System.out.println(solution.Find(10, matrix));
    }
}