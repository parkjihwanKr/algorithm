import java.util.*;
import java.io.*;

public class Main{
    static ArrayList[] l;
    static int[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine()) - 1;

        l = new ArrayList[V];
        dist = new int[V];

        for(int i = 0; i<V; i++) {
            l[i] = new ArrayList<Node>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            l[u].add(new Node(v, w));
        }

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
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int nowVertex = node.vertex;
            int nowWeight = node.weight;
            int len = l[nowVertex].size();
            for(int i = 0; i<len; i++){
                Node next = (Node)l[nowVertex].get(i);

                if(dist[next.vertex]>nowWeight + next.weight){
                    dist[next.vertex] = nowWeight + next.weight;
                    pq.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
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