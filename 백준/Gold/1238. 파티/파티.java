import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Node>[] map, reverseMap;
    static int[] toX, fromX;
    static int N, M, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;

        int INF = Integer.MAX_VALUE;
        map = new ArrayList[N];
        reverseMap = new ArrayList[N];
        toX = new int[N];
        fromX = new int[N];
        Arrays.fill(toX, INF);
        Arrays.fill(fromX, INF);
        for (int i = 0; i < N; i++) {
            map[i] = new ArrayList<>();
            reverseMap[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int time = Integer.parseInt(st.nextToken());
            map[start].add(new Node(end, time));
            reverseMap[end].add(new Node(start, time));
        }

        dijkstra(toX, map, X);
        dijkstra(fromX, reverseMap, X);

        int maxTime = 0;
        for (int i = 0; i < N; i++) {
            maxTime = Math.max(maxTime, toX[i] + fromX[i]);
        }

        System.out.println(maxTime);
    }

    static void dijkstra(int[] distance, ArrayList<Node>[] graph, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int nowIndex = current.index;

            if (distance[nowIndex] < current.cost) continue;

            for (Node next : graph[nowIndex]) {
                if (distance[next.index] > distance[nowIndex] + next.cost) {
                    distance[next.index] = distance[nowIndex] + next.cost;
                    pq.add(new Node(next.index, distance[next.index]));
                }
            }
        }
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
