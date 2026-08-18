import java.util.ArrayList;

public class miscproblem {
    /**
     * Node
     */
    public class Node {
        int val;
        Node left;
        Node right;
        Node(int n){
            this.val = n;
            this.left = null;
            this.right = null;
        }
        
    }

    // given a tree find height  each node and return sum exluded leaf node
    public static int HeightEachNode(Node root, ArrayList<Integer> res){
        if(root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        int l = HeightEachNode(root.left, res);
        int r = HeightEachNode(root.right, res);
        int ans = Math.max(l, r)+1;
        res.add(ans);
        return ans;
    }
    

    public static void main(String[] args) {
        
    }
}
