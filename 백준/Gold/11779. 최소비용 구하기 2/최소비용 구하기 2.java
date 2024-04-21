import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Node>[] map;
    static int[] distance, parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        final int INF = Integer.MAX_VALUE;
        map = new ArrayList[N];
        distance = new int[N];
        parent = new int[N];
        Arrays.fill(distance, INF);
        Arrays.fill(parent, -1);

        for (int i = 0; i < N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken()) - 1;
            int u = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            map[v].add(new Node(u, w));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int startPoint = Integer.parseInt(st.nextToken()) - 1;
        int endPoint = Integer.parseInt(st.nextToken()) - 1;
        dijkstra(startPoint);

        System.out.println(distance[endPoint]);
        Stack<Integer> path = new Stack<>();
        for (int i = endPoint; i != -1; i = parent[i]) {
            path.push(i + 1);
        }
        System.out.println(path.size());
        while (!path.isEmpty()) {
            System.out.print(path.pop() + " ");
        }
    }

    static void dijkstra(int startPoint) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startPoint, 0));
        distance[startPoint] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (distance[now.index] < now.cost) continue;

            for (Node next : map[now.index]) {
                if (distance[next.index] > distance[now.index] + next.cost) {
                    distance[next.index] = distance[now.index] + next.cost;
                    parent[next.index] = now.index;
                    pq.offer(new Node(next.index, distance[next.index]));
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
