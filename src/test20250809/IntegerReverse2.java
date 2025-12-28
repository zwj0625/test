package test20250809;

import java.util.Arrays;

/**
 * 有符号整数反转问题的一个关键点：x=-2147483648
 */
public class IntegerReverse2 {
    public static void main(String[] args) {
        int a = -123;
        int b = 123;
//        int c = 1251;
//        int d = 1534236469;
        int e = -2147483648;
        System.out.println(reverse(a));
        System.out.println(reverse(b));
//        System.out.println(reverse(c));
//        System.out.println(reverse(d));
        System.out.println(reverse(e));
        char[] chars = new char[]{'a','b','c'};
        String str = new String(chars); // 将整个字符数组转为字符串
    }

    public static int reverse(int x){
        // 反转有符号整数的整数部分并返回
        // 记 rev 为翻转后的数字，为完成翻转，我们可以重复「弹出」x 的末尾数字，将其「推入」rev 的末尾，直至 x 为 0。要在没有辅助栈或数组的帮助下「弹出」和「推入」数字，我们可以使用除余的数学方法
        //作者：力扣官方题解
        //链接：https://leetcode.cn/problems/reverse-integer/solutions/755611/zheng-shu-fan-zhuan-by-leetcode-solution-bccn/
        //来源：力扣（LeetCode）
        if(x==0){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        if(x<0){
            sb.append("-");
        }
        long xLong = x;
        while(xLong!=0){
            xLong = Math.abs(xLong);
            sb.append(xLong%10);   // Math.abs(x)---当x=-2147483648会报错
            xLong = xLong / 10;
        }
        String string = sb.toString();
        long l = Long.parseLong(string);
        if(l<-Math.pow(2,31) || l>Math.pow(2,31)-1){
            return 0;
        }
        return (int)l;
    }
}
