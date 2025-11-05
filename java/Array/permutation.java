public class permutation {
    
    public static void nextPermutation(int arr[]){
        // 123->132->213->231->312->321
        12345 6 -> if next small -> swap with next -> arrange in accending order upto the current ptr-> 123465 -> if next is big then i++ 

        1234 5 6 -> 1234 6 5 -> /* 1236 4 5*/->  1235 4 6  -> 1235 6 4 ->  1236 5 4 -> 1236 4 5 -> 1236 5 4 -> /*  126 3 4 5 */
    }

public static void main(String[] args) {
    
}
}
