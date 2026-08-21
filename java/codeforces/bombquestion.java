import java.util.ArrayList;
import java.util.HashMap;

public class bombquestion {


    // question
    // given bombid = [1,2,1,3,2] , cost = [10,20,20,10,30] 
    // we need to make these cost equals to given x by defusing specific id
    // if removing an id k all id will be removed in the arrray and final result will be the sum of all id 
    // return final number of bomb left if reached to x if not possible to rach x return -1;


    public static int dpdfs(int bomb[], 
        int cost[],
        int x , 
        HashMap<Integer,Integer> hm1,
        HashMap<Integer,ArrayList<Integer>> hm2

    ){

        if(x < 0) return -1;

        if(x == 0){

        }

        



        return -1;
    }

    public static int solution(int bomb[], int cost[], int x){
        HashMap<Integer,Integer> hm1 = new HashMap<>();
        HashMap<Integer,ArrayList<Integer>> hm2 = new HashMap<>();
        for(int i = 0;i<bomb.length;i++){
            int n = bomb[i];
            int cstn = cost[i];
            if(hm1.containsKey(n)){
                hm1.put(n, hm1.get(n)+cstn);
            }else{
                hm1.put(n, cstn);
            }
            if(hm1.containsKey(n)){
                hm2.get(n).add(i);
            }else{
                hm2.put(n, new ArrayList<>(i));
            }
        }  






    }
    

    public static void main(String[] args) {
        
    }
}