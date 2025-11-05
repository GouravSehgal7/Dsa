import java.util.*;

public class Main {
    public static int solution(int arr[] , int n){
        // check for ascending 
        boolean isAscending = true;
        // checking for asc
        for(int i = 1 ; i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                isAscending = false;
                break;
            }
        }
        if(isAscending == true){
            int max = arr[arr.length-1];
            return n-max+1;
        }
        return 1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // test
        int test = sc.nextInt();
        while(test>0){
            int n = sc.nextInt(), m = sc.nextInt();
            int[] a = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = sc.nextInt();
            }
            int result = solution(a,n);
            System.out.println(result);
            test--;
        }
    }
}
