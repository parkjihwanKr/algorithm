import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Node>[] map;
	static int[] distance, item;
	static int n, m, r;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 양방향 통행
		// 밖의 숫자는 지역 번호, 안의 숫자는 아이템 수, 선 위의 숫자는 거리
		// 첫째 줄에는 지역의 개수 n (1 ≤ n ≤ 100)과 예은이의 수색범위 m (1 ≤ m ≤ 15), 길의 개수 r (1 ≤ r ≤ 100)이 주어진다.
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		// 둘째 줄에는 n개의 숫자가 차례대로 각 구역에 있는 아이템의 수 t (1 ≤ t ≤ 30)를 알려준다.
		item = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		// 세 번째 줄부터 r+2번째 줄 까지 길 양 끝에 존재하는 지역의 번호 a, b, 그리고 길의 길이 l (1 ≤ l ≤ 15)가 주어진다.
		map = new ArrayList[n];
		for(int i = 0; i<n; i++) {
			map[i] = new ArrayList<Node>();
		}
		
		for(int i = 0; i<r; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			map[u].add(new Node(v, w));
			map[v].add(new Node(u, w));
		}
		int[] answer = new int[n];
		for(int i = 0; i<n; i++) {
			// answer[i] += item[i];
			for(int j = 0; j<n; j++) {
				dijkstra(i, j);
				if(distance[j] <= m) {
					// System.out.println("distance.... startPoint("+(i+1)+") -> endPoint("+(j+1)+") : "+ distance[j]);
					// System.out.println("item.... startPoint("+(i+1)+") -> endPoint("+(j+1)+") : "+ item[j]);
					answer[i] += item[j];
				}
			}
			// dijkstra(i);
			// endPoint : index 5고정일 때
			// System.out.println("startPoint("+i+") -> endPoint("+(n-1)+") : "+ distance[n-1]);
			// System.out.println("answer["+(i+1)+"] : "+answer[i]);
		}
		Arrays.sort(answer);
		System.out.println(answer[n-1]);
	}
	
	static void dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		final int INF = Integer.MAX_VALUE;
		distance = new int[n];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			for(Node next : map[now.index]) {
				// 최단 경로
				if(distance[next.index] > distance[now.index] + next.cost) {
					distance[next.index] = distance[now.index] + next.cost;
					if(distance[next.index] <= m) {
						pq.add(new Node(next.index, distance[next.index]));
					}
				}
			}
		}
	}
	
	// Node 설정
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
