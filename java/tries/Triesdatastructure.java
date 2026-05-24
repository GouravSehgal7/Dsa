package tries;

public class Triesdatastructure {

    public class Node {
        Node []data ;
        boolean last ;
        Node(){
            this.data = new Node[27];
            this.last = false;
        }
    }


    public interface TriesOperation {
        // ["akj","huv","jnow","hicu"]
        void Create(String []arr1);
        // largest prefix prefix pattern
        void Searchpatter(String ptrn);
        
    }

    public class Tries implements TriesOperation {
        public Node root;
        Tries(){
            this.root = new Node();
        }

        @Override
        public void Create(String []arr){
            if(arr.length == 0) return;
            for(String s : arr){
                for(int i = 0;i<s.length();i++){

                }
            }
        }

        @Override
        public void Searchpatter(String ptrn){
            return;
        }

    }


    public static void main(String[] args) {
        
    }
    
}
