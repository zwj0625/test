package test20250809;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 * 递归+记忆化搜索
 */
public class WordBreak {
    public static void main(String[] args) {

    }
    public static boolean wordBreak(String s, List<String> wordDict){
        Set<String> wordDictSet = new HashSet(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 1; i < n+1; i++) {
            for (int j=0;j<i;j++){
                if (dp[j] && wordDictSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
