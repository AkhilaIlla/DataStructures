import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.right = new Node(7);
        Solution2 solution2 = new Solution2();
        solution2.connect(node);
//        node;

    }
}


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


class Solution2{
    public Node connect(Node root) {
        if(root==null) return null;
        if(root.left==null && root.right==null) return null;
        if(root.left!=null && root.right!=null) root.left.next = root.right;
        if(root.right!=null && root.next!=null && root.next.left!=null) root.right = root.next.left;
        if(root.right!=null && root.next!=null && root.next.left==null && root.next.right!=null){
            root.right = root.next.right;
            System.out.println(root.right.val +" "+ root.next.right.val);
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
