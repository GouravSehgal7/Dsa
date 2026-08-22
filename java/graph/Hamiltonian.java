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

    public static int cntpath(ArrayList<ArrayList<Integer>> aj, int mask, int node, Integer dp[][]){
        if(mask == (1<<aj.size())-1){
            return 1;
        }
        if(dp[mask][node] != null) return dp[mask][node];
        dp[mask][node] = 0;
        for(int e : aj.get(node)){
            if((mask & 1<<e) == 0){
                int nmask = mask | 1<<e;
                dp[mask][node] += cntpath(aj, nmask, e, dp);
            }
        }
        return dp[mask][node];
    }

    public static int minpathwithhamiltonian(ArrayList<ArrayList<int[]>> aj, int mask, int node, Integer dp[][]){
        if(mask == (1<<aj.size())-1){
            return 0;
        }
        if(dp[mask][node] != null) return dp[mask][node];
        int ans = Integer.MAX_VALUE;
        for(int e[] : aj.get(node)){
            int next = e[0];
            int wt = e[1];
            if((mask & 1<<next )== 0){
                int newmask = mask | 1<< next;
                int val = minpathwithhamiltonian(aj, newmask, next, dp);
                ans = Math.min(ans, val+wt);
            }
        }
        return dp[mask][node] = ans;
    }


    public static void main(String[] args) {
        int n = 6;
        int mask = 1<<n;
        int st = 2;
        Integer dp[][] = new Integer[n][mask];
        for(int i = 0;i<n;i++){
            int cnt = cntpath(null, 1<<st, n, dp);
        }
        System.out.println("no");
    }
    
}
