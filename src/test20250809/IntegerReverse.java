package test20250809;

import java.util.Arrays;

public class IntegerReverse {
    public static void main(String[] args) {
//        int a = -123;
//        int b = 123;
//        int c = 1251;
//        int d = 1534236469;
        int e = -2147483648;
//        System.out.println(reverse(a));
//        System.out.println(reverse(b));
//        System.out.println(reverse(c));
//        System.out.println(reverse(d));
        System.out.println(reverse(e));
    }

    public static int reverse(int x){
        // 反转有符号整数的整数部分并返回
        long xLong = x;  // 针对x=-2147483648本身符合int，但-x会超过int范围
        long y;
        if(x>=0){
            y = reversePositive(xLong);
            if(y<(-(int)Math.pow(2,31)) || y>(int)Math.pow(2,31)-1){
                return 0;
            }
            return (int)y;
        }else{
            y = -reversePositive(-xLong);
            if(y<(-(int)Math.pow(2,31)) || y>(int)Math.pow(2,31)-1){
                return 0;
            }
            return (int)y;
        }
    }

    // 反转无符号整数
    public static long reversePositive(long x){
        String s = x+"";
        int length = s.length();
        char[] chars = s.toCharArray();
        char temp;
        for(int i=0;i<length/2;i++){
            temp = chars[i];
            chars[i] = chars[length-1-i];
            chars[length-1-i] = temp;
        }
        String reversedStr = new String(chars);
        long out = Long.parseLong(reversedStr);
        return out;
    }
}
