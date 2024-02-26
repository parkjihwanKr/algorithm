import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int input = Integer.parseInt(st.nextToken());
		int quarter = 0;
		int dime = 0;
		int nickel = 0;
		int penny = 0;
		
		for(int i = 0; i<input; i++) {
			st = new StringTokenizer(br.readLine());
			int money = Integer.parseInt(st.nextToken());
			
			quarter = money / 25;
			money = money % 25;
			//System.out.println("quarter : "+money);
			dime = money / 10;
			money = money % 10;
			//System.out.println("dime : "+dime);
			nickel = money / 5;
			money = money % 5;
			//System.out.println("nickel : "+nickel);
			penny = money / 1;
			//System.out.println("penny : "+penny);
			sb.append(quarter).append(" "+dime).append(" "+nickel).append(" "+penny).append("\n");
			
		}
		System.out.println(sb);
	}
}
