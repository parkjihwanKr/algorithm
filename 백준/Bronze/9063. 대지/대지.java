import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer input = Integer.parseInt(br.readLine());
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		int widthMax = Integer.parseInt(st.nextToken());
		int heightMax = Integer.parseInt(st.nextToken());
		int widthMin = widthMax;
		int heightMin = heightMax;
		for(int i = 0; i<input-1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int test1 = Integer.parseInt(st.nextToken());
			int test2 = Integer.parseInt(st.nextToken());
			widthMax = Math.max(widthMax, test1);
			heightMax = Math.max(heightMax, test2);
			widthMin = Math.min(widthMin, test1);
			heightMin = Math.min(heightMin, test2);
		}
		System.out.println((widthMax - widthMin) * (heightMax - heightMin));
	}
}
