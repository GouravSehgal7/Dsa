import java.util.HashMap;

public class lrucache {

    public class Node {
        int key;
        int val;
        Node next ;
        Node prev;
        Node(int k , int v){
            this.key = k;
            this.val = v;
        }

        private final Node head;
        private final Node tail;
        private final int cap;
        private final HashMap<Integer,Node> hm;
        lrucache(int cap){
            this.cap = cap;
            this.hm = new HashMap<>();
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            this.next = tail;
            this.prev = head;
        }
    }


    public static void main(String[] args) {
        
    }
    
}
