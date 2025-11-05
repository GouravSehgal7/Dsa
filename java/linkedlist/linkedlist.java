public class linkedlist {

    class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class LKList {
        public Node Head;
        public int cnt;

        LKList(){
            this.Head = null;
            this.cnt = 0;
        }

        public boolean isEmty(){
            return this.Head == null;
        }

        public Node addfront(int data){
            Node nn = new Node(data);
            // if it is first then set head = nn and set head.next = null
            if(isEmty()){
                this.Head = nn;
            } else{
            // otherwise make head.next = null 
            nn.next = this.Head;
            this.Head = nn;
            }
            this.cnt++;
            return nn;
        }

        public Node addlast(int data){
            Node nn = new Node(data);
            if(isEmty()){
                this.Head = nn;
                return nn;
            }
            Node curr = this.Head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = nn;
            nn.next = null;
            this.cnt++;
            return nn;
        }

        public void addmid(int data,int pos){
            if(this.cnt>pos){
                return;
            }
            Node nn = new Node(data);
            Node curr = this.Head;
            Node curr2 = this.Head.next;
            int cnt = 1;
            while (cnt != pos-1 ) {
                curr=curr.next;
                curr2=curr2.next;
                cnt++;
            }
            curr.next = nn;
            nn.next = curr2;
            return;
        }

        public void deletefirst(){
            if(isEmty()){
                System.out.println("empty");
                return;
            }
            this.Head = this.Head.next;
            this.cnt++;
        }

        public void deletelast(){
            Node crr = Head;
            while (crr.next.next != null) {
                crr = crr.next;
            }
            crr.next = null;
            return;
        }

        public void deletemid(int pos){
            int count = 1;
            Node cur = Head;
            while (count <= pos-1) {
                cur = cur.next;
                count++;
            }
            cur = cur.next.next;
            return;
        }

    }

    class DNode{
        int data;
        DNode next;
        DNode prev;
        DNode(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    class DLL{
        private DNode Head;
        private int cnt;
        DLL(){
            this.Head = null;
            this.cnt = 0;
        }

        public boolean isEmty(){
            return this.Head.next == null;
        }

        public DNode addfront(int data){
            DNode nn = new DNode(data);
            if(isEmty()){
                this.Head = nn;
                return nn;
            }
            this.Head.prev = nn;
            nn.next = this.Head;
            this.Head = nn;
            return nn;
        }
    }

    class CLL{
        private Node Head;
        private Node Tail;
        CLL(){
            this.Head = null;
            this.Tail = null;
        }
    }
    



    public static void main(String[] args) {
        LKList ll = new LKList();
        ll.addfront(0);
        ll.addfront(1);
        ll.addfront(2);

    }
}