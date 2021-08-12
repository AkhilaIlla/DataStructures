import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInorderAndPreorder{


    public static void main(String[] args) {
//        TreeNode3 treeNode3  = new TreeNode3(6);
//        treeNode3.left = new TreeNode3(2);
//        treeNode3.right = new TreeNode3(8);
        int prerorder[] = {6,2,0,4,3,5,8,7,9};
        int inorder[] = {0,2,3,4,5,6,7,8,9};
        TreeNode3 res = new Solution3().buildTree(prerorder, inorder);
        System.out.println(res);
    }
}



class TreeNode3 {
        int val;
        TreeNode3 left;
        TreeNode3 right;
        TreeNode3() {}
        TreeNode3(int val) { this.val = val; }
        TreeNode3(int val, TreeNode3 left, TreeNode3 right) {
          this.val = val;
          this.left = left;
          this.right = right;
    }
  }

class Solution3 {
    static Map<Integer, Integer> map = new HashMap();
    public TreeNode3 buildTree(int[] preorder, int[] inorder) {
        for(int i= 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, inorder);
    }
    static int lookup(int[] inorder, int val){
        for(int i=0; i< inorder.length; i++){
            if(inorder[i]==val) return i;
        }
        return -1;
    }


    static TreeNode3 buildTreeHelper(int[] preorder, int[] inorder){
        // if(left>right) return null;
        if(preorder.length==0 || inorder.length==0) return null;
        //root will always be the first element of preoder => create root using that
        TreeNode3 root = new TreeNode3(preorder[0]);
        //{0,2,3,4,5,6,7,8,9};
        int inorderRootIndex = lookup(inorder, root.val);
        // root.left=buildTreeHelper(preorder, left+1, left+inorderRootIndex);
        // root.right=buildTreeHelper(preorder, inorderRootIndex+1,  right);
        root.left = buildTreeHelper(Arrays.copyOfRange(preorder, 1, inorderRootIndex+1), Arrays.copyOfRange(inorder, 0, inorderRootIndex+1));
        root.right = buildTreeHelper(Arrays.copyOfRange(preorder, inorderRootIndex+1, preorder.length), (Arrays.copyOfRange(inorder, inorderRootIndex+1, inorder.length-1)));
        return root;
    }
}
