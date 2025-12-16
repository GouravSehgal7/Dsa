package java.heap;

public class heap {

    public class MaxHeap {
        
        int arr[];
        int size = 0;
        MaxHeap(int capacity){
            this.arr = new int[capacity+1];
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean IsOverFlow(){
            return this.size == this.arr.length - 1;
        }

        public void Insert(int e){
            this.size++;
            if(!IsOverFlow()){
                this.arr[size] = e;
            }
            return;
        }

        public void compare(int arr[] , int size){
            int parent = size/2;
            if(parent == 1 || arr[parent]>=arr[size]){
                return;
            }
                arr[size] = arr[size]^arr[parent];
                arr[parent]= arr[size]^arr[parent];
                arr[size]=arr[size]^arr[parent];
                compare(arr, parent);
        }

        public int Delete(){
            // swap first with last
            this.arr[1] = this.arr[1]^this.arr[this.size];
            this.arr[this.size] = this.arr[1]^this.arr[this.size];
            this.arr[1] = this.arr[1]^this.arr[this.size];
            int val = this.arr[this.size];
            this.size--;
            compare(this.arr, this.size);
            return val;
        }

        public void heapifycompare(int nums[],int parent){
            if(parent == 1){
                return;
            }
            int chield1 = parent*2;
            int chield2 = parent*2+1;
            int childmax = Math.max(nums[chield1], nums[chield2]);
            if(nums[parent]<childmax){
                int temp = childmax;
                childmax = nums[parent];
                nums[parent] = temp;
            }
            heapifycompare(nums, parent-1);
        }

        public void heapifyMaxHeap(int nums[]){
            // we will be given array with random numbers and we have to convert it to heap
            int parent = nums.length/2;
            heapifycompare(nums, parent);
            return;
        }

    }


    public static void main(String[] args) {
        
    }
    
}