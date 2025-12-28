import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        int n = strs.length;
        boolean[] isUsed = new boolean[n];
        for (int i = 0; i < n-1; i++) {
            if(isUsed[i]){
                continue;
            }
            isUsed[i] = true;
            List<String> tempList = new ArrayList<>();
            tempList.add(strs[i]);
            for (int j = i+1; j < n; j++) {
                if(isDictSame(strs[i],strs[j])){
                    isUsed[j] =true;
                    tempList.add(strs[j]);
                }
            }
            result.add(tempList);
        }

        //最后判断一下字符串数组尾元素
        if(!isUsed[n-1]){
            List<String> lastList = new ArrayList<>();
            lastList.add(strs[n-1]);
            result.add(lastList);
        }
        return result;
    }

    public static boolean isDictSame(String a,String b) {
        if(a.length()!=b.length()){
            return false;
        }
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        Arrays.sort(aArr);
        Arrays.sort(bArr);
        String aa = Arrays.toString(aArr);
        String bb = Arrays.toString(bArr);
        if(aa.equals(bb)){
            return true;
        }else{
            return false;
        }
    }

        public static void main(String[] args) {
        System.out.println(isDictSame("ddddddddddg","dgggggggggg"));

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
