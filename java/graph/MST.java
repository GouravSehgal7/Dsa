import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MST {

    class MSTResult{
        int cost;
        ArrayList<int[]> ar;
        MSTResult(int cost,ArrayList<int[]> ar){
            this.cost = cost;
            this.ar = ar;
        }
    }
    
    class DSU {
        ArrayList<Integer> parent;
        ArrayList<Integer> rank;
        ArrayList<Integer> size;
        DSU(int numofedges){
            this.parent = new ArrayList<>();
            this.rank = new ArrayList<>();
            this.size = new ArrayList<>();
            for(int i = 0;i<numofedges;i++){
                parent.add(i);
                rank.add(0);
                size.add(1);
            }
        }

        public int FindParent(int node){
            if(parent.get(node) != node){
                parent.set(node, FindParent(parent.get(node)));
            }
            return parent.get(node);
        }

        public void UnionByRank(int u,int v){
            // while unioon we will not union u,v rather union their parent 
            int pu = FindParent(u);
            int pv = FindParent(v);
            // if both have same parent then return 
            if(pu == pv) return;
            // union based on their rank
            if(this.rank.get(pu) > this.rank.get(pv)){
                this.parent.set(pv, pu);
            }else if(this.rank.get(pu) < this.rank.get(pv)){
                this.parent.set(pu, pv);
            }else if(this.rank.get(pu) == this.rank.get(pv)){
                this.parent.set(pu, pv);
                this.rank.set(pv, this.rank.get(pv)+1);
            }
        }
    
        public void UnionBySize(int u , int v){
            int pu = FindParent(u);
            int pv = FindParent(v);
            if(pu == pv) return;
            if(this.size.get(pu) > this.size.get(pv)){
                this.parent.set(pv, pu);
                this.size.set(pu, this.size.get(pv)+this.size.get(pu));
            }else if(this.size.get(pu) <= this.size.get(pv)){
                this.parent.set(pu, pv);
                this.size.set(pv, this.size.get(pv)+this.size.get(pu));   
            }
        }

    }
    
    public void AdjacentList(int [][]edges, ArrayList<ArrayList<int[]>> adj){
         for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{w,v});
            adj.get(v).add(new int[]{w,u});
        }
    }
    
    public MSTResult Prims(ArrayList<ArrayList<int[]>> adj,int V){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[] inMst = new boolean[V];
        ArrayList<int []> MstEdges = new ArrayList<>();
        // [w,u,v];
        pq.add(new int[]{0,-1,0});
        int cost = 0;
        while(!pq.isEmpty()){
            int val[] = pq.poll();
            int u = val[1];
            int v = val[2];
            int w = val[0];
            if(!inMst[v]){
                inMst[v] = true;
                if(u != -1){
                    MstEdges.add(new int[]{u,v});
                }
                cost+=w;
            }else{
                continue;
            }
            for(int i = 0;i<adj.get(v).size();i++){
                pq.add(new int[]{adj.get(v).get(i)[0],v,adj.get(v).get(i)[1]});
            }
        }
        return new MSTResult(cost,MstEdges);
    }
    
    
    
    public MSTResult Kuskruls(int V, int[][]edges){
        // sort
        Arrays.sort(edges,(a,b)->Integer.compare(a[2], b[2]));
        DSU mst = new DSU(V);
        int cost = 0;
        ArrayList<int []> MstEdges = new ArrayList<>();
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            if(mst.FindParent(u)!=mst.FindParent(v)){
                mst.UnionBySize(u,v);
                cost+=w;
                MstEdges.add(new int[]{u,v});
            }
        }
        return new MSTResult(cost,MstEdges);
    }
    
    public int spanningTree(int V, int[][] edges) {
        // ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        // for (int i = 0; i < V; i++) {
        //     adj.add(new ArrayList<>());
        // }
        // AdjacentList(edges,adj);
        // MSTResult p = Prims(adj,V);
        // System.out.println(p.ar.toString());
        return Kuskruls(V,edges).cost;
    }


    public static void main(String[] args) {
        
    }
    
}
