import javax.xml.crypto.Data;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Queue {
    static Stack<Integer> s1 = new Stack();
    static Stack<Integer> s2 = new Stack();

    Set<Set<Integer>> s = new HashSet<>();

    void enqueue(int data){
        s1.push(data);
    }

    int dequeue(){
     if(s2.isEmpty()){
         if(s1.isEmpty()){
             System.out.println("Queue is empty!");
             return -1;
         }
            while(s1.size()!=1){
                s2.push(s1.pop());
            }
            return s1.pop();
        }else{
            return s2.pop();
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(5);

    }

}
