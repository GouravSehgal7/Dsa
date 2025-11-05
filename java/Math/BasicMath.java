
import java.util.*;


public class BasicMath {

    public static void DigitinNumber(int number){
        while(number>0){
            int digit = number%10;
            number = number/10;
            System.out.println(digit);
        }
    }

    public static void DigitatNthplace(int num , int place){
        num = num / (int) Math.pow(10, place - 1);
        int digit = num%10;
        System.out.println(digit);
    }

    public static void findtwounique(){
        int arr[] = {1, 2, 4, 6, 7};
        int b = 1^2^3^4^5^6^7;
        int a = 0;
        for(int n : arr){
            a ^= n;
        }
       int f = a ^ b;
       int x = f & -f;
    //   System.out.println(x);
       int n1 =0,n2 = 0;
       for(int i = 0;i<=7;i++){
           if((i&x)!= 0){
               n1^=i;
           }else{
               n2^=i;
           }
       }
       
        for (int num : arr) {
            if ((num & x) != 0)
                n1 ^= num;
            else
                n2 ^= num;
        }
        
        System.out.println(n1);
        System.out.println(n2);
    }

// reminder = Log10(number)
    public static void OptimizedDigitCount(double number){
        while(number>0){
            int digit = (int)Math.log10(number);
            number = (int)number/10;
            System.out.println(digit);
        }
    }

    public static int ReverseNumber(int number){
        int reversenum = 0;
        while(number>0){
            int digit = number%10;
            number = number/10;
            reversenum = (reversenum*10)+digit;
        }
        return reversenum;
    }

    //Left shift = multiply with 2
    //right shift = divide by 2
    public static void shifting(int num){
        System.out.println(num);
        System.out.println(Integer.toBinaryString(num));
        num = num<<2;
        System.out.println(num);
        System.out.println(Integer.toBinaryString(num));
        num = num>>2;
        System.out.println(num);
        System.out.println(Integer.toBinaryString(num));
    }    

    //checking palindrome 
    //number which are same whether read from front or reverse order like 121 ,111 , 12321 
    // approach1 >>> frontnum XOR reversenum should be zero
    public static void ispalindromenum(int num){
        int reversenum = ReverseNumber(num);
        int val = num ^ reversenum;
        if(val == 0){
            System.err.println("yes");
        }
        else{
            System.out.println("lul");
        }
    }

    //Amstrong num
    //sum of cube of digit of num == num then amstorngnum like 371, 1634
    public static void Isamstrongnum(int number){
        int num = number;
        int sum = 0;
        while(number>0){
            int digit = number%10;
            number = number/10;
            sum = sum + (int)Math.pow(digit, 3);
        }
        if(sum == num){
            System.out.println("yes");
        } else{
            System.out.println("lul");
        }
    }

    public static void Primefactor(int num){
        if (num <= 1) {
            System.out.println("No prime factors for numbers less than 2.");
            return;
        }
        while (num % 2 == 0) {
            System.out.print(2 + " ");
            num /= 2;
        }
        for (int i = 3; i * i <= num; i += 2) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        if (num > 2) {
            System.out.print(num);
        }
    }

    public static Map<Integer,Integer> PrimeFactor2(int num){
        Map<Integer, Integer> primeFactors = new HashMap<>();
        if (num <= 1) {
            System.out.println("No prime factors for numbers less than 2.");
            return primeFactors;
        }
        while (num % 2 == 0) {
            primeFactors.put(2, primeFactors.getOrDefault(2, 0) + 1);
            num /= 2;
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            while (num % i == 0) {
                primeFactors.put(i, primeFactors.getOrDefault(i, 0) + 1);
                num /= i;
            }
        }
        if (num > 2) {
            primeFactors.put(num, primeFactors.getOrDefault(num, 0) + 1);
        }
        // for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
        //     System.out.println(entry.getKey() + "^" + entry.getValue());
        // }
        return primeFactors;
    }

    // All possible divisior 
    // approach1:- let a number num is written a^x*b^y*c^z where a,b,c are prime factors then Total Divisors=(x+1)⋅(y+1)⋅(z+1)
    public static void FindNumberofdiviser(int number){
        Map<Integer,Integer> data = PrimeFactor2(number);
        int diviser= 1;
        for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
            diviser= diviser*(entry.getValue()+1);
            // System.out.println(entry.getKey() + "^" + entry.getValue());
        }
        System.err.println(diviser);
    }

    public static void findAllDivisors(int number) {
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                if (number / i == i) {
                    System.out.println(i);
                } else {
                    System.out.println(i);
                    System.out.println(number / i);
                }
            }
        }
    }
    
    public static void checkprime(int n){
        
        for(int i = 0; i*i<=n;i++){
            if(n%i == 0){
                System.out.println("no");
            }
        }
        System.out.println("yes");
    }

    public static void checkprimeoptmize(int x){
        if(x == 3||x==2){
            System.out.println(true);
            return;
        }
        // check if 1 or not
        if(x <= 1 || x%2 == 0 || x%3 == 0) {
            System.out.println(false);
            return;
        }
        // loop for k check once for 6k-1 and second for 6k+1
        for(int k = 1;(6 * k + 1) * (6 * k + 1) <= x;k++){
            if(x%(6*k-1) == 0 || x%(6*k+1) == 0){
                System.out.println(false);
            }
        }
    }

    public static void fermat(){
        
    }

// gcd(a,b) = recursion(a%b
    public static void HCF1(int a, int b){
        if(b==0){
            return;
        }
        while(b != 0){
            int temp = b;
            b=a%b;
            a=temp;
        }
        System.out.println(a);
    }

    public static int HCF2(int a, int b) {
        if (b == 0) {
            System.out.println(a);
            return a; 
        }
        return HCF2(b, a % b);
    }

    // lcm = a.b/gcd(a,b)
    public static void LCM(int a , int b){
        int lcm = (a*b)/HCF2(a, b);
        System.out.println(lcm);
    }

    

    public static void main(String[] args) {
        // DigitinNumber(1234);
        // LCM(15,12);
    }
    
}