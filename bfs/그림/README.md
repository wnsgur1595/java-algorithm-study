
# [๊ทธ๋ฆผ](https://www.acmicpc.net/problem/1926) ๐ช

์ด๋ค ํฐ ๋ํ์ง์ ๊ทธ๋ฆผ์ด ๊ทธ๋ ค์ ธ ์์ ๋, ๊ทธ ๊ทธ๋ฆผ์ ๊ฐ์์, ๊ทธ ๊ทธ๋ฆผ ์ค ๋์ด๊ฐ ๊ฐ์ฅ ๋์ ๊ฒ์ ๋์ด๋ฅผ ์ถ๋ ฅํ์ฌ๋ผ. ๋จ, ๊ทธ๋ฆผ์ด๋ผ๋ ๊ฒ์ 1๋ก ์ฐ๊ฒฐ๋ ๊ฒ์ ํ ๊ทธ๋ฆผ์ด๋ผ๊ณ  ์ ์ํ์. ๊ฐ๋ก๋ ์ธ๋ก๋ก ์ฐ๊ฒฐ๋ ๊ฒ์ ์ฐ๊ฒฐ์ด ๋ ๊ฒ์ด๊ณ  ๋๊ฐ์ ์ผ๋ก ์ฐ๊ฒฐ์ด ๋ ๊ฒ์ ๋จ์ด์ง ๊ทธ๋ฆผ์ด๋ค. ๊ทธ๋ฆผ์ ๋์ด๋ ๊ทธ๋ฆผ์ ํฌํจ๋ 1์ ๊ฐ์์ด๋ค.

### ์๋ ฅ
์ฒซ์งธ ์ค์ ๋ํ์ง์ ์ธ๋ก ํฌ๊ธฐ n(1 โค n โค 500)๊ณผ ๊ฐ๋ก ํฌ๊ธฐ m(1 โค m โค 500)์ด ์ฐจ๋ก๋ก ์ฃผ์ด์ง๋ค. ๋ ๋ฒ์งธ ์ค๋ถํฐ n+1 ์ค ๊น์ง ๊ทธ๋ฆผ์ ์ ๋ณด๊ฐ ์ฃผ์ด์ง๋ค. (๋จ ๊ทธ๋ฆผ์ ์ ๋ณด๋ 0๊ณผ 1์ด ๊ณต๋ฐฑ์ ๋๊ณ  ์ฃผ์ด์ง๋ฉฐ, 0์ ์์น ์ด ์๋ ๋ถ๋ถ, 1์ ์์น ์ด ๋ ๋ถ๋ถ์ ์๋ฏธํ๋ค)

### ์ถ๋ ฅ
์ฒซ์งธ ์ค์๋ **๊ทธ๋ฆผ์ ๊ฐ์**, ๋์งธ ์ค์๋ ๊ทธ ์ค **๊ฐ์ฅ ๋์ ๊ทธ๋ฆผ์ ๋์ด**๋ฅผ ์ถ๋ ฅํ์ฌ๋ผ. ๋จ, ๊ทธ๋ฆผ์ด ํ๋๋ ์๋ ๊ฒฝ์ฐ์๋ ๊ฐ์ฅ ๋์ ๊ทธ๋ฆผ์ ๋์ด๋ 0์ด๋ค.


### ์์ 


    6 5
    1 1 0 1 1
    0 1 1 0 0
    0 0 0 0 0
    1 0 1 1 1
    0 0 1 1 1
    0 0 1 1 1

    output
    4
    9

# ํ์ด
BFS๋ก ํ ์ ์๋ ๊ธฐ๋ณธ ์ ํ์ ๋ฌธ์ ๋ผ๊ณ  ํ  ์ ์๋ค. ํฐ ๋ํ์ง(map)์ ํ์ํ๋ฉด์ ๊ทธ๋ฆผ์ ๊ฐ์์ ๊ฐ์ฅ ํฐ ๊ทธ๋ฆผ์ ๋์ด๋ฅผ ์์๋ด๋ฉด ๋๋ค. ์ด๋ ๊ทธ๋ฆผ์ 1๋ก ์ฐ๊ฒฐ๋ ๊ฒ๋ค์ ์๋ฏธํ๋ค.

๊ทธ๋ฆผ์ ๊ฐ์์ ์ต๋ ๋์ด๋ ๋ค์๊ณผ ๊ฐ์ ์์๋ก ์ฐพ์ ์ ์๋ค.

#### ์์ธํ ํ์ด
1. ๊ทธ๋ฆผ์ ์ฐพ์ ๋๊น์ง ๋ํ์ง๋ฅผ ํ์ํ๋ค. (`map[i][j] == 1์ธ๊ฑธ ์ฐพ์๋๊น์ง ์ด์คfor๋ฌธ์ผ๋ก ํ์ํ๋ค`)
2. ์ฒ์์ผ๋ก ๊ทธ๋ฆผ์ ์ผ๋ถ๋ฅผ ์ฐพ์๋ค๋ฉด **๊ทธ๋ฆผ์ ๋ชจ๋ ์ฐ๊ฒฐ๋์ด ์๊ธฐ ๋๋ฌธ์** ์ฃผ๋ณ์ ํ์ํ๋ฉฐ ๊ทธ๋ฆผ์ ๋์ด๋ฅผ ๊ตฌํ๋ค. (`bfs`)
3. ์ฐพ์ ๊ทธ๋ฆผ์ ๋ค์ ์ฐพ์ง ์๊ธฐ ์ํด์ ์ด๋ฏธ ๋ฐฉ๋ฌธํ๋ค๋ ์ฒดํฌ๋ฅผ ํด ๋๋๋ค(`visited ๋ฐฐ์ด ํ์ฉ`)
4. ๋ค์ ๋ค๋ฅธ ๊ทธ๋ฆผ์ ์ฐพ๊ธฐ ์ํด ๋ํ์ง๋ฅผ ํ์ํ๋ค
5. ๊ทธ๋ฆผ์ ์ผ๋ถ๋ฅผ ์ฐพ์๋ค๋ฉด ์ด๋ฏธ ์ฐพ์๋ ๊ทธ๋ฆผ์ธ์ง ํ์ธํด๋ณธ๋ค(`visited[i][j] == 1์ด๋ฉด ์ด๋ฏธ ์ฐพ์๋ ๊ทธ๋ฆผ`)
6. ์๋๋ผ๋ฉด 2~3๋ฒ ๊ณผ์ ์ ๋ฐ๋ณตํ๋ค.
7. ๋ํ์ง๋ฅผ ๋ชจ๋ ํ์ํ๋ค๋ฉด ์ง๊ธ๊น์ง ์ฐพ์ ๊ทธ๋ฆผ์ ๊ฐ์์ ๊ทธ๋ฆผ์ ์ต๋ ๋์ด๋ฅผ ์ถ๋ ฅํ๋ค.

bfs๋ฅผ ์ด์ฉํด์ ๊ทธ๋ฆผ์ ์กฐ๊ฐ์์๋ถํฐ ์ ์ฒด ๊ทธ๋ฆผ์ ํ์ํ๊ณ , ๊ทธ๋ฆผ์ ๋์ด๋ฅผ ๊ตฌํ๋ฉด ๋๋ ๋ฌธ์ ์ด๋ค. ์ด๋ ์ด๋ฏธ ์ฐพ์๋(๋ฐฉ๋ฌธํ๋) ๊ทธ๋ฆผ์ด๋ผ๋ฉด ์ฌ๋ฐฉ๋ฌธํ๋๊ฒ ๋นํจ์จ์ ์ด๋ฏ๋ก ๋ฐฉ๋ฌธ ํ์ธ์ฉ 2์ฐจ์ ๋ฐฐ์ด(`visited`)์ ํตํด ๋ฐฉ๋ฌธ์ฌ๋ถ๋ฅผ ์ ์ฅํ๋ค.

##### ๊ทธ๋ฆผ์ ๊ฐ์
์๋ก์ด ๊ทธ๋ฆผ์ ์กฐ๊ฐ(`map[i][j] == 1 && !visited[i][j]`)์ ์ฐพ์๋ด๋ฉด ํ๋ฒ์ bfs๋ก ์ ์ฒด ๊ทธ๋ฆผ์ ์ฐพ์๋ด๊ธฐ(๋ฐฉ๋ฌธํ๊ธฐ)๋๋ฌธ์ ๋ํ์ง๋ฅผ ํ์ํ  ๋ ์ด์ ์ ๋ฐฉ๋ฌธํ์ง ์์๋ ๊ทธ๋ฆผ์ ์กฐ๊ฐ(`map[i][j] == 1`)์ ์ฐพ์๋ธ(๋ฐฉ๋ฌธํ) ํ์๊ฐ ๊ทธ๋ฆผ์ ๊ฐ์์ด๋ค. **์ฆ, ์๋กญ๊ฒ bfs๋ฅผ ์คํํ๋ ํ์๊ฐ ๊ทธ๋ฆผ์ ๊ฐ์์ด๋ค.**
##### ๊ทธ๋ฆผ์ ๋์ด
์๋ก์ด ๊ทธ๋ฆผ์ ์กฐ๊ฐ(`map[i][j] == 1 && !visited[i][j]`)์ ์ฐพ์๋ด๋ฉด ํ๋ฒ์ bfs๋ก ์ ์ฒด ๊ทธ๋ฆผ์ ์ฐพ์๋ด๊ธฐ(๋ฐฉ๋ฌธํ๊ธฐ)๋๋ฌธ์ bfs ์คํ ์ ๋ฐฉ๋ฌธํ ๊ทธ๋ฆผ ์กฐ๊ฐ(๋ธ๋)์ ๊ฐ์๊ฐ ๊ทธ๋ฆผ์ ๋์ด์ด๋ค. **์ฆ, bfs ์คํ ์ queue์์ pop๋๋ ํ์๊ฐ ๊ทธ๋ฆผ์ ๋์ด์ด๋ค.**


### ์ฝ๋

```java
// ๋ฉค๋ฒ๋ณ์ ์ ์ธ
private static boolean[][] map = new boolean[500][500];
private static boolean[][] visited = new boolean[500][500];

// ์๋ต

Queue<Pair> q = new LinkedList<>();
for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
        // ๊ทธ๋ฆผ์ด๊ณ  && ๋ฐฉ๋ฌธํ์ง ์์๋ค๋ฉด
        if (map[i][j] && !visited[i][j]) {
            cnt++; // ๊ทธ๋ฆผ ๊ฐ์ ์ถ๊ฐ
            visited[i][j] = true; // ๋ฐฉ๋ฌธ
            q.add(new Pair(i, j));
            int area = 0; // ๊ทธ๋ฆผ ๋์ด ์ด๊ธฐํ(์๋ก์ด ๊ทธ๋ฆผ ์์)

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
```
