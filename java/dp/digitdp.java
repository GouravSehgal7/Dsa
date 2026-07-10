package dp;

import java.util.Scanner;

public class digitdp {


    public static int s1(String s,int sm, int pos, boolean flag,int sum){
        // give 0 - n count where sum of digit of n = k
        if(pos == s.length()){
            if(sum == sm) return 1;
            else return 0;
        }
        // set up limit 
        int limit;
        if (flag) {
            limit = s.charAt(pos)-'0';
        }else{
            limit = 9;
        }
        int ans = 0;
        for(int i = 0;i<=limit;i++){
            ans+=s1(s, sm, pos+1, flag && (i == limit), sum+i);
        }
        return ans;
    }
    public static int s2(String s, int target, int pos,boolean flag,int cnt){
        // count 3 from 0-n 
        if (s.length() == pos) {
            return cnt;
        }
        if(s.charAt(pos) == target){
            cnt++;
        }
        int lim;
        if (flag) {
            lim = s.charAt(pos) - '0';
        }else{
            lim = 9;
        }
        int ans = 0;
        for (int i = 0; i < lim; i++) {
            ans+=s2(s, target, pos+1, flag && (i == lim), cnt+(i == lim?1:0));
        }
        return ans;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // give 0 - n count where sum of digit of n = k
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = Integer.toString(n);
            int sum = s1(s,k,0,true,0);
            // count 3 from 0-n 
            int val = s2(s,3,0,true,0);
            // count the numbers whose first and last digit are same
            
        }
    }
}