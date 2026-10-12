package Arraycore;

public class binarysearch18lpaQ {

    // you are given an efficiency array of n people [4,2,3,1]
    // you are given M task let say M = 10
    // a person take time t = e*x^2
    // where x = number of task it has done
    // everyone are doing task simoultaneously
    // min time required to do all task
    // example let alloted task to each are [4->2,2->2,3->2,1->4]
    // time = max(16,8,12,16) = 16
    // we have to find min time form such different times based on different permutation

    // concept -> listen pallandrom i know it look hard
    // in bruet force 
    // we have to find all possible ways to divide M into N pieces
    // then we have to calc time for that piece with efficiency factor and do this for all possible pieces and then we will find min 
    // one more thing constrain are soo high that it says no to recursion
    // what about dp
    // i still have to make all possible pieces no possiblity of optimization 
    // what about binary search --- 
    // concept:- 
    // the max time it can take is 4*100= 400 if all task are done by max efficiency worker and min time it can take is 0
    // we have to find that min time befor which no task is done and on, after which all task can be done
    // [1,2,3,4,11,12,16,22,12345,121345865654333,infinity]
    // let that time is t so the array will look like
    // [f,f,f,f,f,t,t,t,t,t,t]
    // the point where first time t apper is the point we want to find
    // this whole concept is called monotonicity [f,f,f,f,f,t,t,t,t,t,t]
    // again monotonic is the actual reason binary search work on sorted array not the sorted array is reason of working of binary search on it
    // math
    // e*x^2 <= t
    // we can find this t using binary search so we have an idea of t
    // we have to find a range idea of this x value 
    // x <= sqrt(t/e) for each e
    // and check if sum(x) for each e exceeds M if yes it means for given time t it can handle more then M task it means below this time there exist some time for which this condition will also hold or this is the last one 
    // so break
    // 




    public static int solveq1(int efficiency[], int M){
        // find max
        int max = efficiency[0];
        for(int x : efficiency){
            max = Math.max(max,x);
        }
        int high = max*M*M;
        int low = 0;
        while (low<high) {
            int mid = (low+high)/2;
            int total = 0;
            for(int i : efficiency){
                int mintask = (int)Math.sqrt(mid/i);
                total+=mintask;
                if(total>=M)break;
            }
            if (total>=M) {
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    // koko eats banana
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for(int x : piles){
            max = Math.max(max,x);
        }
        int high = max;
        int low = 1;

        while (low < high) {
            int k = low + (high - low) / 2;
            long hours = 0;
            for (int pile : piles) {
                hours += (pile + k - 1) / k;
                if (hours > h) {
                    break;
                }
            }

            if (hours <= h) {
                high = k;
            } else {
                low = k + 1;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        
    }
    
}
