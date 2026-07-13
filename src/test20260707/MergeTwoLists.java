package test20260707;

/**
 * 合并有序链表
 */
public class MergeTwoLists {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode dummy = new ListNode(-1); // 虚拟头结点
        ListNode res = dummy;
        while(cur1!=null && cur2!=null){
            if(cur1.val<cur2.val){
                res.next = cur1;
                cur1 = cur1.next;
            }else{
                res.next = cur2;
                cur2 = cur2.next;
            }
            res = res.next;
        }
        // 别忘记还有剩余链表
        if(cur1!=null){
            res.next = cur1;
        }else{
            res.next = cur2;
        }
        return dummy.next;
    }
}
