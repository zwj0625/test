import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        String pattern="abba";
        String s="dog cat cat dog";
    }
    public static boolean wordPattern(String pattern, String s) {
/*        String[] sArr = s.split(" ");
        //String[] patternArr = pattern.split("");
        if(sArr.length!=pattern.length()){
            return false;
        }
        Map<Character,String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if(!map.containsKey(pattern.charAt(i))){
                map.put(pattern.charAt(i),sArr[i]);
            }
            if(!map.get(pattern.charAt(i)).equals(sArr[i])){
                return false;
            }
        }
        return true;*/
        String[] sArr = s.split(" ");
        if (sArr.length != pattern.length()) {
            return false;
        }
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            String word = sArr[i];

            // 检查pattern中的字符是否已经映射到了另一个不同的单词
            if (charToWord.containsKey(p) && !charToWord.get(p).equals(word)) {
                return false;
            }
            // 检查s中的单词是否已经被映射到了另一个不同的字符
            if (wordToChar.containsKey(word) && !wordToChar.get(word).equals(p)) {
                return false;
            }

            // 建立映射关系
            charToWord.put(p, word);
            wordToChar.put(word, p);
        }
        return true;
    }
}
