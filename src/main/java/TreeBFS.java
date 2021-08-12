import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class TreeBFS {
    public static void main(String[] args) {
        TreeNode1 treeNode = new TreeNode1(1);
        treeNode.left = new TreeNode1(2);
        treeNode.right = new TreeNode1(3);
        treeNode.left.left = new TreeNode1(4);
        treeNode.right.right = new TreeNode1(5);

        Solution solution = new Solution();
        solution.levelOrder(treeNode);
    }
}


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution {
    public List<List<Integer>> levelOrder(TreeNode1 root) {
        //keep track of the bfs order
        Queue<TreeNode1> queue = new LinkedList<>();
        //to store level wise lists
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<TreeNode1> sublist = new ArrayList();

        if(root!=null){
            result.add(new ArrayList(Arrays.asList(root.val)));
            queue.add(root);
        }

        while(queue.size()>0 || sublist.size()>0){
            if(queue.size()==0){
                //get values from sublist & add to result
                List<Integer> vals = sublist.stream().map(node -> node.val).collect(Collectors.toList());
                result.add(vals);
                //add nodes to queue
                sublist.stream().forEach(node-> {
                    queue.add(node);
                });
                sublist.removeAll(sublist);
            }
            root = queue.poll();

            if(root.left!=null){
                sublist.add(root.left);
                // sublist.add(root.left);
            }
            if(root.right!=null){
                // levelRes.add(root.right.val);
                sublist.add(root.right);
            }
            // if(!levelRes.isEmpty()) result.add(levelRes);
        }
        return result;
    }

}
