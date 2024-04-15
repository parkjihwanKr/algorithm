import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int MAX_POSITION = 100001;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        if (start == end) {
            System.out.println(0);
        } else {
            int answer = dijkstra(start, end);
            System.out.println(answer);
        }
    }

    static int dijkstra(int start, int end) {
        int[] distance = new int[MAX_POSITION + 1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(distance, INF);
        distance[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentPosition = current.vertex;

            if (currentPosition == end) {
                return distance[currentPosition];
            }

            int[] nextPositions = {currentPosition - 1, currentPosition + 1, currentPosition * 2};
            for (int i = 0; i < nextPositions.length; i++) {
                if (nextPositions[i] >= 0 && nextPositions[i] <= MAX_POSITION) {
                    int newWeight = distance[currentPosition] + (i < 2 ? 1 : 0);
                    if (newWeight < distance[nextPositions[i]]) {
                        distance[nextPositions[i]] = newWeight;
                        pq.offer(new Node(nextPositions[i], newWeight));
                    }
                }
            }
        }
        return -1; 
    }

    static class Node implements Comparable<Node> {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
}
