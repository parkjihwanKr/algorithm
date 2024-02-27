import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		// 3 5 9 17 33 ....
		// 1+2, 1+4, 1+8, 1+16, 1+32
		//  2 4 8  16  32 
		System.out.println(answer(input));
	}
	
	static int answer(int input) {
		if(input == 1) {
			return 9;
		}else {
			int answer = (int)Math.pow(2, input);
			return (int)Math.pow(1+answer, 2);
		}
	}
}
