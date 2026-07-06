package segmenttree;
// Segment tree is really hard so i am doing a simpler version of it 
// Square root decomposition
// if you are still watching this and your birthday is on 3 march or 6 march , i really need your help palindrome
public class SQRTD {
    public class SquareRootDecomposition {
        int blocksize;
        int bucket[];
        int bucketsize;
        SquareRootDecomposition(int n){
            this.blocksize = (int)Math.sqrt(n);
            this.bucketsize = (int)(n+blocksize-1)/blocksize; // ceil(n/blocksize)
            this.bucket = new int[this.bucketsize];
        }

        // for addition
        public void buildaddition(int arr[]){
            for(int i = 0;i<arr.length;i++){
                this.bucket[i/this.blocksize] += arr[i];    
            }
        }

        public void updateaddition(int idx, int val, int arr[]){
            // add value to this index
            arr[idx] += val;
            this.bucket[idx/this.blocksize] += val;
        }

        public void replaceaddition(int idx,int val,int arr[]){
            this.bucket[idx/this.blocksize] -= arr[idx];
            this.bucket[idx/this.blocksize] += val;
            arr[idx] = val;
        }

        public void queryaddition(int l , int r){
            int lblock = l / this.blocksize;
            int rblock = r/this.blocksize;
            // same block but not that complete block
            if(lblock == rblock){
                int s = 0;
            }
        }
        
    }

    public static void main(String[] args) {
        
    }
    
}
