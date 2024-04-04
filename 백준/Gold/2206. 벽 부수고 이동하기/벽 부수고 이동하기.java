import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] maze;
    static boolean[][][] visited;
    // 동서남북
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                maze[i][j] = Character.getNumericValue(charArray[j]);
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();

        // 시작점을 큐에 넣습니다.
        queue.offer(new Node(0, 0, false, 1));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int nowX = node.x;
            int nowY = node.y;
            int nowCount = node.count;
            // 도착하면 지나간 타일 수를 반환합니다.
            if (nowX == N - 1 && nowY == M - 1) {
                return nowCount;
            }

            for (int i = 0; i < dx.length; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                // 배열을 벗어난 경우는 넘어갑니다.
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }

                // 벽을 부순적이 있는지 확인합니다.
                if (node.destroyed) {
                    // 벽을 부순적이 있을 때 해당 지점이 벽이 아니고, 방문한적이 없다면 큐에 정보를 넣습니다.
                    if (maze[nextX][nextY] == 0 && !visited[nextX][nextY][1]) {
                        visited[nextX][nextY][1] = true;
                        queue.offer(new Node(nextX, nextY, true, node.count + 1));
                    }
                } else {
                    // 해당 위치가 벽인지 확인합니다.
                    if (maze[nextX][nextY] == 1) {
                        // 벽이라면 벽을 부수고 큐에 값을 넣습니다.
                        visited[nextX][nextY][1] = true;
                        queue.offer(new Node(nextX, nextY, true, node.count + 1));
                    } else if (!visited[nextX][nextY][0]){
                        // 벽이 아니고 방문한적이 없다면 큐에 값을 넣습니다.
                        visited[nextX][nextY][0] = true;
                        queue.offer(new Node(nextX, nextY, false, node.count + 1));
                    }
                }
            }
        }

        return -1;
    }

    static class Node {
        int x;
        int y;
        boolean destroyed;
        int count;

        public Node(int x, int y, boolean destroyed, int count) {
            this.x = x;
            this.y = y;
            this.destroyed = destroyed;
            this.count = count;
        }
    }
}