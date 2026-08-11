package segmenttree;
// the moment i decided i will not cover this topic even by mistake
// my fucking life decided to taught me a lesson 
// and i got question of segmenttree in my five different OA
// if you are watching this and your birthday is on 3 march or 6 march , i need your help palindrome
public class St {

    public class SumSegmentTree{
        
        int tree[];
        int arr[];
        SumSegmentTree(int n,int arr[]){
            this.tree = new int[4*n];
            this.arr = arr;
            this.build(0, 0, arr.length-1);
        }

        public void build(int i , int l, int r){
            if(l == r){
                this.tree[i] = this.arr[l];
                return;
            } 
            int mid = (l+r)/2;
            build(2*i+1, l, mid);
            build(2*i+2, mid+1, r);
            this.tree[i] = this.tree[2*i+1]+this.tree[2*i+2];
        }

        public int query(int i, int l , int r , int ql , int qr){
            // non overlaping
            if(ql>r || qr<l){
                return 0;
            }
            // complete overlaping 
            if(ql<=l && r <= qr){
                return this.tree[i];
            }
            // partial overlap
            int mid = (l+r)/2;
            int left = query(i, l, mid, ql, qr);
            int right = query(i, mid+1, r, ql, qr);
            return left+right;
        }

        public void updatepoint(int i , int l , int r , int pos , int val){
            if(l == r){
                this.tree[i] = val;
                this.arr[r] = val;
                return;
            }
            int mid = (l + r) / 2;
            if(pos <= mid){
                updatepoint(2*i+1, l, mid, pos, val);
            }else{
                updatepoint(2*i+2, mid+1, r, pos, val);
            }
            tree[i] = tree[2*i+1] + tree[2*i+2];
        }
    }

    public class MinSegmentTree{
        int tree[];
        int arr[];
        MinSegmentTree(int n, int arr[]){
            this.tree = new int[4*n];
            this.arr = arr;
            this.build(0, 0, n-1);
        }
        public void build(int i , int l , int r){
            if(l == r){
                tree[i] = arr[l];
                return;
            }
            int mid = (l+r)/2;
            build(2*i+1, l, mid);
            build(2*i+2, mid+1, r);
            tree[i] = Math.min(tree[2*i+1],tree[2*i+2]);
        }

        public int query(int i , int l , int r , int ql , int qr){
            // non overlap
            if(ql>r || qr<l) return Integer.MAX_VALUE;
            // complete overlap
            if(ql<=l && r<=qr) return tree[i];
            // partial overlap
            int mid= (l+r)/2;
            int left = query(2*i+1, l, mid, ql, qr);
            int right = query(2*i+2, mid+1, r, ql, qr);
            return Math.min(left, right);
        }

        public void update(int i, int l , int r ,int pos , int val){
            if (l == r) {
                arr[l] = val;
                tree[i] = val;
                return;
            }
            // binary search
            int mid = (l+r)/2;
            if(pos<=mid){
                update(i*2+1, l, mid, pos, val);
            }else{
                update(i*2+2,mid+1,r, pos, val);
            }
            tree[i] = Math.min(tree[2*i+1],tree[2*i+2]);
        }
    }
    public static void main(String[] args) {
        
    }
    
}
