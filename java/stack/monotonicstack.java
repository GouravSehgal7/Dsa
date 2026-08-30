import java.util.HashMap;
import java.util.Stack;

public class monotonicstack {
    // “For this element, what is the first element to the 
    // left/right that is greater/smaller?”

    // You want to find	    Use stack that is
    // Next Greater	        Decreasing
    // Previous Greater	    Decreasing
    // Next Smaller	        Increasing
    // Previous Smaller	    Increasing
    public static int[] MtS(int arr[]){
        Stack<Integer> st = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                int index = st.pop();
                result[index] = arr[i];
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int index = st.pop();
            result[index] = -1;
        }
        return result;
    }

    public static int[] monostack(int arr[]){
        Stack<Integer> st = new Stack<>();
        int result[] =  new int[arr.length];
        for(int i = 0;i<arr.length;i++){
            while (!st.isEmpty() && arr[st.peek()]<arr[i]) {
                int v = st.pop();
                result[v] = arr[i];
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int i = st.pop();
            result[i] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int ar[] = {2, 1, 5, 3, 4};
        // 2->5
        // 1->5
        // 5->0
        // 3->4
        // 4->0
        HashMap<Integer, Integer> result = MtS(ar);

        System.out.println(result);
    }
}
