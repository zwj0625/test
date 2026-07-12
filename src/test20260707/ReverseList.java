package test20260707;

import java.util.Stack;

/**
 * 反转链表
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
}
