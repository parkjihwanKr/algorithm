import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int[][] distance;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = 1;
        while (true) {
            input = Integer.parseInt(br.readLine());
            if (input == 0) break;
            
            final int INF = Integer.MAX_VALUE;
            map = new int[input][input];
            distance = new int[input][input];
            StringTokenizer st;

            for (int i = 0; i < input; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < input; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    distance[i][j] = INF;
                }
            }

            dijkstra(0, 0);
            System.out.println("Problem " + number + ": " + distance[input - 1][input - 1]);
            number++;
        }
    }

    static void dijkstra(int startX, int startY) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[startX][startY] = map[startX][startY];
        pq.add(new Node(startX, startY, distance[startX][startY]));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.cost > distance[now.x][now.y]) continue;

            for (int i = 0; i < dx.length; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX >= 0 && nextX < input && nextY >= 0 && nextY < input) {
                    int nextCost = distance[now.x][now.y] + map[nextX][nextY];
                    if (distance[nextX][nextY] > nextCost) {
                        distance[nextX][nextY] = nextCost;
                        pq.add(new Node(nextX, nextY, nextCost));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
}
