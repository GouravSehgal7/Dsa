import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class que {

    // queue contain front and rear sometime
    // add from rear -> exit form front

    // Q with linkedlist
    static class node{
         int data;
         node next;
        node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class QLL {
    
        private static node front;
        private static node rear;
        static int size = 0;

        QLL(){
            front =null;
            rear = null;
        }


        public static boolean isEmpty(){
            return front == null && rear == null;
        }

        public void Enque(int d){
            node nn = new node(d);
            if(!isEmpty()){
                rear.next = nn;
                rear = nn;
            }else{
                front = nn;
                rear = nn;
            }
            size++;
        }

        public  void Deque(){
            if(isEmpty()) {
                System.out.println(-1);
                return;
            }
            int d = front.data;
            if(front == rear){
                front = null;
                rear = null;
            }else{
            node temp = front;
            front = front.next;
            temp.next = null;
            temp = null;
            }
            size--;
            System.out.println(d);
        }

        public  void size(){
             System.out.println(size);
        }

        public  void front(){
            System.out.println(front.data);
        }
        
        
    }
    // Q with arraylist


    // Deck or Deque or double ended queue
    public static void DeQue(){
        Deque<Integer> dq = new ArrayDeque<>();

        dq.offerFirst(10); // [10]
        dq.offerLast(20);  // [10, 20]
        dq.offerFirst(5);  // [5, 10, 20]

        System.out.println(dq.peekFirst()); // 5
        System.out.println(dq.peekLast());  // 20

        System.out.println(dq.pollFirst()); // 5
        System.out.println(dq.pollLast());  // 20
        System.out.println(dq.pollFirst()); // 10
    }

    // collection
    public static void setQ(){
        Queue<Integer> pq = new LinkedList<>();

        pq.offer(30);
        pq.offer(10);
        pq.offer(20);

        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    // circuler 
    public static class CirculerQ {
        int size;
        int front;
        int back;
        int count;
        int arr[];
        CirculerQ(int size){
            this.size =size;
            this.arr = new int[size];
            this.front=0;
            this.back = -1;
            this.count = 0;
        }

        public boolean isFull(){
            return this.count == this.size;
        }
        
        public boolean isEmpty(){
            return this.count == 0;
        }

        public void push(int data){
            // if 
            if(isFull()){
                System.out.println("No extra space");
                return;
            }
            this.back = (this.back+1)%this.size;
            this.arr[this.back] = data;
            this.count++;
        }
        
        public void pop(){
            if(isEmpty()){
                System.out.println("nothing to pop");
                return;
            }
            this.front = (this.front+1)%this.size;
            this.count--;
        }

        public void peek() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            System.out.println(this.arr[this.front]);
            return ;
        }

        public void Stack(){
            
        }

    }
 
    public static void main(String[] args) {
        
        QLL q = new QLL();
        // q.Enque(0);
        // q.Enque(1);
        // q.Enque(2);
        // q.Enque(3);
        // q.Enque(4);
        // q.size();
        // q.Deque();
        // q.front();
        // q.Deque();
        // q.Deque();

        // setQ();
        // DeQue();

        CirculerQ c = new CirculerQ(5);
        c.push(0);
        c.push(1);
        c.push(2);
        c.push(5);
         c.push(0);
        c.push(1);
        c.push(2);
        c.push(5);
    }
}