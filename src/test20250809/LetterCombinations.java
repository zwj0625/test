package test20250809;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 * 迭代+回溯
 */
public class LetterCombinations {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
    public static List<String> letterCombinations(String digits){
        // 索引代表按键的电话号码组合，对应元素代表该索引下的
        String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<>();
        if(digits.length()==0){
            return list;
        }
        int n = digits.length();
        int index = 0;
        StringBuilder path = new StringBuilder();
        dfs(list, digits, index, path, map);
        return list;
    }

    public static void dfs(List<String> list, String digits, int index, StringBuilder path, String[] map){
        int n = digits.length();
        if(index==n){
            String s = path.toString();
            list.add(s);
            return;
        }
        int number = digits.charAt(index)-'0';  // 字符转换成整数，也就是对应的map索引
        String char_choice = map[number];  // number=2->char_choice="abc"
        for (int i = 0; i < char_choice.length(); i++) {
            path.append(char_choice.charAt(i));
            dfs(list, digits, index+1, path, map);
            // 回溯
            path.deleteCharAt(index);
        }
    }

}
