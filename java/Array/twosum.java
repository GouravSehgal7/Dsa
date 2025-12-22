import java.util.*;
public class twosum {

    // public static int[] Twosum(int []arr,int target){
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for(int i = 0; i<arr.length;i++){
    //         map.put(arr[i], i);
    //         int val = target - arr[i];
    //         if(map.containsKey(val)){
    //             return new int[]{map.get(val),i};
    //         }
    //     }
    //     return new int[]{};
    // }=o/l0

    public static boolean check(int[] nums) {
        int pivot = -1;
        // finding pivot
        for(int i = 0; i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                pivot = i;
                System.out.println(pivot);
                System.out.println(nums[pivot]);
                break;
            }
        }

        if(pivot == -1){
            System.out.println("yes");
            return true;
        }

      
        for(int i = pivot+1; i<nums.length-1;i++){
            System.out.println("current pivit "+i);
            System.out.println(" ::: " + nums[i]+" <= "+nums[pivot]);
            if(nums[i]<=nums[i+1]){
                System.out.println(" ::: " + nums[i]+" ..<.. "+nums[i+1]);
                if(nums[i] >= nums[pivot] || nums[i+1] >= nums[pivot]){
                    System.out.println(" ::: " + nums[i]+" > "+nums[pivot]);
                    return false;
                }
            } else{
                return false;
            }
        }
        
       return true;

    }

    public static void main(String[] args) {
        // for(int i =0; i<3;i++){
        //     for(int j = 0;j<3;j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
        // String st = "* ";
        // st = st.repeat(3);
        // System.out.println(st);
        // int arr[] = {2,1,3,4};
        // int arr2[] = {2,4,1,2,4};
        // System.out.println(check(arr));
        // Map<Integer,Integer> hm = new HashMap<>();
        // hm.put(1, hm.getOrDefault(hm.get(1), 0)+1);
    }
}