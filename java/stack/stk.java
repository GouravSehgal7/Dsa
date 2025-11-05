import java.util.Stack;
import java.util.ArrayList;

public class stk {

    public static class STK {
        ArrayList<Integer> ar = new ArrayList<>();

        public void push(int val){
            ar.add(val);
        }
        
        public void pop(){
            if (!ar.isEmpty()) {
                ar.remove(ar.size()-1);
            }
        }

        public int top(){
            if (!ar.isEmpty()) {
                return ar.get(ar.size()-1);
            }
            throw new RuntimeException("Stack is empty");
        }

        public boolean isempty(){
            return ar.size() == 0;
        }
    }

    public static int[] GetNextGreater(int nums[]){
       Stack<Integer> st = new Stack<>();
       int arr[] = new int[nums.length];
       int i = nums.length-1;
       while (i>=0){
        if(st.empty()){
            arr[i] = -1;
            st.push(nums[i]);
            i--;
        }else if(!st.empty() && st.peek()>nums[i]){
            arr[i] = st.peek();
            st.push(nums[i]);
            i--;
        }else if(!st.empty() && st.peek()<=nums[i]){
            st.pop();
        }
       }
       return arr;
    }

    public static void reversebyk(Stack<Integer> s, int top){
        if(s.isEmpty()){
            // s.push(top);
            return;
        }
        top = s.pop();
        reversebyk(s,top);
        if(!s.isEmpty()){
            int temp = s.pop();
            System.out.println("top"+top);
            System.out.println("temp"+temp);
            s.push(top);
            s.push(temp);
        }else{
            s.push(top);
        }
        
    }

    

    public static void main(String[] args) {
        int num[] = {4,12,5,3,1,2,5,1,6};
        int arr[] = GetNextGreater(num);
        for(int n : arr){
            System.out.print(n+" ");
        }

        // while(k>0){
        //     reversebyk(s,0);
        //     k--;
        // }
        
        // while(!s.isEmpty()){
        //     System.out.println(s.pop());
        // }
    }


    
}