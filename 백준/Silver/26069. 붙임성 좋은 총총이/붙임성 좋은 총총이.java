import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int tmp = 0;
		
		// ChongChong이의 이름은 무조건 ChongChong -> 대소문자를 구별
		final String ChongChong = "ChongChong";
		HashSet<String> hs = new HashSet<>();
		StringTokenizer st;
		for(int i = 0; i<input; i++) {
			st = new StringTokenizer(br.readLine()," ");
			String firstString = st.nextToken();
			String secondString = st.nextToken();
			
			if(firstString.equals(ChongChong)) {
				hs.add(firstString);
				hs.add(secondString);
				tmp = i;
				break;
			}
			
			if(secondString.equals(ChongChong)) {
				hs.add(firstString);
				hs.add(secondString);
				tmp = i;
				break;
			}
		}
		
		// 중간 점검
		// System.out.println("input : "+input);
		// System.out.println("tmp : "+tmp);
		// System.out.println(hs);
		
		for(int i = tmp+1; i<input; i++) {
			st = new StringTokenizer(br.readLine()," ");
			String firstString = st.nextToken();
			String secondString = st.nextToken();
			
			if(hs.contains(firstString) && !hs.contains(secondString)) {
				hs.add(secondString);
				continue;
			}
			if(hs.contains(secondString) && !hs.contains(firstString)) {
				hs.add(firstString);
				continue;
			}
		}
		
		// 마지막 점검
		// System.out.println(hs);
		System.out.println(hs.size());
	}
}
