public class TwoDarray {

    public static void printRowWise(int arr[][]){
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                System.out.println(arr[i][j]);
            }
        }
    }

    public static void printcolumnwise(int arr[][]){
        for(int i = 0;i<arr[0].length;i++){
            for(int j = 0;j<arr.length;j++){
                System.out.println(arr[j][i]);
            }
        }
    }
   
    public static void linearSearch(int arr[][],int t){
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                if(arr[i][j] == t){
                    System.out.println("found at : i -> "+i +" j-> "+j);
                    return;
                }
            }
        }
        System.out.println("not found");
        return;
    }

    public static int[][] reverseRow(int arr[][]){
        for(int i = 0;i<arr.length;i++){
            int st = 0;
            int ed = arr[i].length-1;
            while (st<ed){
                int temp = arr[i][st];
                arr[i][st] = arr[i][ed];
                arr[i][ed] = temp;
                st++;
                ed--; 
            }
        }
        return arr;
    }
    
    public static int[][] reverseCol(int arr[][]){
        for(int i = 0; i<arr[0].length;i++){
            int st = 0;
            int ed = arr.length-1;
            while (st<ed) {
                int temp = arr[st][i];
                arr[st][i] = arr[ed][i];
                arr[ed][i] = temp;
                st++;
                ed--;
            }
        }
        return arr;
    }

    public static void zigzacRow(int arr[][]){
        for(int i = 0; i<arr.length;i++){
            for(int j = 0; j < arr[i].length;j++){
                if(i%2 == 0){
                    System.out.println(arr[i][j]);
                }else{
                    System.out.println(arr[i][arr[i].length-j-1]);
                }
            }
        }
    }

    public static void zigzacCol(int arr[][]){
        for(int i = 0;i<arr[0].length;i++){
            for(int j = 0;j<arr.length;j++){
                if(i%2 == 0){
                    System.out.println(arr[j][i]);
                }else{
                    System.out.println(arr[arr.length-1-j][i]);
                }
            }
        }
    }

    public static void spiralPrint(int arr[][]){
        
    }

    public static void absDiagonalDiff1(int arr[][]){
        int sumd1 = 0;
        int sumd2 = 0;
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                if(i == j){
                    sumd1+=arr[i][j];
                }else if(i == arr.length -1 - j){
                    sumd2+=arr[i][j];
                }
            }
        }
        System.out.println(Math.abs((sumd1-sumd2)));
    }

    public static void absDiagonalDiff2(int arr[][]){
        int sumd1 = 0;
        int sumd2 = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            sumd1 += arr[i][i];
            sumd2 += arr[i][n - 1 - i];
        }

        System.out.println(Math.abs(sumd1 - sumd2));
    }

    public static int[][] transpose(int arr[][]){
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                if(i<=j){
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
        }
        return arr;
    }

    public static void maxcolsum(int arr[][]){
        int max = 0;
        for(int i = 0;i<arr[0].length;i++){
            int sum = 0;
            for(int j = 0; j<arr.length;j++){
                sum+=arr[j][i];
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

    public static void SearchInCompleteSorted(int arr[][]){
        
    }



    public boolean searchMatrix(int[][] matrix, int target) {
        // approach 1 linear search
        // approach 2 make a new array and copy all the elem to it and use binary search
        // approach 3 -:
            // choose row 1 check if result exist in min and max value if yes then use binary search

            // for(int i = 0; i<matrix.length;i++){
            //     if(target >= matrix[i][0] && target<=matrix[i][matrix[i].length-1]){
            //         int st = 0;
            //         int end = matrix[i].length-1;
            //         while(st<=end){
            //             int mid = (st+end)/2;
            //             if(matrix[i][mid] == target){
            //                 return true;
            //             }
            //             else if(target>matrix[i][mid]){
            //                 st = mid+1;
            //             }
            //             else{
            //                 end = mid -1;
            //             }
            //         }
            //     }
            // }
            // return false;

        // approach 4 :- 
            // check from c1 = 0 st , end
            // find mid and check if it exit in that array by ckeck max and min val 
            
            
            int st = 0;
            int end = matrix.length-1;
            while(st<=end){
                int mid = (st+end)/2;
                if(matrix[mid][0] <= target && matrix[mid][matrix[mid].length-1]>=target){
                    int s = 0;
                    int ed = matrix[mid].length-1;
                    while(s<=ed){
                        int m = (s+ed)/2;
                        if(matrix[mid][m] == target){
                            return true;
                        }
                        else if(target>matrix[mid][m]){
                            s = m+1;
                        }
                        else{
                            ed = m -1;
                        }
                    }
                    return false;
                }
                else if(matrix[mid][0] > target){
                    end = mid-1;
                }
                else if(matrix[mid][0] < target && matrix[mid][matrix[mid].length-1]<target){
                    st = mid+1;
                }

            }
        return false;
    }

    // binary search in cell
    public static void searchinsorted(int [][] arr,int target){
        // lowese is at arr[0][0]
        // largest is at arr[m-1][n-1]
        
    }


    public static void main(String[] args) {
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        // printH(arr);
        // linearSearch(arr, 8);
        
        maxcolsum(arr);
    }
    
}
