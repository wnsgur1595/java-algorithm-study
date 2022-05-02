import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576y {

    /**
     * 토마토
     * 2 <= n,m <= 1000
     * 1 : 익은 토마토
     * 0 : 익지 않은 토마토
     * -1 : 토마토가 들어 있지 않은 칸
     * output : 토마토가 다 익게 되는 최소 일수.
     * 단 처음부터 모두 익어있다면 0, 토마토가 모두 익지 못한다면 -1
     */

    private static int[][] map = new int[1000][1000];
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Queue<Pair> tomatoQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    tomatoQueue.add(new Pair(i, j));
                }
            }
        } // end of input

        if (n * m == tomatoQueue.size()) {
            System.out.println(0);
            return;
        } // 저장될 때부터 모든 토마토가 익어있는 상태

        while (!tomatoQueue.isEmpty()) {
            Pair cur = tomatoQueue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (map[nx][ny] == 0) {
                    map[nx][ny] = map[cur.x][cur.y] + 1;
                    tomatoQueue.add(new Pair(nx, ny));
                }
            }
        }

        int day = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                day = Math.max(map[i][j], day);
            }
        } // 토마토가 모두 익지 못하는 상황

        System.out.println(day - 1);
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
