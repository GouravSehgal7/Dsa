package tree;

public class bst {

    public static class Node {
        int data;
        Node left;
        Node right;
        Node(int d){
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

    public static Node MakeBst(int d, Node root){
        if(root == null){
            root = new Node(d);
            return root;
        }
        if (d>root.data) {
            root.right = MakeBst(d, root.right);
        }else{
            root.left = MakeBst(d, root.left);
        }
        return root; 
    }

    public static Node InsertBst(Node root, int i){
        if(root == null){
            return new Node(i);
            
        }
        if(i<root.data){
            root.left = InsertBst(root.left, i);
        }else{
            root.right =  InsertBst(root.right, i);
        }
        return root;
    }



    public static void main(String[] args) {
        
        
    }
}
