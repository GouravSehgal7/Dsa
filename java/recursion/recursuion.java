import java.util.ArrayList;

public class recursuion {


    // take or skip
    public static void allsequence(int arr[], ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int i){
        if(i >= arr.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(arr[i]);
        allsequence(arr, res, temp, i+1);
        temp.remove(temp.size()-1);
        allsequence(arr, res, temp, i+1);
    }

    // all possible subsets withh loop
    public static void allsubset(int arr[],ArrayList<ArrayList<Integer>> res , ArrayList<Integer> temp, int i){
        res.add(new ArrayList<>(temp));
        for(int x = i;x<arr.length;x++){
            temp.add(arr[x]);
            allsubset(arr, res, temp, x+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void allsubset1(int arr[], ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int i){

    }


    public static void allPermutation(int arr[]){


    }

    public static void main(String[] args) {

        int arr[] = {1,2,3,4};

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        

        allsubset(arr, res, new ArrayList<>(), 0);
        for(ArrayList<Integer> ar : res){
            System.out.println(ar.toString());
        }

        
    }


    
}
