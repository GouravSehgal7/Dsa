package dp;

public class griddp {

    // question :
    // given a grid(m,n) of with value  and -1  reach from (0,0) -> (m,n)
    // conditions : 
    // maximize the cost and return all count one or more which can allw to reach to target
    // movement up to down , left to right -> can directly add the values to the cost
    // movement in diagonal downward -> multiply by value from where it came and then add to cost
    // -1 are obsticals

    public static int solve(int [][]ar, int i, int j , int isdia, int dpcost[][][]){


        int val1 = 0;
        if(i+1<ar.length){
            val1 += solve(ar, i+1, j, 0, dpcost);
        }

        int val2 = 0;
        if(j+1<ar[i].length){
            val2 += solve(ar, i, j+1, 0, dpcost);
        }

        int val3 = 0;
        if(1+i<ar.length && 1+j < ar[i].length){
            val3 += solve(ar, i+1, j+1, 0, dpcost);
        }
















    }



    public static void main(String[] args) {
        int ar[][] = {
            {1,2},
            {3,4},
        };

        Integer dpcost[][][] = new Integer[ar.length+1][ar[0].length+1][2];
        dpcost[0][0][0] = ar[0][0];
        Integer dpcnt[][][] = new Integer[ar.length+1][ar[0].length+1][2];




    }
    
}
