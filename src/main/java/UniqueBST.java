import java.util.ArrayList;
import java.util.List;

public class UniqueBST {

    static class Tree {
        int val;
        Tree left;
        Tree right;

        Tree() {
        }

        Tree(int val) {
            this.val = val;
        }

        Tree(int val, Tree left, Tree right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Tree> generateTrees(int n) {
        return helper(1, n);
    }

    List<Tree> helper(int l, int h){
        List<Tree> nodes = new ArrayList<>();
        if(l>h){
            nodes.add(null);
            return nodes;
        }

        for(int i=l; i<=h ;i++){

            List<Tree> left_trees = helper(l, i-1);
            List<Tree> right_trees = helper(i+1, h);

            for(Tree left: left_trees){
                for(Tree right: right_trees){
                    Tree root = new Tree(i);
                    root.left = left;
                    root.right = right;
                    System.out.println(root.val +" " +root.left + " "+ root.right);
                    nodes.add(root);
                }
            }
        }
        return nodes;
    }

    public static void main(String[] args) {
       UniqueBST uniqueBST = new UniqueBST();
       uniqueBST.generateTrees(3);
       char character[] = new char[26];
        System.out.println(character[0]);
    }

}
