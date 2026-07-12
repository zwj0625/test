package test20260707;

import java.util.HashSet;
import java.util.Set;

/**
 * 相交链表 --- 找相交节点
 */
public class GetIntersectionNode {
    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        Set<ListNode> setA = new HashSet<>();
        ListNode curA = headA;
        while(curA!=null){
            setA.add(curA);
            curA = curA.next;
        }
        ListNode curB = headB;
        while(curB!=null){
            if(setA.contains(curB)){
                return curB;
            }
            curB = curB.next;
        }
        return null;
    }
}
class ListNode{
    // 属性
    int val;
    ListNode next;
    // 构造器
    ListNode(int num){
        this.val = num;
        this.next = null;
    }
    // set / get 方法
}
