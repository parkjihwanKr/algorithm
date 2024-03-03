import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> hashSet = new HashSet<>();
		int input = Integer.parseInt(br.readLine());
		int count = 0;
		String start = br.readLine();
		
		if(start.equals("ENTER")) {
			for(int i = 0; i<input-1; i++) {
				String nickname = br.readLine();
				if(nickname.equals("ENTER")) {
					count++;
					hashSet.clear();
				}else {
					if(hashSet.contains(nickname)) {
						count++;
						//System.out.println(count);
					}else {
						hashSet.add(nickname);				
					}
				}
			}
		}
		System.out.println(input-count-1);
	}
}
