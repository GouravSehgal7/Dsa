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

    // public static void findcount(int n){
    //     for(int i = 1;i<11;i++){
    //         int cnt = n*i;
    //     }
    // }


    public static void main(String[] args) {
        // String s = "000110111100";
        // for(int i = 0; i<s.length();i+=2){
        //         if ("00".equals(String.valueOf(s.charAt(i))+String.valueOf(s.charAt(i+1)))) System.out.print("A ");
        //         if ("01".equals(String.valueOf(s.charAt(i))+String.valueOf(s.charAt(i+1)))) System.out.print("T ");
        //         if ("10".equals(String.valueOf(s.charAt(i))+String.valueOf(s.charAt(i+1)))) System.out.print("C ");
        //         if ("11".equals(String.valueOf(s.charAt(i))+String.valueOf(s.charAt(i+1)))) System.out.print("G ");
        // }
        NumberOFPrime(11);
    }
}