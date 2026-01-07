public class st {

    public static void OptmizeNumberOfPrime(int n){

    // initialize arr of size n+1
        int cnt = 0;
        boolean isprime[] = new boolean[n+1];
        for(int i = 2;i<isprime.length;i++){
            isprime[i] = true;
        }

        for(int j = 2; j<=n;j++){
            if(isprime[j] == true){
                cnt++;
                int i = 2;
                while (i*j<=n) {
                    int val = j * i;
                    isprime[val] = false;
                    i++;
                }
            }
            continue;
            
        }
    }

    public static void NumberOFPrime(int n){
        // check if all number below n are prime and count
        int cnt = 0;
        // select i 
        // check if 0 - i-1 are prime or not
        for(int i = 2; i <=n;i++){
            boolean isprime = true;
            for(int j = 2;j*j <= i;j++){
                if(i%j == 0){
                    isprime = false;
                    break;
                }
            }
            if(isprime == true){
                cnt++;
            }
        }
System.out.println(cnt);
    }

    public static void LongestPrefixSuffixLen(String s){
        // bruit force
        // constrain
        // len suffix == len prefix
        //  value == same
        // do not take whole string 
        // overlap allowed
        String prefix = "";
        String suffix = "";
        int st = 1;
        int ed = s.length()-1;
        int len = 0;
        while (st<s.length()-1 && ed > 1) {
            prefix = s.substring(0,st);
            suffix = s.substring(ed, s.length());
            if(prefix.equals(suffix)){
                len = Math.max(len, prefix.length());
            }
            st++;
            ed--;
        }
        System.out.println(len);
        return ;
    }

    public static void KPM(){

    }


    public static void main(String[] args) {
        String a= "abcdrabcd";
        LongestPrefixSuffixLen(a);
    }

}