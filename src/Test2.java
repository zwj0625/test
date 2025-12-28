import java.util.*;

public class Test2 {
    public static List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            List<String> tempList = map.getOrDefault(key,new ArrayList<>());
            tempList.add(str);
            map.put(key,tempList);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {

    }
}
