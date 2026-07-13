package test20260707;

import java.util.HashSet;
import java.util.Set;

/**
 *  环形链表 --- 判断链表是否有环
 */
public class HasCycle {
    public static void main(String[] args) {

    }

    public static boolean hasCycle(ListNode head){
        Set<ListNode> set = new HashSet<ListNode>();
        while(head!=null){
            if(set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
