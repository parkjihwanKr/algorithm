import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int VISITED_MAX_LENGTH = 100001; // 방문 가능한 최대 길이를 100000으로 설정
    static boolean[] visited; // 방문 여부를 체크하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        // 입력 받기
        M = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        N = Integer.parseInt(st.nextToken()); // 동생의 위치

        visited = new boolean[VISITED_MAX_LENGTH];

        if(N == M) {
            System.out.println(0); // 시작 위치와 동생 위치가 같을 경우 이동 필요 없음
        } else {
            System.out.println(bfs(M)); // BFS를 통해 최소 이동 횟수 계산
        }
    }

    static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0}); // 현재 위치와 이동 횟수를 함께 저장
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentPosition = current[0];
            int currentCount = current[1];

            if (currentPosition == N) {
                return currentCount; // 목표 위치에 도달한 경우 현재까지의 이동 횟수 반환
            }

            // 가능한 모든 이동 경로 탐색
            int[] nextPositions = {currentPosition - 1, currentPosition + 1, currentPosition * 2};
            for (int nextPosition : nextPositions) {
                if (nextPosition >= 0 && nextPosition < VISITED_MAX_LENGTH && !visited[nextPosition]) {
                    visited[nextPosition] = true;
                    queue.offer(new int[]{nextPosition, currentCount + 1}); // 다음 위치와 이동 횟수를 증가시켜 큐에 추가
                }
            }
        }

        return -1; // 도달할 수 없는 경우
    }
}
