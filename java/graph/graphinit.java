package graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class graphinit {

    public static class Graph {
        
        int v;
        ArrayList<ArrayList<Integer>> ar;
        Graph(int data){
            this.v = data;
            this.ar = new ArrayList<>();
            for(int i = 0;i<this.v;i++){
                this.ar.add(new ArrayList<>());
            }
        }

        public void AddEdge(int u , int v){
            this.ar.get(u).add(v);
            this.ar.get(v).add(u);
        }

        public void printGraph() {
            for (int i = 0; i < this.v; i++) {
                System.out.println(i + " -> " + this.ar.get(i));
            }
        }

        public void bfs(){
            Queue<Integer> q = new LinkedList<>();
            ArrayList<Boolean> visited = new ArrayList<>();
            q.add(0);
            visited.set(0, true);
            while (!q.isEmpty()) {
                int d = q.poll();
                System.out.println(d);
                for (int v : this.ar.get(d)) {
                    visited.set(v, true);
                    q.add(v);
                }
            }
        }

        public void dfs(int v,ArrayList<Boolean>visited){
            System.out.println(v);
            visited.set(v, true);
            for(int i : this.ar.get(v)){
                if(!visited.get(i)){
                    dfs(i, visited);
                }
            }
        }
    }


    public static class Edge{
        int to ;
        int wt;
        Edge(int v , int wt){
            this.to = v;
            this.wt = wt;
        }
    }

    public static class WGraph{
        int v ;
        ArrayList<ArrayList<Edge>> ar;
        WGraph(int v){
            this.v = v;
            this.ar = new ArrayList<>();
            for(int i = 0;i<this.v;i++){
                this.ar.add(new ArrayList<>());
            }
        }

        public void AddEdge(int from, int to , int wt){
            this.ar.get(from).add(new Edge(to, wt));
        }

        public static class Pair{
            int dist;
            int src;
            Pair(int dist,int src){
                this.dist = dist;
                this.src = src;
            }
        }

        public int[] dijastra(int src){
            PriorityQueue<Pair> max = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.dist, b.dist)
            );
            int dist[] = new int[this.v];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;
            max.add(new Pair(dist[src], src));
            while (!max.isEmpty()) {
                Pair p = max.poll();
                int d = p.dist;
                int u = p.src;
                if(d>dist[u]){
                    continue;
                }
                for(int i = 0;i<this.ar.get(u).size();i++){
                    Edge v = this.ar.get(u).get(i);
                    if(d+v.wt<dist[v.to]){
                        dist[v.to] = d+v.wt;
                        max.add(new Pair(dist[v.to],v.to));
                    }
                }
            }
            return dist;
        }
    
    
        public int[] BallmenFord(int src){
            int dist[] = new int[this.v];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;
            for(int i = 0;i<this.v-1;i++){
                for(int u = 0;u<this.v;u++){
                    for (Edge e : this.ar.get(u)) {
                        if(dist[e.to]>dist[u]+e.wt){
                            dist[e.to]=dist[u]+e.wt;
                        }
                    }
                }
            }
            return dist;
        }
    
    }




    public static void main(String[] args) {
        // Graph g = new Graph(5);
        // g.AddEdge(0,4);
        // g.AddEdge(4, 1);
        // g.AddEdge(1, 2);
        // g.AddEdge(1, 3);
        // g.AddEdge(2,3);
        // g.printGraph();
        WGraph g = new WGraph(6);
        g.AddEdge(0, 1, 2);
        g.AddEdge(0, 2, 4);
        g.AddEdge(1, 3, -7);
        g.AddEdge(1, 2, 1);
        g.AddEdge(2, 4, 3);
        g.AddEdge(4, 3, -2);
        g.AddEdge(3, 5, 1);
        g.AddEdge(4, 5, 5);
        int[]a = g.BallmenFord(0);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
