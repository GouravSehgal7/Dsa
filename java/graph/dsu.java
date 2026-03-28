
import java.util.ArrayList;
public class dsu {

    public class DisjointSetunionRank{
        ArrayList<Integer> rank;
        ArrayList<Integer> parent;
        DisjointSetunionRank(int edgesnum){
            this.rank = new ArrayList<>();
            this.parent = new ArrayList<>();
            for(int i = 0; i <= edgesnum; i++){
                this.parent.add(i);
                this.rank.add(0);
            }
        }

        public int findUparent(int node){
            if (node == this.parent.get(node)) {
                return node;
            }
            this.parent.set(node, findUparent(node));
            return parent.get(node);
        }

        public void UnionByRank(int u, int v){
            int pu = findUparent(u);
            int pv = findUparent(v);
            if(pu == pv) return;
            if(rank.get(pu) < rank.get(pv)){
                parent.set(pu, pv);
            } else if(rank.get(pu) > rank.get(pv)){
                parent.set(pv, pu);
            } else {
                parent.set(pv, pu);
                rank.set(pu, rank.get(pu) + 1);
            }
        }
    }
 
    public static class  DisjointSetunionSize {
        ArrayList<Integer> size;
        ArrayList<Integer> parent;
        DisjointSetunionSize(int edgesnum){
            this.size = new ArrayList<>();
            this.parent = new ArrayList<>();
            for(int i = 0; i <= edgesnum; i++){
                this.parent.add(i);
                this.size.add(0);
            }
        }

        public int findUparent(int node){
            if (node == this.parent.get(node)) {
                return node;
            }
            this.parent.set(node, findUparent(node));
            return parent.get(node);
        }

        public void UnionBySize(int u , int v){
            int pu = findUparent(u);
            int pv = findUparent(v);
            if(pu == pv) return;
            if(size.get(pu) < size.get(pv)){
                parent.set(pu, pv);
                size.set(pv, size.get(pv)+1);
            } else if(size.get(pu) >= size.get(pv)){
                parent.set(pv, pu);
                size.set(pu, size.get(pu)+1);
            }
        }
    }

    public class DSU {
        ArrayList<Integer> parent;
        ArrayList<Integer> rank;
        ArrayList<Integer> size;
        DSU(int numofedges){
            this.parent = new ArrayList<>();
            this.rank = new ArrayList<>();
            this.size = new ArrayList<>();
            for(int i = 0;i<numofedges;i++){
                this.parent.set(i, i);
                this.rank.set(i, 0);
                this.size.set(i, 1);
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


    public static void main(String[] args) {
        
    }
}
