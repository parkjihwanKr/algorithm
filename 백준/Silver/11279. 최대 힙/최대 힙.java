import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i<input; i++) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) {
				if(!pq.isEmpty()) {
					int max = pq.poll();
					System.out.println(max);
				}else {
					System.out.println(0);
				}
			}
			if(N > 0) {
				pq.add(N);
			}
		}
	}
}
