package SwordMeansOffer;

/**
 * @author SuccessZhang
 * <p>
 * 原题：请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * <p>
 * 思路：用StringBuilder依次遍历该字符串中的字符
 */
public class Solution2 {

    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            if (character == ' ') {
                sb.append("%20");
            } else {
                sb.append(character);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.replaceSpace(new StringBuffer("We Are Happy")));
    }
}