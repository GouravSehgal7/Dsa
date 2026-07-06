package dp;

import java.util.ArrayList;

public class maskeddp {
    // [1,2,3]= [],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]
    public ArrayList<ArrayList<Integer>> Subset(int arr[]){
        int n = arr.length;
        int mask = 1<<n;
        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        for(int m = 0;m<mask;m++){
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((m & (1 << i)) != 0) {
                    temp.add(arr[i]);
                }
            }
            ar.add(temp);
        }
        return ar;
    }

    public int[] singleNumber(int[] nums) {
        int xor = nums[0];
        for(int i = 1;i<nums.length;i++){
            xor^=nums[i];
        }
        int mask = xor&-xor;
        int a = 0;
        int b = 0;
        for(int i : nums){
            if((mask & i) == 0){
                a^=i;
            }else{
                b^=i;
            }
        }
        return new int[]{a,b};
    }

    public boolean PartetionKEqualSubsetSum(int nums[],int k){
        int sum=0;
        for(int n : nums){
            sum+=n;
        }
        if(sum%k!=0) return false;
        int target = sum/k;
        int n = nums.length;
        int mask = 1<<n;
        


    }
    public static void main(String[] args) {
        
    }
    
}
