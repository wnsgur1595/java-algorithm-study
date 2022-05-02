
# [미로탐색](https://www.acmicpc.net/problem/2178) 🪙

N×M크기의 배열로 표현되는 미로가 있다.

미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

### 입력
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

### 출력
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

### 예제


    4 6
    101111
    101010
    101011
    111011

    output : 15

# 풀이
하나의 시작점에서 도착점까지의 거리를 구하는 문제이다. 현재 칸(`Pair cur`)의 상하좌우로 연결 된 칸들을 방문할 때, 현재 칸과 그 칸의 거리는 +1이 된다(`visited[nx][ny] = visited[cur.x][cur.y] + 1`). 

이를 이용해서, 시작점에서부터 모든 칸의 거리를 계산할 수 있다(시작점에서 얼마만큼 떨어져 있는지)

### 코드

```java
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
```
