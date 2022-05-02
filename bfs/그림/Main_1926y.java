import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1926y {
    /**
     * 그림
     * 도화지의 그림의 개수와 그 그림 중 넓이가 가장 큰 것의 넓이를 출력해라
     * 가로,세로크기 1 <= n,m <= 500
     * 고찰 : 이중for문 대신 Queue를 이용해서 미리 그림(1)을 저장해도 된다.
     *
     * @param args
     */
    private static boolean[][] map = new boolean[500][500];
    private static boolean[][] visited = new boolean[500][500];
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0, idx = 0; j < m; j++, idx += 2) {
                map[i][j] = s.charAt(idx) == '1' ? true : false;
            }
        } // end of input

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] && !visited[i][j]) {
                    cnt++; // 그림 개수 추가
                    visited[i][j] = true;
                    q.add(new Pair(i, j));
                    int area = 0; // 그림 넓이 초기화

                    while (!q.isEmpty()) {
                        Pair cur = q.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if (!map[nx][ny] || visited[nx][ny]) continue;

                            visited[nx][ny] = true;
                            q.add(new Pair(nx, ny));
                        }
                        area++;
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        System.out.println(cnt + "\n" + maxArea);
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