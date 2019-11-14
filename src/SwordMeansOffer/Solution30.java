package SwordMeansOffer;

/**
 * @author SuccessZhang
 * <p>
 * 原题：求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数(从1到n中1出现的次数)。
 * <p>
 * 思路：可以分别计算该整数个位数中1出现的次数，十位数中1出现的次数，
 * 百位数中1出现的次数，这样一直到最高位，把所有位数1出现的次数相加
 * 即得最后1出现的次数。举个例子，如n=12345，计算百位数的1出现的次数，
 * 即xx1xx共出现了多少次。那么有与3>1，故百位数前面可以取[0,12]，
 * 百位数后面取的范围可以为[0,99]，则百位数1出现的次数为 13*100=1300次。
 */
public class Solution30 {

    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        //当前位
        int index = 1;
        int current, low, high;
        while (index <= n) {
            //高位数字
            high = n / (index * 10);
            //当前位数字
            current = (n / index) % 10;
            //低位数字
            low = n % index;
            if (current == 0) {
                //如果为0,出现1的次数由高位决定,等于高位*当前位数
                count = count + high * index;
            } else if (current == 1) {
                //如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
                count = count + high * index + low + 1;
            } else {
                //如果大于1,出现1的次数由高位决定,(高位+1)*当前位
                count = count + (high + 1) * index;
            }
            //位数前移一位
            index = index * 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution30 solution = new Solution30();
        System.out.println(solution.NumberOf1Between1AndN_Solution(12345));
    }
}