package graph;

import java.util.ArrayList;

public class dsu {

    public  class DisjointSetunionRank {
        ArrayList<Integer> rank;
        ArrayList<Integer> parent;
        ArrayList<Integer> size;
        DisjointSetunionRank(int n){
            this.rank = new ArrayList<>();
            this.parent = new ArrayList<>();
            this.size = new ArrayList<>();
            for(int i = 0;i<=n;i++){
                this.rank.add(i,0);
                this.size.add(i,1);
                this.parent.add(i,i);
            }
        } 
        public int findUpair(int node){
            if (node == this.parent.get(node)) {
                return node;
            }
            this.parent.set(node, findUpair(node));
            return parent.get(node);
        }
        public void UnionByRank(int u,int v){
            int ulp_u = findUpair(u);
            int ulp_v = findUpair(v);
            if (ulp_u == ulp_v) return;
            if (this.rank.get(u)<this.rank.get(ulp_v)) {
                this.parent.set(ulp_u,ulp_v);
            }else if (this.rank.get(u)>this.rank.get(ulp_v)) {
                this.parent.set(ulp_v,ulp_u);
            }else{
                this.parent.set(ulp_v, ulp_u);
                this.rank.set(ulp_u, ulp_u+1);
            }
        }
        public void UnionBySize(int u,int v){
            int ulp_u = findUpair(u);
            int ulp_v = findUpair(v);
            if (ulp_u==ulp_v) {
                return;
            }
            if (this.size.get(ulp_u)<this.size.get(ulp_v)) {
                this.parent.set(ulp_u, ulp_v);
                // this.size.set(ulp_v, ulp_v)
            }
        }
    }
    
    
    public static void main(String[] args) {
        
    }
}
