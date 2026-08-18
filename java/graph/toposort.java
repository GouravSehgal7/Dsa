package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class toposort {

    public static void Topo(int adj[][], Stack<Integer> st, boolean vis[], int n){
        vis[n] = true;
        for(int neb : adj[n]){
            Topo(adj, st, vis, neb);
        }
        st.push(n);
    }

    public static void Topo2(int n , int adj[][], boolean vis[], Stack<Integer> st){
        vis[n] = true;
        for(int neb : adj[n]){
            if(!vis[neb]) Topo2(neb, adj, vis, st);
        }
        st.push(n);   
    }

    // [
    //     [1,2,3],
    //     [2,4,5],
    //     [0],
    // ]
    // 0-n
    public static int[] indegree(int n, int adj[][]){
        int indeg[] = new int[n];
        int outedg[] = new int[n];
        for(int i = 0 ;i<n;i++){
            int neb[] = adj[i];
            outedg[i] = neb.length;
            for(int k : neb){
                indeg[k]++;
            }
        }
        return indeg;
    }
    public static ArrayList<Integer> khan1(int n,int adj[][]){
        int ind[] = indegree(n,adj);
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ar = new ArrayList<>();
        for(int i = 0;i<ind.length;i++){
            if(ind[i] == 0){
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int c = q.poll();
            // neighbour
            for(int neb :adj[c]){
                ind[neb]--;
                if(ind[neb] == 0) q.add(neb);
            }
            ar.add(c);
        }
        if (ar.size() != n) {
            return new ArrayList<>();
        }
        return ar;
    }
    

    // cycle detection in directed also work hare
    public static int[] indeg2(int n , ArrayList<ArrayList<Integer>> ar){
        int ind[] = new int[n];
        for(ArrayList<Integer> e : ar){
            for(Integer w : e){
                ind[w]++;
            }
        }
        return ind;
    }
    public static ArrayList<Integer> khan2(int n , ArrayList<ArrayList<Integer>> ar){
        int id[] = indeg2(n, ar);
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0;i<id.length;i++){
            if(id[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int p = q.poll();
            for(Integer e : ar.get(p)){
                id[e]--;
                if(id[e] == 0) q.add(e);
            }
            res.add(p);
        }
        if(res.size() != n) return new ArrayList<>();
        return res;
    }


    






    public static void main(String[] args) {
        
    }
}
