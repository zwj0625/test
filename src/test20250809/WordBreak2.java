package test20250809;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 * 动态规划
 */
public class WordBreak2 {
    public static void main(String[] args) {

    }
    public static boolean wordBreak(String s, List<String> wordDict){
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 1; i < n+1; i++) {  // 计算dp数组对应索引元素---dp[i]代表字目标符串s前i个字符组成的子串
            for (int j=0;j<i;j++){
                if(dp[j] && wordSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
