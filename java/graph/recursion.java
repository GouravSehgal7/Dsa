import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class recursion {


   static class FindSumPairs {
    int []nums1;
    int []nums2;
    Map<Integer,Integer> hm;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.hm = new  HashMap<>();
        for(int num : this.nums1){
         System.out.println(num);
            hm.put(num,hm.getOrDefault(num, 0)+1);
            // System.out.println(hm.size());

         //   System.out.println(hm.get(num));
        }
    }
    
    public void add(int index, int val) {
        this.nums2[index]+=val;
        return ;
    }
    
    public int count(int tot) {
        int count = 0;
        for(int i = 0; i<this.nums1.length;i++){
            if(this.hm.containsKey(tot - nums2[i])){
               // System.out.println(this.hm.get();
                    count+=this.hm.get(tot-nums2[i]);
            }
        }
        return count;
    }
}

   
   public static int factorial(int num){
      // base case : 0 , 1 -> 1
      if(num == 0 || num == 1){
         return 1;
      }
      return num * factorial(num -1);
   }

   public static void printarr(int arr[], int start){
      if(start == arr.length){
         return;
      }
      System.out.println(arr[start]);
      printarr(arr, start+1);
   }

   public static void sumarr(int arr[], int st ,int sum){
      if(st == arr.length){
         System.out.println("//");
         return;
      }
      sum = sum+arr[st];
      System.out.println("before : "+sum);
      sumarr(arr, st+1, sum);
      System.out.println("after +"+sum);
   }

   // public static void print2d(int arr[][], int r, int c, boolean visited[][]){
   //    System.out.print(arr[r][c]);
   //    visited[r][c] = true;
      // if(visited[r][c] == true ){
      //    return;
      // }
      // if(r != arr.length-1 || visited[r][c] != true){
      //    print2d(arr, r+1, c, visited);
      // }
      // return;
   //    
         // if(c != arr[0].length-1 || visited[r][c] != true){
         //    print2d(arr, r, c+1, visited);
         // }

      // if(r >=0 || visited[r][c] != true){
      //     print2d(arr, r-1, c, visited);
      // }
      //    if(c != arr[0].length-1 || visited[r][c] != true){
      //       print2d(arr, r, c-1, visited);
      //    }
      // return;
   //   
   //    print2d(arr, r, c-1, visited);
   // }

   public static void binaryS(int arr[], int src, int min , int max ){
      // int max = arr.length -1;
      // int min = 0;
      System.out.println("try");
      int mid = (max+min)/2;
      if(arr[mid] == src){
         System.out.println(arr[mid]);
      }
      if(src>arr[mid]){
         min = mid+1;
         binaryS(arr, src, min, max);
      }
      if(src<arr[mid]){
         max = mid-1;
         binaryS(arr, src, min, max);
      }
      if(max == min ){
      return;
      }
   }

   public static int fibo(int n){
      System.out.println(n);
      if(n == 0){
         return 0;
      }
      if(n == 1){
         return 1;
      }
      
      return fibo(n-1)+fibo(n-2);
   }
   
   public static void issorted(int arr[], int s){
      if(arr.length == s+1){
         return;
      }
      if(arr[s]<arr[s+1]){
         System.out.println(arr[s]);
         // System.out.println(k);
      issorted(arr, s+1);
      System.out.println(arr[s]);
      }
      return;
   }

   public static void divide(int arr[],int add[],int st,int count){
      
   }

   // public static void printsubset(int arr[],int st){
   //    System.out.println();
   //    printsubset(arr,st+1);
   // }
   public static void main(String[] args) {
   //  int fact = factorial(3);
   //  System.out.println(fact);
   //  int arr[]= {1,2,4,3};
   //  issorted(arr, 0);
   //  sumarr(arr, 0,0);

   //  int arr2[][]= {{1,2,3},
   //                {4,3,4},
   //                {5,4,5}};

      //  boolean visited[][] = {{false,false,false},
      //                         {false,false,false},
      //                         {false,false,false}};
      
      // int arr []  = {1,2,3,4,4,5,7,76};
      // print2d(arr2, 0, 0,visited);
      // binaryS(arr, 37, 0, arr.length);

   // fibo(5);

   int n1[] =  {9,70,14,9,76};
   int n2[] = {26,26,58,23,74,68,68,78,58,26};
   FindSumPairs obj = new FindSumPairs(n1, n2);
   System.out.println(obj.count(88));
   
   } 
   
}
