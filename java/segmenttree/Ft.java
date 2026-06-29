package segmenttree;
// the moment i decided i will not cover this topic even by mistake
// my fucking life decided to taught me a lesson 
// and i got question of Binary Index Tree in my leetcode podt and broke my 13 days streak
// if you are watching this and your birthday is on 3 march or 6 march , i need your help palindrome
public class Ft {
    public class FenwikTree {
        int n;
        long bit[];
        FenwikTree(int n){
            this.n = n;
            this.bit = new long[n+1];
        }

        public void update(int idx,int val){
            idx++;
            while (idx<=this.n) {
                this.bit[idx] += val;
                idx+=(idx & -idx);
            }
        }

        // give sum upto [1 - idx]
        public long query(int idx){
            idx++;
            long sum = 0;
            while (idx>0) {
                sum+=this.bit[idx];
                idx-=(idx&-idx);
            }
            return sum;
        }
        // log n
        public long query(int l,int r){
            if(l == 0) return query(r);
            return query(r)-query(l-1);
        }
        // n log(n)
        public void build(int arr[]){
            for(int i = 0;i<arr.length;i++){
                update(i, arr[i]);
            }
        }
        // log n
        public void replace(int idx, int newval,int arr[]){
            update(idx, -arr[idx]);
            arr[idx] = newval;
            update(idx, arr[idx]);
        }
    }
}