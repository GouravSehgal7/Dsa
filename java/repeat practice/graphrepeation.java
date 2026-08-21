import java.util.ArrayList;
import java.util.Arrays;

import dp.maskeddp;

public class graphrepeation {

    // 2-8-2026
    public class DsuRepeat1 {
        int parent[] ;
        int size[];
        DsuRepeat1(int n){
            this.parent =new int[n];
            this.size = new int[n];
            for(int i = 0;i<n;i++){
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }

        public int find(int x){
            if(this.parent[x] == x) return x;
            int v = find(this.parent[x]);
            this.parent[x] = v;
            return v;
        }

        public void union(int u,int v){
            int pu = find(u);
            int pv = find(v);
            if(pu == pv) return;
            if(this.size[pu]>this.size[pv]){
                this.parent[pv] = pu;
                this.size[pu]+=this.size[pv];
            }else if(this.size[pu]<this.size[pv]){
                this.parent[pu] = pv;
                this.size[pv]+=this.size[pu];
            }else{
                this.parent[pu] = pv;
                this.size[pv]+=this.size[pu];
            }
        }
    }
    
    public class  DSUREP2{
        int parent[];
        int size[];
        DSUREP2(int n){
            this.parent = new int[n];
            this.size = new int[n];
            for(int i = 0;i<n;i++){
                this.parent[i] = i;
                this.size[i]  = 1;
            }
        }

        public int find(int x){
            if(this.parent[x] == x) return x;
            int v = find(this.parent[x]);
            parent[x] = v;
            return v;
        }

        public void union(int u, int v){
            int pu = find(u);
            int pv = find(v);
            if(pu == pv) return;
            if(this.size[pu]>=this.size[pv]){
                this.size[pu]+=this.size[pv];
                this.parent[pv] = pu;
            }else if(this.size[pu]<this.size[pv]){
                this.size[pv]+=this.size[pu];
                this.parent[pu] = pv;
            }
        }
    }


    public class DSUREP3 {
        ArrayList<Integer> parent;
        ArrayList<Integer> size;
        DSUREP3(int n){
            this.parent = new ArrayList<>();
            this.size = new ArrayList<>();
            for(int i = 0;i<=n;i++){
                this.parent.add(i);
                this.size.add(0);
            }
        }
        public int find(int x){
            if(this.parent.get(x) == x)return x;
            int v = find(this.parent.get(x));
            this.parent.set(x, v);
            return v;
        }

        public void union(int u, int v){
            int pu = find(u);
            int pv = find(v);
            if(pu == pv) return;
            if(this.size.get(pu)>=this.size.get(pv)){
                this.size.set(pu, this.size.get(pu)+this.size.get(pv));
                this.parent.set(pv, pu);
            }else if(this.size.get(pu)<this.size.get(pv)){
                this.size.set(pv, this.size.get(pu)+this.size.get(pv));
                this.parent.set(pu, pv);
            }
        }
    }

    public class dsuRep4{
        int parent[];
        int size[];
        dsuRep4(int n){
            this.parent = new int[n];
            this.size = new int[n];
            for(int i = 0;i<n;i++){
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }

        public int find(int x){
            if(parent[x] == x) return x;
            int b = find(parent[x]);
            parent[x] = b;
            return b;
        }

        public void union(int u, int v){
            int pu = find(u);
            int pv = find(v);
            if(pu == pv ) return;
            if(size[pu] >= size[pv]){
                size[pu]+=size[pv];
                parent[pv] = pu;
            }else{
                size[pv]+=size[pu];
                parent[pv] = pu;
            }

        }
    }

    class MSTResult{
        int cost;
        ArrayList<int[]> ar;
        MSTResult(int cost,ArrayList<int[]> ar){
            this.cost = cost;
            this.ar = ar;
        }
    }

    public  MSTResult kuskrulsrep1(int V , int edges[][]){
        // [[u,v,w]]
        Arrays.sort(edges,(a,b)->Integer.compare(a[2], b[2]));
        dsuRep4 d = new dsuRep4(V);
        int cost = 0;
        ArrayList<int []> MstEdges = new ArrayList<>();
        for(int e[]:edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            if(d.find(u)!=d.find(v)){
                d.union(u, v);
                cost+=w;
                MstEdges.add(new int[]{u,v});
            }
        }
        return new MSTResult(cost, MstEdges);
    }

    public MSTResult kuskrep2(int V,int edges[][]){
        DSUREP2 d = new DSUREP2(V);
        int cost = 0;
        Arrays.sort(edges,(a,b)->Integer.compare(a[2], b[2]));
        ArrayList<int[]> ar = new ArrayList<>();
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            if(d.find(u)!=d.find(v)){
                d.union(u, v);
                cost+=w;
                ar.add(new int[]{u,v});
            }
        }
        return new MSTResult(cost, ar);
    }


    public MSTResult kuskrep3(int V,int edges[][]){
        DSUREP2 d = new DSUREP2(V);
        int cost = 0;
        ArrayList<int []> ar = new ArrayList<>();
        Arrays.sort(edges,(a,b)->Integer.compare(a[2], b[2]));
        for(int e[]:edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            if(d.find(u)!=d.find(v)){
                d.union(u, v);
                cost+=w;
                ar.add(new int[]{u,v});
            }
        }
        return new MSTResult(cost, ar);
    }

    // 
    public void ballmanford1(int n , int edgelist[][]){

    }

}
