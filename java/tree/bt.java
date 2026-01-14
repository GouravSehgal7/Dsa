package tree;
import java.util.LinkedList;
import java.util.Queue;
public class bt {

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

    public static int i = 0;
    public static Node Buildtree(int arr[]){
        if(i == arr.length){
            return null;
        }
        if(arr[i] == -1) {
            i++;
            return null;
        }
        Node n = new Node(arr[i]);
        i++;
        n.left = Buildtree(arr);
        n.right = Buildtree(arr);
        return n;
    }

    public static void inorder(Node root){
        // left root right
        if(root == null) return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static void preorder(Node root){
        // left root right
        if(root == null) return;
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(Node root){
        // left root right
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    public static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node n = q.poll();
            System.out.println(n.data);
            if(n.left != null){
                q.add(n.left);
            }
            if (n.right!=null) {
                q.add(n.right);
            }
        }
        return;
    }

    public static int hight(Node root){
        if (root == null) {
            return 0;
        }
        // max level in left or right
        int left = hight(root.left);
        int right = hight(root.right);
        // System.out.println( Math.max(left, right));
        return Math.max(left, right)+1;
    }

    public static int maxnode(Node root){
        if (root == null) {
            return 0;
        }
        return Math.max(root.data, Math.max(maxnode(root.left),maxnode(root.right))) ;
    }

    public static int count(Node root){
        if(root == null) return 0;
        int left = count(root.left);
        int right = count(root.right);
        return left+right+1;
    }

    public static int sum(Node root){
        if(root == null){
            return 0;
        }
        return root.data + sum(root.left) + sum(root.right);
    }

    static int cnt = 0;
    public static int cntleaf(Node root){
        if(root == null){
            return 0;
        }
        cntleaf(root.left);
        if(root.left == null && root.right == null) cnt++;
        cntleaf(root.right);
        return cnt;
    }

    public static int diameter(Node root){
        // diameter can be from either form left or right or pass from root
        if(root == null) return 0;
        int leftdia = diameter(root.left);
        int rightdia = diameter(root.right);
        int combo = hight(root);
        int val = Math.max(rightdia, Math.max(leftdia, combo));
        return val;
    }

    public static class diametermeasure {
        int height ;
        int diameter ;
        diametermeasure(int h, int d){
            this.height = h;
            this.diameter = d;
        }
    }

    public static diametermeasure diameter2(Node root){
        if(root == null) return new diametermeasure(0, 0);
        diametermeasure l = diameter2(root.left);
        diametermeasure r = diameter2(root.right);
        int h = Math.max(l.height, r.height)+1;
        int d1 = l.diameter;
        int d2 = r.diameter;
        int d3 = l.height+r.height+1;
        int mydia = Math.max(d2, Math.max(d1, d3));
        diametermeasure myinfo = new diametermeasure(h, mydia);
        return myinfo;
    }
    
    public static boolean isbalanced(Node root,Node parent){
        if(root == null) return true;
        if(Math.abs(root.data - parent.data)<=1) {
            parent = root;
        }else{
            return false;
        }
        boolean left = isbalanced(root.left, parent);
        boolean right = isbalanced(root.right, parent);
        return left && right;
    }

    // public static boolean isbalancedheight(Node root){
    //     if (root == null) {
    //         return true;
    //     }
    //     boolean left = isbalancedheight(root.left);
    //     boolean right = isbalancedheight(root.right);
    // }

    public static boolean isidentical(Node r1,Node r2){
        if(r1 == null && r2 == null){
            return true;
        }
        if(r1.data != r2.data){
            return false;
        }
        return r1.data == r2.data && isidentical(r1.left, r2.left) && isidentical(r1.right, r2.right);
    }
    
    static int nodesum = 0;
    static int leafsum = 0;
    public static boolean leaftreeroot(Node root){
        if(root == null){
            return true;
        }
        if (root.left == null && root.right == null) {
            leafsum+=root.data;
        }else{
            nodesum+=root.data;
        }
        leaftreeroot(root.left);
        leaftreeroot(root.right);
        return nodesum == leafsum ;
    }
    
    public static class Sumclass {
        int nodesum;
        int leafsum;
        Sumclass(int l , int n){
            this.leafsum = n;
            this.nodesum = n;
        }  
    }

    public static Sumclass leafsum(Node root){
        Sumclass s = new Sumclass(0, 0);
        if (root == null) {
            return s;
        }
        if(root.left == null && root.right == null){
            s.leafsum+=root.data;
        }else{
            s.nodesum+=root.data;
        }
        Sumclass l =  leafsum(root.left);
        Sumclass r = leafsum(root.right);
        s.leafsum += l.leafsum+r.leafsum;
        s.nodesum += l.nodesum+ r.nodesum;
        return s;
    }

    public static class Sum {
        int leftsum;
        int rightsum;
        Sum(int ls,int rs){
            this.leftsum = ls;
            this.rightsum = rs;
        }
    }

    public static void zigzag(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        boolean iseven = false;
        while (!q.isEmpty()) {
            Node n = q.poll();
            if(n != null){
                System.out.println(n.data);
                if(iseven){
                    if(n.left != null){
                        q.add(n.left);
                    }
                    if (n.right!=null) {
                        q.add(n.right);
                    }
                }else{
                    if(n.right != null){
                        q.add(n.right);
                    }
                    if (n.left!=null) {
                        q.add(n.left);
                    }
                }
            }else{
                iseven = !iseven;
                if (!q.isEmpty()) {
                    q.add(null);
                }
            }
            
        }
        return;
    }


    public static void left(Node root){
        while (root.left.left!= null) {
            System.out.println(root.data);
        }
    }
    public static void right(Node root){
        if (root.right == null) {
            return;
        }
        right(root.right);
        System.out.println(root.data);
    }
    public static void leaf(Node root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            System.out.println(root.data);
        }
        leaf(root.left);
        leaf(root.right);
    }
    
    public static class sumpath {
        int sum;
        int height;
        sumpath(int sum,int hight){
            this.sum = sum;
            this.height = hight;
        }
    }
    public static sumpath sumlongestpath(Node root){
        if(root == null) return new sumpath(0,0);
        sumpath left = sumlongestpath(root.left);
        sumpath right = sumlongestpath(root.right);
        
        if(left.height>right.height){
            int h = left.height+1;
            int s = left.sum+root.data;
            return new sumpath(s, h);
        }
        return new sumpath(right.sum+root.data, right.height+1);
    }

    public static Node LCA(Node root,int n1 , int n2){
        if(root == null) return null;
        if(root.data == n1 || root.data == n2){
            return root;
        }
        Node l = LCA(root.left, n1, n2);
        Node r = LCA(root.right, n1, n2);
        if(l != null && r != null){
            return root;
        }else if (l!=null && r==null){
            return l;
        }else if (r !=null && l==null){
            return r;
        }else{
            return null;
        }
    }

    public static Node KthCA(Node root,Node r, int k ){
        if(root == null) return null;
        if(k == 0) return root;
        Node lef = KthCA(root.left,r,k);
        Node rig = KthCA(root.right,r,k);
        if (root == r) {
            return r;
        }
        if(lef != null && rig != null){
            k--;
            return root;
        }else if(lef != null && rig == null){
            k--;
            return lef;
        }else if(rig != null && lef == null){
            k--;
            return rig;
        }else return null;
    }

    public static void BTtoLL(Node root){
        if(root == null){
            return ;
        }
        BTtoLL(root.right);
        BTtoLL(root.left);
        root.left = null;
        
    }




    public static void main(String[] args) {
        int arr[] = {3,2,-1,-1,2,3,-1,-1,1,-1,-1};
        Node r = Buildtree(arr);
        // System.out.println(r.data);
        // postorder(r);
        // levelOrder(r);
        zigzag(r);
        // System.out.println(maxnode(r));
        

    }
    
}
