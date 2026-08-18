import java.util.Scanner;

public class TheatreSquare {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long m = sc.nextLong();
        long a = sc.nextLong();
        long a1 = (n+a-1)/a;
        long a2 = (m+a-1)/a;
        System.out.println(a1*a2);
    }
    
}
