import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4179 {
    /**
     * 불!
     * 지훈이가 불에 타기전에 탈출할 수 있는지의 여부, 얼마나 빨리 탈출할 수 있는지
     * input : 1 <= R,C <= 1000. # = 벽, . = 지나갈 수 있는 공간, J = 지훈, F = 불
     * output : IMPOSSIBLE or 탈출시간
     *
     * @param args
     */
    private static char[][] map = new char[1000][1000];
    private static int[][] fireVisited = new int[1000][1000];
    private static int[][] jihunVisited = new int[1000][1000];

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Queue<Pair> q = new LinkedList<>();

        Pair jPos = null;
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'J') {
                    jPos = new Pair(i, j); // 지훈 위치
                } else if (map[i][j] == 'F') {
                    fireVisited[i][j] = 1;
                    q.add(new Pair(i, j));
                } // 불 위치
            }
        } // end of input

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (map[nx][ny] == '#' || fireVisited[nx][ny] > 0) continue;

                fireVisited[nx][ny] = fireVisited[cur.x][cur.y] + 1;
                q.add(new Pair(nx, ny));
            }
        } // 불 bfs 완료

        jihunVisited[jPos.x][jPos.y] = 1;
        q.add(jPos);

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    System.out.println(jihunVisited[cur.x][cur.y]);
                    return;
                } // 탈출

                if (map[nx][ny] == '#' || jihunVisited[nx][ny] > 0) // 벽이거나 이미 방문한 경우
                    continue;
                if (fireVisited[nx][ny] != 0 && fireVisited[nx][ny] <= jihunVisited[cur.x][cur.y] + 1)
                    continue;

                jihunVisited[nx][ny] = jihunVisited[cur.x][cur.y] + 1;
                q.add(new Pair(nx, ny));
            }
        }
        System.out.println("IMPOSSIBLE");
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
