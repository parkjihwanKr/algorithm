import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i<input; i++) {
			// 자연수면 add, 0은 최소값 
			int N = Integer.parseInt(br.readLine());
			if(N == 0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}else {
					int min = pq.remove();
					System.out.println(min);
				}
			}
			if(N > 0) {
				pq.offer(N);
			}
		}
	}
}
