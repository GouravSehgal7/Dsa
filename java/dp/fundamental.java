package dp;
public class fundamental {


    // [2,-3,5,-8,7]
    // find the max sum subset such that no two num adjacent
    // [2,5,7], [2,-8], [-3,-8] valid 
    // [2,-3] not valid;
    // dp[i] = for length i sum is max such subset 
    // dp[0] = arr size = 0 return 0
    // dp[1] = best ans if array is of size 1 [2] return 2;
    // dp[2] = [2,-3] so ans can be either 2 or -3 ans is 2 >> -3 answer = 2;
    // dp[3] = [2,-3,5] answer for first 3 num 
    // it can be either we can select the 3 rd elem so 5 but now we can also select 1st as well 
    // dp[i] = max (arr[i]+dp[i-2],dp[i-1]) is our formula 

    


    public static void main(String[] args) {
        
    }


}
