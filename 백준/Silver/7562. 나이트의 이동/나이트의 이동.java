import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int length, nowX, nowY, lastX, lastY;
	static boolean[][] visited;
	static int[] dx = {-2,-1,2,1,2,1,-2,-1};
	static int[] dy = {1,2,1,2,-1,-2,-1,-2};
	static int[][] chess;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i = 0; i<testCase; i++) {
			// 한변의 길이
			length = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			nowX = Integer.parseInt(st.nextToken());
			nowY = Integer.parseInt(st.nextToken());
			// System.out.println("nowX : "+nowX+ " nowY : "+nowY);
			chess = new int[length][length];
			visited = new boolean[length][length];
			visited[nowX][nowY] = true;
			st = new StringTokenizer(br.readLine()," ");
			lastX = Integer.parseInt(st.nextToken());
			lastY = Integer.parseInt(st.nextToken());
			// System.out.println("lastX : "+lastX+ " lastY : "+lastY);
			bfs(nowX, nowY);
			System.out.println(chess[lastX][lastY]);
		}
	}
	static void bfs(int nowX, int nowY) {
	    // 1. queue 선언
	    Queue<Node> queue = new LinkedList<>();
	    queue.add(new Node(nowX, nowY));
	    
	    // 2. while
	    while(!queue.isEmpty()) { 
	        // 2-1. 해당 노드에 대해 꺼내옴
	        Node node = queue.poll();
	        for(int i = 0; i < dx.length; i++) {
	            int nextX = node.x + dx[i];
	            int nextY = node.y + dy[i]; 
	            
	            // 조건 검사 및 큐에 추가
	            if(nextX >= 0 && nextY >= 0 && nextX < length && nextY < length && !visited[nextX][nextY]) {
	                queue.add(new Node(nextX, nextY));
	                visited[nextX][nextY] = true;
	                chess[nextX][nextY] = chess[node.x][node.y] + 1;
	            }
	        }
	    }
	}
	
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
