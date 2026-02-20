package test20251230;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到字符串 s 中所有字母异位词 p --- 滑动窗口 题型
 * 返回这些子串的起始索引
 */
public class FindAnagrams {
    public static void main(String[] args) {

    }

    public static List<Integer> findAnagrams(String s, String p){
        // 字符串长度
        int sLength = s.length();
        int pLength = p.length();
        // 如果要匹配的子串p长度比原字符串s还长，返回空列表
        if(sLength < pLength){
            return new ArrayList<>();
        }
        // 初始化结果集+两个数组记录p和滑动窗口k的26字母列表数量
        List<Integer> res = new ArrayList<>();
        int[] pArray = new int[26];
        int[] kArray = new int[26];
        // 统计p的26字母列表，遍历字符串p
        for (char c : p.toCharArray()) {
            pArray[c-'a']++;
        }
        // 开始滑动
        for (int right = 0; right < sLength; right++) {
            // 右端点字母计数
            char cRight = s.charAt(right);
            kArray[cRight-'a']++;
            // 长度不够就跳过，等待符合长度条件的窗口
            int left = right - pLength + 1;
            if(left < 0){
                continue;
            }
            // 当前滑动窗口k为[left, ..., right]
            // 每次都是右端点添加，左端点移除
            // 比较pArray和kArray数组是否一致，即每种字母出现次数是相同的
            if(Arrays.equals(pArray,kArray)){
                res.add(left); // 左端点的索引为所求
            }
            // 左端点移除
            char cLeft = s.charAt(left);
            kArray[cLeft-'a']--;
        }
        return res;
    }

}
