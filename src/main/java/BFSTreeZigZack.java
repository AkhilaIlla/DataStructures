import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BFSTreeZigZack {
    public static void main(String[] args) {
        TreeNode1 treeNode = new TreeNode1(3);
        treeNode.left = new TreeNode1(9);
        treeNode.right = new TreeNode1(20);
        treeNode.right.left = new TreeNode1(15);
        treeNode.right.right = new TreeNode1(7);

        Solution1 solution = new Solution1();
        solution.zigzagLevelOrder(treeNode);
    }
}

//Definition for a binary tree node.
class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1() {
    }

    TreeNode1(int val) {
        this.val = val;
    }

    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution1 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode1 root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root == null) return result;

        Stack<TreeNode1> s1 = new Stack();
        Stack<TreeNode1> s2 = new Stack();
        s1.push(root);

        List<Integer> subList = new ArrayList<>();

        while(!s1.isEmpty()){

            //System.out.print(s1.size()+" ");
            while(!s1.isEmpty()){
                root = s1.pop();
                // System.out.print(root.val+" ");

                subList.add(root.val);
                System.out.print(subList+" ");
                if(root.left!=null) s2.push(root.left);
                if(root.right!=null) s2.push(root.right);
            }

            result.add(subList);
            System.out.println(result);
            // subList.removeAll(subList);
            subList = new ArrayList<>();
            while(!s2.isEmpty()){
                root = s2.pop();
                subList.add(root.val);
                System.out.print(subList+" ");
                if(root.right!=null) s1.push(root.right);
                if(root.left!=null) s1.push(root.left);
            }
            if(!subList.isEmpty()){
                result.add(subList);
                System.out.println(result);
                subList.removeAll(subList);
            }

        }
        return result;

    }
}
