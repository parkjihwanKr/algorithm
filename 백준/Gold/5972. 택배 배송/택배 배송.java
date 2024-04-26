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
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N];
		distance = new int[N];
		final int INF = Integer.MAX_VALUE;
		for(int i = 0; i<N; i++) {
			map[i] = new ArrayList<Node>();
			distance[i] = INF;
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			
			map[a].add(new Node(b, c));
			map[b].add(new Node(a, c));
		}
		
		dijkstra(0);
		/*for(int i = 0; i<distance.length; i++) {
			System.out.println("distance["+i+"] : "+distance[i]);
		}*/
		System.out.println(distance[N-1]);
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
	
	static class Node implements Comparable<Node>{
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
