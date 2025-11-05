import java.util.ArrayList;

public class recursion {

    public static void print(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        print(n-1);
        System.out.println(n);
    }

    public static int fact(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return n*fact(n-1);
    }
    
    public static int sumofn(int n){
        if(n == 0){
            return 0;
        }
        return n + sumofn(n-1);
    }

    public static int fibo(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fibo(n-1)+fibo(n-2);
    }

    public static boolean issorted(int arr[],int i){
        // base known condition
        if(i == 0|| i == 1){
            return true;
        }
        boolean val =  arr[i-1]>arr[i-2] && issorted(arr, i-1);
        return val;
    }

    public static void allSubsetArray(int arr[],ArrayList<Integer> subset,int i){
        if(i == arr.length-1){
            for (Integer val : subset) {
                System.out.print(val);
                System.out.println();
                return;
            }
        }
        subset.add(arr[i]);
        allSubsetArray(arr, subset, i+1);
        subset.remove(subset.size()-1);
        allSubsetArray(arr, subset, i+1);
    }

    public static void main(String[] args) {
        // print(3);
        // System.out.println(sumofn(3));
        int arr[] = {1,2,3};
        ArrayList<Integer> ar = new ArrayList<>();
        allSubsetArray(arr, ar, 0);
    }
}
