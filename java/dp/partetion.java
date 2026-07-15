package dp;

public class partetion {

    /**
     * McmSolutionDp
     */
    public class McmSolutionDp {

        public static int rec(int arr[],int i, int j){
            if(i == j) return 0;
            int min = Integer.MAX_VALUE;
            for(int k = i;k<j;k++){
                int operation = arr[k]*arr[i-1]*arr[j]
                            + rec(arr, i, k) + rec(arr, k+1, j);
                min = Math.min(operation, min);
            }
            return min;
        }
        public static int memo(int arr[],int i, int j, int dp[][]){
            if(i == j) return 0;
            if(dp[i][j] != -1) return dp[i][j];
            int min = Integer.MAX_VALUE;
            for(int k = i;k<j;k++){
                int operation = arr[k]*arr[i-1]*arr[j]
                            + memo(arr, i, k,dp) + memo(arr, k+1, j,dp);
                min = Math.min(operation, min);
            }
            return dp[i][j] = min;
        }
        public static int tabulation(int arr[]){
            int n = arr.length -1;
            int dp[][] = new int[n][n];
            for(int i = 0;i<n;i++) dp[i][i] = 0;

            for(int i = n-1;i>=1;i--){
                for(int j = i+1;j<n;j++){
                    int min = Integer.MAX_VALUE;
                    for(int k = i;k<j;k++){
                        int s = arr[i-1] * arr[k] * arr[j]
                            + dp[i][k]
                            + dp[k+1][j];
                        dp[i][j] = Math.min(min, s);
                    }
                }
            }
            return dp[1][n-1];
        }
    }


    public static void main(String[] args) {
        // mcm 
        // given array 
        int arr[] = new int[]{10,20,30,40,50};
        
    }
}
