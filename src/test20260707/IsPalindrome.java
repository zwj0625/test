package test20260707;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {
    public static void main(String[] args) {

    }

    public static boolean isPalindrome(ListNode head){
        StringBuilder str = new StringBuilder();
        while(head!=null){
            str.append(head.val);
            head = head.next;
        }
        String s1 = str.toString();
        String s2 = str.reverse().toString();
        if(s1.equals(s2)){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isPalindrome1(ListNode head){
        if(head==null || head.next==null){
            return true;
        }
        List<Integer> list = new ArrayList<Integer>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = list.size()-1;
        while(left<right){
            if(list.get(left).equals(list.get(right))){
                left++;
                right--;
            }else{
                break;
            }
        }
        return left >= right;
    }
}
