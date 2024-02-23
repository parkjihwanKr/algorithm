import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		ArrayList<Integer> array = new ArrayList<>();
		Integer n = Integer.parseInt(st.nextToken());
		Integer k = Integer.parseInt(st.nextToken());
		int count = 0;
		int answer = 0;

		for(int i = 1; i<= n; i++) {
			if(n % i == 0){
				array.add(i);
				count++;
			}
			if(count == k) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
}
