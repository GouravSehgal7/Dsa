import java.util.ArrayList;

public class kcolouring {


    public static boolean bipertite(int n , ArrayList<ArrayList<Integer>> ar, Integer color[]){
        if(color[n] == null){
            color[n] = 0;
        }
        for(int e : ar.get(n)){
            if(color[e] == null){
                color[e] = 1-color[n];
                if(!bipertite(e, ar, color)){
                    return false;
                }
            }else{
                if(color[e] == color[n]) return false;
            }
        }
        return true;
    }

    public static boolean bipertite2(int n , Integer color[] ,ArrayList<ArrayList<Integer>> ar){
        if(color[n] == null) color[n] = 0;
        for(int e : ar.get(n)){
            if(color[e] == null){
                color[e] = 1-color[n];
                if(!bipertite2(e, color, ar)){
                    return false;
                }
            }else if(color[e]==color[n]) return false;
        }
        return true;
    }



    public static boolean kcolorpossible(int i , int n , ArrayList<ArrayList<Integer>> ar , Integer color[], int k){
        if(i==n-1) return true;
        for(int j = 0;j<k;j++){
            boolean issafe= false;
            for(int e : ar.get(n)){
                if(color[e]!=null && color[e] == j){
                    issafe = false;
                    break;
                }
            }
            if(issafe){
                color[i] = j;
                if(kcolorpossible(i+1, n, ar, color, k)){
                    return true;
                }
                color[i] = null;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        
    }
    
}
