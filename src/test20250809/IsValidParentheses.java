package test20250809;

import java.util.Stack;

/**
 * 有效的括号
 * 涉及括号匹配明显是用 后进先出的 栈
 */
public class IsValidParentheses {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s){
        // 转变为字符数组
        char[] chars = s.toCharArray();
        // 初始化 栈
        Stack<Character> stack = new Stack<>();
        // 先匹配当前字符尝试能不能取出来，再放进去暂时没有匹配上的字符---一边取，一边放
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(!stack.isEmpty() && ((stack.peek().equals('(')&&c==')') || (stack.peek().equals('[')&&c==']') || (stack.peek().equals('{')&&c=='}') )){
                stack.pop();
            }else{
                stack.push(chars[i]);
            }
        }
        // 只需判断 栈 是否为空
        return stack.isEmpty();
    }
}
