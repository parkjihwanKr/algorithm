import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Node>[] map;
	static int[] distance;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// city
		int N = Integer.parseInt(br.readLine());
		// bus
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		final int INF = Integer.MAX_VALUE;
		map = new ArrayList[N];
		distance = new int[N];
		for(int i = 0; i<N; i++) {
			map[i] = new ArrayList<Node>();
			distance[i] = INF;
		}
		
		// bus 노선
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			map[u].add(new Node(v,w));
		}
		st = new StringTokenizer(br.readLine()," ");
		int startPoint = Integer.parseInt(st.nextToken()) -1;
		int endPoint = Integer.parseInt(st.nextToken()) -1;
		
        dijkstra(startPoint);

        System.out.println(distance[endPoint]);
        
	}
	
	// dijkstra algorithm
	static void dijkstra(int startPoint) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(startPoint, 0));
		distance[startPoint] = 0;
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			int currentIndex = current.index;
			
			if (distance[currentIndex] < current.cost) {
				continue;
			}
			
			for(Node next : map[currentIndex]) {
				if(distance[next.index] > distance[currentIndex] + next.cost) {
					//visited[next.index] = true;
					distance[next.index] = distance[currentIndex] + next.cost;
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
