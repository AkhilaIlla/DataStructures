import javax.sound.midi.Soundbank;
import java.util.LinkedList;
import java.util.Queue;

public class Stack {
    static Queue<Integer> q1 = new LinkedList<Integer>();
    static Queue<Integer> q2 = new LinkedList<Integer>();

    void pushCostly(int data){
        q2.add(data);
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        //swap queues
        Queue queue = q1;
        q1 = q2;
        q2= queue;
    }

    int popSimple(){
        if(q1.isEmpty()) return -1;
        return q1.remove();
    }


    void pushSimple(int data){
        q1.add(data);
    }

    int popCostly(){
        if(q1.isEmpty()) return -1;
        while(q1.size()>1){
            q2.add(q1.remove());
        }
        int peek = q1.remove();
        //swap queues
        Queue queue = q1;
        q1 = q2;
        q2= queue;
       return peek;
    }


    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.pushCostly(1);
        stack.pushCostly(2);
        stack.pushCostly(3);
        System.out.println(stack.popSimple());

        stack.pushSimple(40);
        stack.pushSimple(50);
        stack.pushSimple(60);
        System.out.println(stack.popCostly());
        System.out.println(stack.popCostly());
        System.out.println(stack.popCostly());
        System.out.println(stack.popCostly());
        System.out.println(stack.popSimple());

    }
}
