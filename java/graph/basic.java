import java.util.*;
// import java.util.Map; 
public class basic {


    static interface Graph<T,U> {
        void addDirectedEdge(T u,T v, U w);
        void removeEdge(T u, T v);
        boolean hasEdge(T u, T v);
        U getWeight(T u, T v);
        U updateWeight(T u, T v, U w);
        int getVertexCount();
        int getEdgeCount();
        void printGraph();
        void Getneighbour(T vertex);
        void DFS();
        void BFS();
        void Dijastra();
    }

    static class edgeList{
        int u,v,w;
        edgeList(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    // Adjacency List implementation
    static class Edge<T,U> {
        T src;
        T des;
        U weight;

        Edge(T src, T dest, U weight) {
            this.src = src;
            this.des = dest; // destination will be set later
            this.weight = weight;
        }
    }

    static class AdjacencyList<T,U> implements Graph<T,U>{

        private final Map<T, List<Edge<T,U>>> map;


        public AdjacencyList() {
            this.map = new HashMap<>();
        }


        @Override
        public void Dijastra(){

        }

        @Override
        public void addDirectedEdge(T u, T v, U w) {
            map.putIfAbsent(u, new ArrayList<>());
            map.get(u).add(new Edge<>(u, v,w));
            System.out.println("Edge added: " + u + " -> " + v + " with weight " + w);
        }

        @Override
        public void removeEdge(T u, T v) {
            if(!map.containsKey(u)) {
                System.out.println("Does not contain "+u);
            }
            for(Edge<T,U> e : map.get(u)){
                if(e.des.equals(v)){
                   map.get(u).remove(e);
                }
            }
            // if(!hasEdge(u, v)){
            //     System.out.println("does not contain it");
            // }
            // map.get(u).remove(defe);
       
        }
    
        @Override
        public boolean hasEdge(T u, T v) {
            if(!map.containsKey(u)) return false;
            System.out.println(map.get(u));
            for (Edge<T,U> e : map.get(u)) {
                if (e.des.equals(v)) {
                    System.out.println("Edge exists: " + u + " -> " + v);
                    return true;
                }
            }   

            System.out.println("Edge does not exist: " + u + " -> " + v);
            return false;

        }
        
        @Override
        public U getWeight(T u, T v) {
           if(!map.containsKey(u)) return null;
            System.out.println(map.get(u));

            for (Edge<T,U> e : map.get(u)) {
                if (e.des.equals(v)) {
                    System.out.println("Edge exists: " + u + " -> " + v);
                    return e.weight;
                }
            }
            return null;
        }

        @Override
        public int getVertexCount() {
            System.out.println(map.size());
            return map.size();
        }

        @Override
        public int getEdgeCount() {
            int c = 0;
            for(List<Edge<T,U>>e:map.values()){
                c+=e.size();
            }
            return c;
        }

        @Override
        public void printGraph() {
           
        }

        @Override
        public U updateWeight(T u, T v, U w) {
            if(!map.containsKey(u)) return null;
            System.out.println(map.get(u));

            for (Edge<T,U> e : map.get(u)) {
                if (e.des.equals(v)) {
                    System.out.println("Edge exists: " + u + " -> " + v);
                    e.weight = w;
                    return e.weight;
                }
            }
            return null;
        }
    
        @Override
        public void Getneighbour(T vertex){
            for(Edge<T,U> e : map.get(vertex)){
                System.out.println(e.des);
            }
        }
   
        @Override
        public void DFS(){

        } 

        @Override
        public void BFS(){
        //  initialize empty array , queue
        
        // get graph -> map
        // map
        // start from first elem

        // push its value to queue
            // dequeue and get the value of head in queue
            // print its value
            // add its neighbour to queue
            // mark it to visited
            // repeat
        //  visited array is full and queue is empty then visited all otherwise can not be visited

        }
   


    }

    public static void BFS(Map<Integer,List<Edge<Integer,Integer>>> m,int size){
        boolean visited[] = new boolean[size];
        Queue<Integer>q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.println(curr);
            if(visited[curr] == false){
            for(Edge<Integer,Integer> e : m.get(curr)){
                q.add(e.des);
            }
            visited[curr] = true;
        }
        }
    }

    public static void DFS(Map<Integer,List<Edge<Integer,Integer>>> m,int node,boolean visited[]){
        // normal

        // initialize array, stack
        // push 0 in stack
            // get the top most element
                // watch its one neighbout if visited then other neighbour
                // push that to stack
            // print current
            // set visited current
                // if all visited the backtrack and pop one element

        // recursiond
        System.out.println(node);
        visited[node] = true;
         for(Edge<Integer,Integer> e : m.get(node)){

            if(visited[e.des] == true){
                continue;
            }
            DFS(m, e.des, visited);
         }


    }

    public static void Cycle(Map<Integer,List<Edge<Integer,Integer>>> g,int curr,boolean visited[],boolean stackarray[]){
        System.out.println(curr);
        visited[curr] = true;
        stackarray[curr] = true;
        for(Edge<Integer,Integer> e : g.get(curr)){
            if(visited[e.des] == true && stackarray[e.des] == true){
                System.out.println("Cycle exist");
                break;
            }
            Cycle(g, e.des, visited, stackarray);
        }
        
    }
    
    public class MatrixGraph {
        int u,v,w;
        ArrayList<ArrayList<Integer>> am = new ArrayList<>();
        MatrixGraph(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
            // Initialize adjacency matrix
            for (int i = 0; i <u;i++){
                am.add(new ArrayList<>());
                for (int j = 0; j < v; j++) {
                    am.get(i).add(0);
                }
            }
        }
    }

    public static void main(String[] args) {
        // edge list
        // edgeList[] edges = {
        //     new edgeList(0, 1, 10),
        //     new edgeList(0, 2, 6),
        //     new edgeList(0, 3, 5),
        //     new edgeList(1, 3, 15),
        //     new edgeList(2, 3, 4),
        // };
        // for(int i = 0 ; i<edges.length;i++){
        //     System.out.println("Edge " + i + ": " + edges[i].u + " -> " + edges[i].v + " with weight " + edges[i].w);
        // }

        // ArrayList<edgeList> edgeListArray = new ArrayList<>();
        // edgeListArray.add(new edgeList(0, 1, 10));
        // edgeListArray.add(new edgeList(1, 2, 20));
        // edgeListArray.add(new edgeList(2, 3, 30));
        // for(edgeList e : edgeListArray) {
        //     System.out.println("Edge: " + e.u + " -> " + e.v + " with weight " + e.w);
        // }
    
        // adjacency list
        Graph<Integer,Integer> graph = new AdjacencyList<>();
        graph.addDirectedEdge(0, 2, 22);
        // graph.addDirectedEdge("A", "B", 9);
        // graph.addDirectedEdge("A", "C", 6);
        // graph.addDirectedEdge("B", "C", 2);
        // // boolean t = graph.hasEdge("A", "B");
        // graph.Getneighbour("A");
        // graph.removeEdge("A", "B");
        // boolean u = graph.hasEdge("A", "B");
        // System.out.println("before removing "+t);
        // System.out.println("before removing "+u);
        // int v = graph.updateWeight("A", "C", 100);
        // System.out.println(v);
    }
}