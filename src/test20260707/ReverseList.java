package test20260707;

import java.awt.*;
import java.util.Stack;

/**
 * 反转链表 --- ①最简单想法 用一个栈 ②迭代 ③递归
 */
public class ReverseList {
    public static void main(String[] args) {

    }
    public static ListNode reverseList(ListNode head){
        // 处理空链表
        if(head == null) return null;
        Stack<ListNode> list = new Stack<>();
        ListNode cur = head;
        while (cur!=null){
            list.push(cur);
            cur = cur.next;
        }
        ListNode res = list.pop();
        ListNode dummy = res;
        while (!list.empty()){
            res.next = list.pop();
            res = res.next;
        }
        // 关键：末尾节点next置空，切断循环
        res.next = null;
        return dummy;
    }
    public static ListNode reverseList1(ListNode head){
        if(head==null){
            return null;
        }else if(head.next==null){
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
