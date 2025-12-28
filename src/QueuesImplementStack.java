import java.util.LinkedList;
import java.util.Queue;

public class QueuesImplementStack {

}

/*//可以实现，但超出时间限制
class MyStack{

    //成员变量
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    //构造器
    public MyStack(){
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    //成员方法
    public void push(int x){
        q2.add(x);
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        q1 = q2;
        q2.clear();
    }
    public int pop(){
        return q1.remove();
    }
    public int top(){
        return q1.element();
    }
    public boolean empty(){
        return q1.isEmpty();
    }
}*/

class MyStack{

    //成员变量
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    //构造器
    public MyStack(){
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    //成员方法
    public void push(int x){
        //如果把一个队列当作栈本体，另一个队列是工具类，那么在每次push后需要交换两个队列状态，这样可行但超出时间限制
        //这里是每次push不交换状态，两个队列轮流做栈和工具队列，选择当前为空的队列轮流push
        //（保证后入的在队首，模拟栈的栈顶，先出队或栈）
        //除了首次push每次push时队列状态都是一空一非空
        if(q2.isEmpty()){
            //如果当前q2为空，则push到q2（一定位于队首位置）
            q2.add(x);
            //依次将q1中存好的元素搬到q2至q1空
            while(!q1.isEmpty()){
                q2.add(q1.remove());
            }
        }else{
            //如果当前q1为空，则push到q1（一定位于队首位置）
            q1.add(x);
            //依次将q2中存好的元素搬到q1至q2空
            while(!q2.isEmpty()){
                q1.add(q2.remove());
            }
        }
    }
    public int pop(){
        //当前哪个队列不为空哪个队列就是栈，remove哪个
        return q1.isEmpty()? q2.remove() : q1.remove();
    }
    public int top(){
        return q1.isEmpty()? q2.element() : q1.element();
    }
    public boolean empty(){
        //两个都空栈才表示空
        return q1.isEmpty()&&q2.isEmpty();
    }
}