import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. input : vertex number, edge number, edge's weight
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine()) - 1;

        // 2. initialize graph, distance
        graph = new ArrayList[V];
        dist = new int[V];

        for(int i = 0; i<V; i++) {
            graph[i] = new ArrayList<Node>();
            dist[i] = Integer.MAX_VALUE;
        }

        // 3. input u, v, w : u -> v의 가중치
        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }
        
        // dijkstra algorithm
        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<V; i++){
            if(dist[i] == Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(dist[i]).append("\n");
        }

        System.out.print(sb);
    }

    static void dijkstra(int start){
    	// 1. PriortiyQueue settings
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        // 2. dijkstra settings
        while(!pq.isEmpty()) {
        	int nowVertex = pq.poll().vertex;
        	
        	for(Node next : graph[nowVertex]) {
        		if(dist[next.vertex] > dist[nowVertex] + next.weight) {
        			dist[next.vertex] = dist[nowVertex] + next.weight;
        			pq.add(new Node(next.vertex, dist[next.vertex]));
        		}
        	}
        }
    }
    static class Node implements Comparable<Node>{
        int vertex, weight;

        public Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n){
            return this.weight - n.weight;
        }
    }
}
