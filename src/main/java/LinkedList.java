import javax.xml.transform.Source;
import java.awt.image.Kernel;
import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;


public class LinkedList {
    static Node head;
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    void insertFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void insertAfter(int data, Node prevNode){
        if(prevNode==null){
            System.out.println("previous node is null, no insertion");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;

    }
    void insertAtTheEnd(int data){
        Node newNode = new Node(data);
        if(head==null) {
            head = newNode;
            return;
        }
        Node x = head;
        while(x.next!= null){
            x = x.next;
        }
        x.next = newNode;
    }

    void deleteNode(int data){
        if(head.data == data){
            head = head.next;
            return;
        }
        Node node = head;
        while(node.next!=null && node.next.data != data){
            node = node.next;
        }
        if(node.next==null) return;
        node.next = node.next.next;
    }
    //recursive function to delete LL node
    void deleteNodeHelper(Node node, int data){
        if(node.next!=null && node.next.data == data){
            node.next = node.next.next;
            return;
        }
        deleteNodeHelper(node.next, data);
    }
    void deleteNodeRecursion(int data){
        if(head.data == data){
            head = head.next;
            return;
        }
         deleteNodeHelper(head, data);
    }

    void deleteNodeAtPosition(int position){
        if(position==0){
            head = head.next; return;
        }
        //50->60->10->20->null
        Node temp=head;
        Node prev=null;
        //traverse LL till position-1 and keep track of previous element
        while(position>0){
            prev = temp;
            temp = temp.next;
            position--;
        }
        prev.next = temp.next;
    }

    void reverseLinkedList(){
        Node previous = null;
        Node current = head;
        Node next = null;

        while(current!=null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    Node reverseLinkedListRecursion(Node head){
        if(head==null || head.next==null) return head;
        Node reverseHead = reverseLinkedListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return reverseHead;
    }

    Node mergeSortedLinkedList(Node p, Node q){
        Node result = new Node(0);
        Node pointer = result;

        if(p==null) return q;
        if(q==null) return p;

        while(p!=null && q!=null){
            if(p.data<=q.data){
                result.next = p;
                p=p.next;
            }else{
                result.next = q;
                q=q.next;
            }
            result = result.next;
        }
        if(p==null) result.next=q;
        if(q==null) result.next=p;
        return pointer.next;
    }

    void parseList(Node start){
        //check if the node being passed is null
        //yes->end of the list
        if(start==null){
            System.out.print("null");
            return;
        }
        //else print out the element and loop around with next
        System.out.print(start.data+"->");
        parseList(start.next);
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(10);
        node1.next = new Node(20);
        node1.next.next = new Node(30);
        head = node1;
        linkedList.parseList(head);
        linkedList.insertFirst(50);
        System.out.println();
        linkedList.parseList(head);
        System.out.println();
        linkedList.insertAfter(60, head);
        linkedList.parseList(head);
        System.out.println();
        linkedList.insertAtTheEnd(40);
        linkedList.parseList(head);
        System.out.println();
        linkedList.deleteNode(30);
        linkedList.parseList(head);
        System.out.println();
        linkedList.deleteNodeRecursion(40);
        linkedList.parseList(head);
        System.out.println();
        linkedList.deleteNodeAtPosition(3);
        linkedList.parseList(head);
        System.out.println();
        linkedList.reverseLinkedList();
        linkedList.parseList(head);
        System.out.println();
        linkedList.parseList(linkedList.reverseLinkedListRecursion(head));

        Node p = new Node(5);
        p.next = new Node(10);
        p.next.next = new Node(15);
        Node q = new Node(2);
        q.next = new Node(3);
        q.next.next = new Node(20);
        System.out.println();
        linkedList.parseList(linkedList.mergeSortedLinkedList(p, q));

        java.util.LinkedList linkedList1 = new java.util.LinkedList();

        String s = "a good   example";
        String[] sttr= s.split("\\s+");
        System.out.println(sttr);
        StringBuilder sb = new StringBuilder();
        for(String str: sttr){
            if(!str.isEmpty()){
                sb.append(str+" ");
            }
        }
        System.out.println(sb.toString());
    }

}
