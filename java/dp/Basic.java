package dp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Basic {


    public static class Fibonaci {
        public int rec(int n){
            if(n == 0 || n == 1) return 1;
            return rec(n-1) + rec(n-2);
        }
        public int memo(int n , int dp[]){
            if(n == 0 || n == 1) return 1;
            if(dp[n] != -1) return dp[n];
            dp[n] = memo(n-1, dp)+memo(n-2, dp);
            return dp[n];
        }
        public int tabulation(int n , int dp[]){
            dp[0] = 1;
            dp[1] = 1;
            for(int i = 2;i<n;i++){
                dp[i] = dp[i-1]+dp[i-2];
            }
            return dp[n];
        }
    }

    public static class  Staircase {
        public int rec(int n,int i){
            if(i>n)return 0;
            if(i == n)return 1;
            return rec(n, i+1)+rec(n, i+2);
        }
        public int memo(int n , int i , int []dp){
            if(i>n)return 0;
            if(i == n)return 1;
            if(dp[i] != -1) return dp[i];
            dp[i] = memo(n, i+1, dp)+memo(n, i+2, dp);
            return dp[i];
        }
        public int tabulation(int n,int dp[]){
            dp[n] = 1;
            dp[n+1] = 0;
            dp[n+2] = 0;
            for(int i = n-1;i>=0;i--){
                dp[i] = dp[i+1]+dp[i+2];
            }
            return dp[0];
        }
    }

    public static class  Possiblegridtraversal {
        public int rec(int sti, int stj, int edi,int edj){
            if(sti == edi && stj == edj) return 1;
            // right , down 
            int right = 0;
            int down = 0;

            if(sti+1<=edi){
                right = rec(sti+1, stj, edi, edj);
            }
            if(stj+1 <= edj){
                down = rec(sti, stj+1, edi, edj);
            }
            return right + down;
        }
        public int memo(int sti, int stj, int edi,int edj, int dp[][]){
            if(sti == edi && stj == edj) return 1;
            if(dp[sti][stj] != -1) return dp[sti][stj];
            int right = 0;
            int down = 0;
            if(sti+1<=edi){
                right = rec(sti+1, stj, edi, edj);
            }
            if(stj+1 <= edj){
                down = rec(sti, stj+1, edi, edj);
            }
            dp[sti][stj] = right+down;
            return dp[sti][stj];
        }
        public int tabulation(int sti, int stj, int edi,int edj, int dp[][]){
            dp[edi][edj] = 1;
            for(int i = edi; i >= 0; i--){
                for(int j = edj; j >= 0; j--){
                
                    if(i ==edi && j == edj)
                        continue;
                    int down = 0;
                    int right = 0;
                    if(i + 1 <= edi)
                        down = dp[i+1][j];
                    if(j + 1 <= edj)
                        right = dp[i][j+1];
                    dp[i][j] = down + right;
                }
            }
            return dp[0][0];
        }
    }

    public static class Combinationsum {
        public void rec(int arr[], int target,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> temp, int i){
            if(target == 0){
                result.add(temp);
                return;
            }
            if(target<0 || i == arr.length) return;
            temp.add(arr[i]);
            rec(arr, target-arr[i], result, temp, i);
            temp.remove(temp.size()-1);
            rec(arr, target, result, temp, i+1);
        }
    }

    public static class  Minimamnumcoin {
        public int rec(int coin[], int t){
            if(t == 0) return 0;
            if(t < 0) return -1;
            int min = Integer.MAX_VALUE;
            for(int i = 0;i<coin.length;i++){
                int x = rec(coin, t-coin[i]);
                if (x != -1) {
                    min = Math.min(min, x+1);          
                }
            }
            return min;
        }
        public int memo(int coin[], int t, int dp[]){
            if(t == 0) return 0;
            if(t < 0) return -1;
            if(dp[t] != -2) return dp[t];
            int min = Integer.MAX_VALUE;
            for(int i = 0;i<coin.length;i++){
                int x = memo(coin, t-coin[i],dp);
                if (x != -1) {
                    min = Math.min(min, x+1);          
                }
            }
            if(min == Integer.MAX_VALUE){
                dp[t] = -1;
                return dp[t];
            }
            dp[t] = min;
            return dp[t];
        }
        public int tabulation(int coin[], int t){
            int dp[] = new int[t+1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for(int c : coin){
                for(int i = 1; i<t+1;i++){
                    if(i >= c && dp[i-c] != Integer.MAX_VALUE){
                        dp[i]=Math.min(dp[i], dp[i-c]+1);
                    }
                }
            }
            return dp[t] == Integer.MAX_VALUE ? -1 : dp[t];
        }
    }
    
    public static class RobberHouse {
        public int rec1(int []nums,int stidx){
            int nxtst = stidx+2;
            int best = 0;
            if(nxtst<nums.length){
                for(int i = nxtst;i<nums.length;i++){
                    int r = S(nums,i);
                    best = Math.max(r,best);
                }
            }
            return best+nums[stidx];
        }
        public int memo1(int []nums,int stidx, int[] dp){
            if(dp[stidx]!=-1){
                return dp[stidx];
            }
            int nxtst = stidx+2;
            int best = 0;
            if(nxtst<nums.length){
                for(int i = nxtst;i<nums.length;i++){
                    int r = S(nums,i,dp);
                    best = Math.max(r,best);
                }
            }
            dp[stidx] = best+nums[stidx];
            return dp[stidx];
        }
        public int rec2(int nums[], int stidx){
            if(stidx>=nums.length) return 0;
            int max = 0;
            int skip = rec2(nums, stidx+1);
            int rob = rec2(nums, stidx+2);
            max = Math.max(skip, rob+nums[stidx]);
            return max;
        }
        public int memo2(int nums[], int stidx,int dp[]){
            if(stidx>=nums.length) return 0;
            if(dp[stidx]!=-1) return dp[stidx];
            int skip = rec2(nums, stidx+1);
            int rob = rec2(nums, stidx+2);
            dp[stidx] = Math.max(skip, rob+nums[stidx]);
            return dp[stidx];
        }
        // public int tabulation(int nums[]){
        //     int dp[] = new int[nums.length];
        //     Arrays.fill(dp, 0);
        //     for(int i = 0;i<nums.length;i++){
        //         dp[i] = Math.max(dp[i+1], dp[i+2]+nums[i]);
        //     }
        // }
    }


    public class  Knapsack01 {
        public static int rec(int val[],int wt [], int W,int sum){

            for(int i = 0;i<wt.length;i++){
                
            }


        }
        
    }
    
    public static class Maximumrod {
        public int rec1(int n , int x , int y , int z){
            if(n == 0) return 0;
            if(n<0) return Integer.MIN_VALUE;
            int a = rec1(n-x, x, y, z)+1;
            int b = rec1(n-y, x, y, z)+1;
            int c = rec1(n-z, x, y, z)+1;
            int ans = Math.max(a, Math.max(b, c));
            if(ans == Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            return ans + 1;
        }
        public int memo1(int n , int x , int y , int z,int dp[]){
            if(n == 0) return 0;
            if(n<0) return Integer.MIN_VALUE;
            if(dp[n] != -1) return dp[n];
            int a = memo1(n-x, x, y, z,dp)+1;
            int b = memo1(n-y, x, y, z,dp)+1;
            int c = memo1(n-z, x, y, z,dp)+1;
            int ans = Math.max(a, Math.max(b, c));
            dp[n] = ans;
            if(ans == Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            return dp[n];
        }
        public int tabulation1(int n , int x , int y , int z){
            int dp[] = new int[n+1];
            Arrays.fill(dp, Integer.MIN_VALUE);
            dp[0] = 0;
            for(int i = 0;i<n;i++){
                if(i-x>=0)
                    dp[i]= Math.max(dp[i-x]+1,dp[i]);
                if(i-x>=0)
                    dp[i]= Math.max(dp[i-y]+1,dp[i]);
                if(i-x>=0)
                    dp[i]= Math.max(dp[i-z]+1,dp[i]);
            }
            return dp[n];
        }
        // different question
        public int rec2(int n , int []a){
            if(n<0) return Integer.MIN_VALUE;
            if(n == 0) return 0; 
            int max = Integer.MIN_VALUE;
            for(int i = 0;i<a.length;i++){
                int res = rec2(n-a[i], a);
                if(res != Integer.MIN_VALUE){
                    max = Math.max(max, res+1);
                }
            }
            return max;
        }
        public int memo2(int n , int a[], int dp[]){
            if(n<0) return Integer.MIN_VALUE;
            if(n == 0) return 0; 
            if(dp[n]!= -1) return dp[n];
            int max = Integer.MIN_VALUE;
            for(int i = 0;i<a.length;i++){
                int res = memo2(n-a[i], a,dp);
                if(res != Integer.MIN_VALUE){
                    max = Math.max(max, res + 1);
                }
            }
            return dp[n] = max;
        }
        public int tabulation2(int n, int a[]){
            int dp[] = new int[n+1];
            Arrays.fill(dp,Integer.MIN_VALUE);
            dp[0] = 0;
            for(int i = 0;i<=n;i++){
                for(int e : a){
                    if(i -e >=0 &&  dp[i-e] != Integer.MIN_VALUE)
                        dp[i] = Math.max(dp[i], dp[i-e]+1);
                }
            }
            return dp[n];
        }
        
    }

    public static class CountDerangement{
        public int rec(int orignal[],int temp[]){

            // analyze all possible combo
            

        }
    }
    
    public static void main(String[] args) {
        Fibonaci f = new Fibonaci();
        int n  = f.rec(3);
        System.out.println(n);

    }
    
}