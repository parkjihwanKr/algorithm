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
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		// N : city, M : road, K : road Info, X : start city number
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()) - 1;
		final int INF = Integer.MAX_VALUE;
		
		map = new ArrayList[N];
		distance = new int[N];
		for(int i = 0; i<N; i++) {
			map[i] = new ArrayList<Node>();
			distance[i] = INF;
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			map[A].add(new Node(B, 1));
		}
		
		dijkstra(X);
		
		int answer = -1;
		for(int i = 0; i<distance.length; i++) {
			if(distance[i] == K) {
				answer = 0;
				System.out.println(i + 1);
			}
		}
		if(answer == -1) {
			System.out.println(answer);
		}
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			for(Node next : map[now.index]) {
				if(distance[next.index] > distance[now.index] + next.cost) {
					distance[next.index] = distance[now.index] + next.cost;
                    pq.add(new Node(next.index, distance[next.index]));
				}
			}
		}
	}
	
	static class Node implements Comparable<Node> {
		int index;
		int cost;
		
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
