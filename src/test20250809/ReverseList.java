package test20250809;

public class ReverseList {
    public static void main(String[] args) {
        ListNode n2 = new ListNode(3, null);
        ListNode n1 = new ListNode(2, n2);
        ListNode n0 = new ListNode(1, n1);
        ListNode res = reverseList(n0);
        while(res!=null){
            System.out.println(res.value);
            res = res.next;
        }
    }
    public static ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}

class ListNode{
    int value;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}
