package test20251230;

import java.util.*;

public class groupAnagrams {
    public static void main(String[] args) {

    }

    public static List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            if(map.containsKey(s)){
                // 因为拿到的是原 List 的引用，所以调用 add(str) 会直接修改 Map 中已存在的 List，无需再调用 map.put()
                map.get(s).add(strs[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(s, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
