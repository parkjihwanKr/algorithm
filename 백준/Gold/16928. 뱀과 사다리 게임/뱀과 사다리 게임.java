import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] board;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N : Ladder, M : Snake
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// index 0~100 배열 지정 
		board = new int[101];
		
		// 자기 인덱스에 해당하는 값을 board에 임시 저장
		for(int i = 0; i<board.length; i++) {
			board[i] = i;
		}
		
		// Ladder
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 42 -> 68
			board[x] = y;
		}
		
		// Snake
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 93 -> 37 ...
			board[x] = y;
		}
		
		int answer = bfs(1);
		System.out.println(answer);
	}
	
	// bfs
	static int bfs(int startNode) {
		// 기본 설정
		int[] check = new int[101];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startNode);
		check[startNode] = 0;
		
		// 반복문
		while(true) {
			int visitedNum = queue.poll();
			for(int i = 1; i< 7; i++) {
				int newNode = visitedNum + i;
				
				if(newNode > 100) {
					continue;
				}
				
				if(check[board[newNode]] == 0) {
					queue.offer(board[newNode]);
					check[board[newNode]] = check[visitedNum] + 1;
				}
				
				if(board[newNode] == 100) {
					return check[100];
				}
			}
		}
	}
}
