import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697y {
    /**
     * 숨바꼭질
     * 수빈이, 동생 0 <= N,K <= 100,000
     * 수빈이는 걷거나(X-1, X+1) 순간이동(2X) 할 수 있다.
     * 수빈이가 동생을 찾을 수 있는 가장 빠른 시간?
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (k <= n) {
            System.out.println(n - k);
            return;
        }

        boolean[] isVisited = new boolean[100001];
        int[] dx = {-1, 1};
        Queue<Integer> q = new LinkedList<>();
        isVisited[n] = true;
        q.offer(n);

        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer cur = q.poll();

                if (cur == k) {
                    System.out.println(ans);
                    return;
                }

                // -1 , +1
                for (int dir = 0; dir < 2; dir++) {
                    Integer next = cur + dx[dir];
                    if (next < 0 || next > 100000) continue;
                    if (isVisited[next]) continue;

                    isVisited[next] = true;
                    q.offer(next);
                }
                // *2
                Integer next = cur * 2;
                if (next < 0 || next > 100000) continue;
                if (isVisited[next]) continue;

                isVisited[next] = true;
                q.offer(next);
            }
            ans++;
        }
    }
}
