import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class frequency {

    public static int MaxElement(int arr[]){
        int current=0;
        int freq  = 0;
        int answer = 0;
        int maxfrequency = 0;
        for (int i = 0;  i<arr.length; i++) {
            current = arr[i];
            if(current == answer){
                continue;
            }
            for (int j = 0;  j<arr.length; j++) {
                if(arr[j] == current){
                    freq++;
                }
            }
             if(freq>maxfrequency){
                maxfrequency = freq;
                answer = current;
            }
            freq = 0;
        }
        return answer;
    }
    
    // public static int MaxElementfreq2(int arr[]){
    //     // 
    // }
    
    public static void main(String[] args) {
        int arr[] = {1,1,3,4,3,3,3,3,1};
        int data = MaxElement(arr);
       
        String str = "dfdaw";
        str.contains("h");
        String ss = "23";
        String sr = "22";
        String s = "a";
        char a = 'd';
        System.out.println(a+"h");
        // System.out.println(Integer.parseInt(sr)+Integer.parseInt(ss));
    }
}
