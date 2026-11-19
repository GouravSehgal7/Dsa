
public class allalgo {


    // anagram  already done
    // Two strings are anagrams if they contain exactly the same characters with exactly the same frequencies, regardless of order.




    // Expand around center pallandrom problem
    // it allow us to find out all possible pallandrom in a string along with the possible lengths
    // in n square time

    public static int expand(String s, int l , int r ){
        if(l>=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r -l + 1;
    }
    public static void findlargestpallandrom(String p){

    }


    // lexicographical order
    


    // lexicographically optimal



    // string hashing + Rabin–Karp Rolling hash



    // Sliding window + hashing in substring forming a prefix array of hashes



    // Z-algorithm



    // KMP / LPS









    
}
