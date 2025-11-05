import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {


    public static class Node {
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }


    static int idx = -1;
    static int count = 0;
    public static Node BuildTree(int arr[]){
        idx++;
        if(arr[idx] == -1){
            return null;
        }
        Node root = new Node(arr[idx]);
        count++;
        root.left = BuildTree(arr);
        root.right = BuildTree(arr);
        return root;
    }
    

    // inorder -> left - root - right
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root);
        inorder(root.right);
    }
    // postorder -> left - right - root
    public static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root);
    }
    // preorder -> root - left - right
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    // levelorder traversal -> bfs
    public static void levelOrder(Node root){
        // initalize queue
        Queue<Node> q = new LinkedList<>();
        // check left and right together

            // add root to queue
            q.add(root);
            // extract one element from queue
            do{
            
            Node top = q.remove();
            // print them
            System.out.println(top.data);
            // check its left and right together and add it to queue
            
            if(top.left != null){
                q.add(top.left);
            }
            if(top.right != null){
                q.add(top.right);
            }
            // repeat untill null

            }while(!q.isEmpty());
    } 
    // height
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        int h = Math.max(left, right)+1;
        return h;
    }

    public static int Count(Node root){
        if(root == null){
            return 0;
        }
        int left =Count(root.left);
        int right = Count(root.right);
        return left+right+1;
    }
    
    static int sum = 0;

    public static int sum(Node root){
        if(root == null){
            return 0;
        }
        sum = sum+root.data;
        sum(root.left);
        sum(root.right);
        return sum;
    }

    public static boolean issame(Node p, Node q){
        if(p == null && q == null){
            return p == q;
        }
        boolean left = issame(p.left, q.left);
        boolean right = issame(p.right, q.right);
        return p.data == q.data && left && right;
    }

    public static boolean is_identical(Node root){
        // if(root == null){
        //     return false;
        // }
        Node left = root.left;
        Node right = root.right;
        boolean b = issame(left, right);
        return b;
    }

    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        // max height of left 
        int left = diameter(root.left);
        // height of right 
        int r = diameter(root.right);
        System.out.println(left);
        System.out.println(r);
        // sum of them
        return left+r;
    }

    public static boolean hasSubtree(Node t, Node subt){
        if(t == null && subt == null ) return t == subt;
        if(t.data == subt.data){
            boolean left = hasSubtree(t.left, subt.left);
            boolean right = hasSubtree(t.right, subt.right);
            return left && right ;
        }
        return hasSubtree(t.left, subt) || hasSubtree(t.right, subt);
    }
    
    
    public static void main(String[] args) {
        int arr[] = {1,2,-1,-1,3,4,-1,-1,5,-1,-1};
        Node root = BuildTree(arr);
        // System.out.println(root.data);
        // System.out.println(height(root));a
        // System.out.println(Count(root));
        // System.out.println(sum(root));
        // System.out.println(is_identical(root));
        System.out.println(diameter(root));
    }
}
