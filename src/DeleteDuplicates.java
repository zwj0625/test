import java.util.TreeSet;

public class DeleteDuplicates {
    public static void main(String[] args) {

    }

    public static ListNode deleteDuplicates(ListNode head){
        TreeSet<Integer> set = new TreeSet<>();
        ListNode index = head;
        ListNode last = head;
        while(index!=null){//遍历链表
            if(set.contains(index.val)){//集合中有需要删除
                last.next = index.next;//跨过（删除）当前结点
            }else{//集合中没有需要添加，指针后移
                set.add(index.val);
                last = index;//移动当前指针前先记录当前指针为前一个结点
            }
            index = index.next;//后移当前指针，继续遍历
        }
        return head;
    }
}
class ListNode{
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}