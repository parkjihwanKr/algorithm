import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i<testCase; i++) {
			// 1. data settings
			st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[M][N];
			visited = new boolean[M][N];
			
			for(int j = 0; j<K; j++) {
				// 2. graph settings
				st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			
			int answer = 0;
			for(int j = 0; j<M; j++) {
				for(int k = 0; k<N; k++) {
					// 3. 배열 map에 초기화한 값이 있고 방문하지 않은 친구들에 대한 설정
					if(map[j][k] == 1 && !visited[j][k]) {
						bfs(j, k);
						answer++;
					}
				}
			}
			System.out.println(answer);
		}
		br.close();
	}
	
	// 4. bfs 설정
	static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        // 해당 구간을 지났기에 false -> true 변경
		visited[x][y] = true;
		
		// queue에 아무런 값이 없다면
		while(!queue.isEmpty()) {
			// 제일 먼저 들어간 값이 나옴
			Node node = queue.poll();
			
			for(int i = 0; i<dx.length; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx >= M || ny >= N || nx <0 || ny < 0) {
					continue;
				}
				if(visited[nx][ny] || map[nx][ny] != 1) {
					continue;
				}
                
                queue.add(new Node(nx, ny));
                visited[nx][ny] = true;
			}
		}
	}
	
	// 5. Node 생성
	static class Node {
		int x;
		int y;
		
		// 생성자
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
