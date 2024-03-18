import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] house;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// System.out.println("input : "+input);
		
		house = new int[N];
		for(int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		
		// 1. 이분탐색을 하기 위해서 무조건 Arrays.sort() 필요
		Arrays.sort(house);
		
		// 2. left, right, mid 설정
		// left는 최소 거리
		// right는 house의 거리에 따른 최소 거리의 최댓값(동적)
		int left = 1;
		int right = house[N-1] - house[0] + 1;
		
		while(left < right) {
			int mid = (left + right)/2;
			if(canInstall(mid) < M) {
				right = mid;
			}else {
				left = mid + 1;
			}
		}
		System.out.print(left - 1);
	}
	
	public static int canInstall(int distance) {
		// 무조건 하나는 설치
		int count = 1;
		int lastLocate = house[0];
		
		for(int i = 1; i < house.length; i++) {
			int locate = house[i];
			if(locate - lastLocate >= distance) {
				count++;
				lastLocate = locate;
			}
		}
		return count;
	}
}
