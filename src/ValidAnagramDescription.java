import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ValidAnagramDescription {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }

        Map<Character,Integer> mapS = new TreeMap<>();
        Map<Character,Integer> mapT = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(mapS.containsKey(s.charAt(i))){
                mapS.put(s.charAt(i),mapS.get(s.charAt(i))+1);
            }else{
                mapS.put(s.charAt(i),1);
            }

            if(mapT.containsKey(t.charAt(i))){
                mapT.put(t.charAt(i),mapT.get(t.charAt(i))+1);
            }else{
                mapT.put(t.charAt(i),1);
            }
        }
        //System.out.println(mapS.size());
        //System.out.println(mapS.toString());
        if(mapS.size()!=mapT.size()){
            return false;
        }
        if(mapS.equals(mapT)){
            return true;
        }else{
            return false;
        }
    }
}
