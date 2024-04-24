import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Node>[] computers;
    static int[] distance;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken()) - 1;

            computers = new ArrayList[N];
            for(int j = 0; j < N; j++) {
                computers[j] = new ArrayList<Node>();
            }

            for(int j = 0; j < D; j++) {
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int s = Integer.parseInt(st.nextToken());
                computers[b].add(new Node(a, s));
            }

            int[] result = dijkstra(C);
            System.out.println(result[0] + " " + result[1]);
        }
    }

    static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        distance = new int[N];
        final int INF = Integer.MAX_VALUE;
        Arrays.fill(distance, INF);
        distance[start] = 0;

        int maxTime = 0;
        int infectedCount = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if (distance[now.index] < now.cost) continue;

            for(Node next : computers[now.index]) {
                if(distance[next.index] > distance[now.index] + next.cost) {
                    distance[next.index] = distance[now.index] + next.cost;
                    pq.add(new Node(next.index, distance[next.index]));
                }
            }
        }

        for (int dist : distance) {
            if (dist != INF) {
                infectedCount++;
                if (dist > maxTime) {
                    maxTime = dist;
                }
            }
        }

        return new int[] { infectedCount, maxTime };
    }

    static class Node implements Comparable<Node> {
        int index, cost;
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
}
