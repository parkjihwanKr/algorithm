import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int answer = countCloseWindow(input);		
		System.out.println(answer);
	}
	
	static int countCloseWindow(int input) {
		int answer = (int)Math.sqrt((double)input);
		return answer;
	}
}
