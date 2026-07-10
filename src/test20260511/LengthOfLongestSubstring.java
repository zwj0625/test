package test20260511;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串 - 滑动窗口
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbc";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s){
        int result  = 0;
        int n = s.length();
        // 初始化左右指针 作为 滑动窗口
        int left = 0, right = 0;
        // 哈希集合 判断当前滑动窗口的子串有没有重复字符
        Set<Character> set = new HashSet<>();
        // 左指针 遍历 字符串 为准
        for (; left<n; left++){
            // 移动窗口右指针，进窗口的字符就加入集合（先前不包含的话）
            while(right<n && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            // 移动窗口左指针，出窗口的字符也要从集合里剔除
            set.remove(s.charAt(left));
            result = Math.max(result, right-left);
        }
        return result;
    }
}
