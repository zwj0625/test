package test20250809;

/**
 * 有符号整数反转问题的一个关键点：x=-2147483648
 */
public class IntegerReverse3 {
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
        int rev = 0;  // 记录反转后的数
        int temp = 0;
        while(x!=0){
            if(rev < Integer.MIN_VALUE/10 || rev>Integer.MAX_VALUE/10){
                return 0;
            }
            temp = x % 10;
            x = x / 10;
            rev = rev * 10 + temp;
        }
        return rev;
    }
}
