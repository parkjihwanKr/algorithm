import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
    // 건물들 높이
    static int[] buildings;
    // 보이는 건물의 개수
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        buildings = new int[N];
        answer = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N-1; i++) {
            answer[i]++;
            answer[i+1]++;
            // 기울기
            double slope = buildings[i+1] - buildings[i];
            for (int j = i+2; j < N; j++) {
                double nextSlope = calculate(i, j);
                if (nextSlope > slope) {
                    slope = nextSlope;
                    answer[i]++;
                    answer[j]++;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < answer.length; i++) {
            max = Math.max(max, answer[i]);
        }

        System.out.println(max);
    }

    static double calculate(int i, int j) {
        return (double) (buildings[j]-buildings[i]) / (j - i);
    }
}
