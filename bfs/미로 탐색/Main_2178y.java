import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178y {
    /**
     * 미로 탐색
     * (1,1)에서 (n,m)으로 갈 때 지나야 하는 최소의 칸 수
     * 가로,세로크기 1 <= n,m <= 100
     */
    private static boolean[][] map = new boolean[100][100];
    private static int[][] visited = new int[100][100];
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String s;
        for (int i = 0; i < n; i++) {
            s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) == '1' ? true : false;
            }
        } // end of input

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        visited[0][0] = 1;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (!map[nx][ny] || visited[nx][ny] != 0) continue;

                visited[nx][ny] = visited[cur.x][cur.y] + 1;
                q.add(new Pair(nx, ny));
            }
        }

        System.out.println(visited[n - 1][m - 1]);
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
