package SwordMeansOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author SuccessZhang
 * <p>
 * 原题：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * <p>
 * 思路：用direction来判断方向，xMin表示x轴最小值，
 * xMax表示x轴最大值，y轴类似；
 * 方向从左向右时，y轴最小值加1；
 * 方向从上向下时，x轴最大值减1；
 * 方向从右向左时，y轴最大值减1；
 * 方向从下向上时，x轴最小值加1；
 */
public class Solution19 {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int direction = 0;
        int xMin = 0, xMax = matrix[0].length;
        int yMin = 0, yMax = matrix.length;
        int x = 0, y = 0;
        int count = xMax * yMax;
        result.add(matrix[0][0]);
        while (result.size() < count) {
            switch (direction++ % 4) {
                case 0:
                    for (x = x + 1; x < xMax; x++) {
                        result.add(matrix[y][x]);
                    }
                    yMin++;
                    x--;
                    break;
                case 1:
                    for (y = y + 1; y < yMax; y++) {
                        result.add(matrix[y][x]);
                    }
                    xMax--;
                    y--;
                    break;
                case 2:
                    for (x = x - 1; x >= xMin; x--) {
                        result.add(matrix[y][x]);
                    }
                    yMax--;
                    x++;
                    break;
                case 3:
                    for (y = y - 1; y >= yMin; y--) {
                        result.add(matrix[y][x]);
                    }
                    xMin++;
                    y++;
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution19 solution = new Solution19();
        int[][] matrix = new int[5][1];
        int start = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = start++;
            }
        }
        for (int[] array : matrix) {
            System.out.println(Arrays.toString(array));
        }
        System.out.println(solution.printMatrix(matrix));
    }
}