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
        int str = 0;
        int edr = arr.length-1;
        int stc = 0;
        int edc = arr[0].length -1;
        while (str<=edr && stc<=edc ){
            for(int i = stc;i<=edc;i++){
                System.out.println(arr[str][i]);
            }
            for(int i = str+1;i<=edr;i++){
                System.out.println(arr[i][edc]);
            }
            for(int i = edc-1;i>=stc;i--){
                if(str==edr){
                    break;
                }
                System.out.println(arr[edr][i]);
            }
            for(int i = edr-1;i>=str+1;i--){
                if(stc==edc){
                    break;
                }
                System.out.println(arr[i][stc]);
            }
            str++;
            stc++;
            edr--;
            edc--;
        }
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

    public static void SearchInCompleteSorted(int arr[][],int t){
        // non overlaping rows
        // binary search approach in col and then row
        int st = 0;
        int ed = arr.length-1;
        while(st<=ed){
            int mid = st + (ed-st)/2;
            if(t>=arr[mid][0] && t<=arr[mid][arr[mid].length-1]){
                int l = 0;
                int h = arr[mid].length-1;
                while (l<=h) {
                    int m = l + (h-l)/2;
                    if(arr[mid][m]==t){
                        System.out.println(t + " found at row " + mid + " col " + m);
                        return;
                    }else if(arr[mid][m]<t){
                        l = m + 1;
                    }else{
                        h = m-1;
                    }
                }
                return;
            }else if(t<arr[mid][0]){
                ed = mid-1;
            }else{
                st=mid+1;
            }
        }
    }

    public static void stairCase(int arr[][], int t){
        // overlaping rows
        // start with edges of matrix and decide where to move depending upon the sorted manner of value mostly top left sa start karo
        // time complexity 0(m+n)
        int r = 0;
        int c = arr[0].length -1;
        while (r<arr.length && c>=0) {
            if(arr[r][c]>t){
                c--;
            }else if(arr[r][c]<t){
                r++;
            }else if(arr[r][c] == t){
                System.out.println(t + " found at row "+r+" and column "+c);
            }
        }
    }


    public static void main(String[] args) {
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        // printH(arr);
        // linearSearch(arr, 8);
        
        spiralPrint(arr);
    }
    
}
