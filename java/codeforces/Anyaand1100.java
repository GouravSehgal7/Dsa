import java.util.Scanner;

public class Anyaand1100 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int q = sc.nextInt();
            char c[] = s.toCharArray();
            int cnt = 0;
            for(int st = 0;st<c.length-3;st++){
                if(c[st+3] == '0' && c[st+2] == '0' && c[st+1] == '1' && c[st] == '1'){
                    cnt++;
                }
            }
            
            while (q-- >0) {
                int i = sc.nextInt();
                int v = sc.nextInt();
                if(s.length()<4){
                    System.out.println("no");
                    continue;
                }
                i--;
                int st = i-3;
                while (st <= i) {
                    if(st >= 0 && st + 3 < c.length){
                        if(c[st] == '1' && c[st+1] == '1' && c[st+2] == '0' && c[st+3] == '0') cnt--;
                    }
                    st++;
                }

                c[i] = (char)('0'+v);
                st = i - 3;
                while (st <= i) {
                    if(st >= 0 && st + 3 < c.length){
                        if(c[st] == '1' && c[st+1] == '1' && c[st+2] == '0' && c[st+3] == '0') cnt++;
                    }
                    st++;
                }
                if(cnt >0){
                    System.out.println("yes");
                }else{
                    System.out.println("no");
                }
            }

        }

    }
    
}
