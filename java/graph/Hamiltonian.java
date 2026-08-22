import java.util.ArrayList;

public class Hamiltonian {

    // i like hamiltonian more then eular

    public static boolean ishamiltonian(ArrayList<ArrayList<Integer>> aj, int cnt, boolean vis[], int node){
        if(cnt == aj.size()) return true;
        vis[node] = true;
        for (int e : aj.get(node)) {

            if(!vis[e]){
                if(ishamiltonian(aj, cnt+1, vis, node)) return true;
            }
        }
        vis[node] = false;
        return false;
    }

    public static boolean ishamiltoniandp(ArrayList<ArrayList<Integer>> aj, int mask, int node, Boolean dp[][]){
        if(mask == (1<<aj.size())-1) return dp[mask][node] = true;
        if(dp[mask][node] != null) return dp[mask][node];
        for(int e : aj.get(node)){
            if((mask & 1<<e)== 0){
                int newmask = mask | 1<<e;
                if(ishamiltoniandp(aj, newmask, e, dp)) return dp[mask][node] = true;
            }
        }
        return dp[mask][node] = false;
    }

    public static boolean hamiltonioncycle(ArrayList<ArrayList<Integer>> aj, int cnt, boolean vis[], int node, int start){

        if(cnt == aj.size()){
            aj.get(node).contains(start);
        }
        vis[node] = true;
        for(int e : aj.get(node)){
            if(!vis[e] && hamiltonioncycle(aj, cnt+1, vis, e, start)){
                return true;
            }
        }
        vis[node] = false;
        return false;
    }




    public static void main(String[] args) {
        int n = 6;
        int mask = 1<<n;
        int st = 2;
        Boolean dp[][] = new Boolean[n][mask];
        for(int i = 0;i<n;i++){
            if(ishamiltoniandp(null, 1<<st, n, dp)) {
                System.out.println("yes");
                break;
            };
        }
        System.out.println("no");
    }
    
}
