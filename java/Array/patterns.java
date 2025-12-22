import java.util.ArrayList;
import java.util.HashMap;
// import java.util.Map;

public class patterns {

    public static void pattern1(int n){
        for(int i = n;i>0;i=i-1){
            for(int j = 0; j<i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern2(int n){
        for(int i = n;i>0;i--){
            for(int j = 0;j<n+1&& i<j ;j++){
                System.out.print("* ");
                // System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        // Math.abs(0)
        // pattern2(5);
        int arr[] = {1,2,1,3,2,3,5,1,1};
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            // hm.put(num, hm.getOrDefault(num, 0)+1);
            ArrayList<Integer> am = new ArrayList<>();
            am.get(i);
            // hm.putIfAbsent(null, null)
            hm.put(i, arr[i] );
        }

        System.out.println(hm.size());
        
            System.out.println(hm.keySet());
            System.out.println(hm.values());
            System.out.println(hm.get(1));
            System.out.println(hm.get(3));
    }
}
