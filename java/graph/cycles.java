import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class cycles {

    // undirected -> dfs , dsu + parent
    // directed khans algo , dfs + parent path

    // undirected
    public class DSU{
        int parent[];
        int size[];
        DSU(int n){
            this.parent = new int[n];
            this.size = new int[n];
            for(int i = 0;i<n;i++){
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }

        public int findparent(int x){
            if(x == this.parent[x]) return x;
            int u = findparent(this.parent[x]);
            this.parent[x] = u;
            return this.parent[x];
        }

        public boolean union(int u , int v){
            int pu = findparent(u);
            int pv = findparent(v);
            if(pu == pv) return true;
            if(this.size[pu]>=this.size[pv]){
                this.size[pu] += this.size[pv];
                this.parent[pv] = pu;
            }else{
                this.size[pv] += this.size[pu];
                this.parent[pu] = pv;
            }
            return false;
        }

        public boolean cycledetect(int edge[][]){
            for(int e[] : edge){
                int u = e[0];
                int v = e[1];
                if(union(u, v)) return true;
            }
            return false;
        }
    }
    public static boolean dfscycle(ArrayList<ArrayList<Integer>> ar, int parent, boolean vis[], int n){
        vis[n] = true;
        for(Integer e : ar.get(n)){
            if( e == parent) continue;
            if(vis[e]) return true;
            if(dfscycle(ar, n, vis, e)){
                return true;
            }
        }
        return false;
    }



    // directed

    public static int[] indegree(int n , ArrayList<ArrayList<Integer>> adj){
        int res[] = new int[n];
        for(int i = 0;i<n;i++){
            for(int e : adj.get(i)){
                res[e]++;
            }
        }
        return res;
    }
    public static boolean khans(ArrayList<ArrayList<Integer>> adj){
        int n = adj.size();
        int r[] = indegree(n, adj);
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (r[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int v = q.poll();
            for(int w : adj.get(v)){
                r[w]--;
                if(r[w] == 0) q.add(w);
            }
            result.add(v);
        }
        return result.size() != n;
    }
    public static boolean cycledfs(ArrayList<ArrayList<Integer>> adj, int n, boolean vis[], boolean par[]){
        vis[n] = true;
        par[n] = true;
        for(int e : adj.get(n)){
            if(vis[e] && par[e]) return true;
            if(vis[e]) continue;
            if(cycledfs(adj, e, vis, par)){
                return true;
            }
        }
        par[n] = false;
        return false;
    }


    public static void main(String[] args) {
        
    }
    
}
