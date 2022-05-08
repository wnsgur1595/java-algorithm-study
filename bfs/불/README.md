
# [불](https://www.acmicpc.net/problem/4179) 

지훈이는 미로에서 일을 한다. 지훈이를 미로에서 탈출하도록 도와주자!

미로에서의 지훈이의 위치와 불이 붙은 위치를 감안해서 지훈이가 불에 타기전에 탈출할 수 있는지의 여부, 그리고 얼마나 빨리 탈출할 수 있는지를 결정해야한다.

지훈이와 불은 매 분마다 한칸씩 수평또는 수직으로(비스듬하게 이동하지 않는다)  이동한다. 

불은 각 지점에서 네 방향으로 확산된다. 

지훈이는 미로의 가장자리에 접한 공간에서 탈출할 수 있다. 

지훈이와 불은 벽이 있는 공간은 통과하지 못한다.

### 입력
입력의 첫째 줄에는 공백으로 구분된 두 정수 R과 C가 주어진다. 단, 1 ≤ R, C ≤ 1000 이다. R은 미로 행의 개수, C는 열의 개수이다.

다음 입력으로 R줄동안 각각의 미로 행이 주어진다.

 각각의 문자들은 다음을 뜻한다.

#: 벽
.: 지나갈 수 있는 공간
J: 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)
F: 불이 난 공간
J는 입력에서 하나만 주어진다.


### 출력
지훈이가 불이 도달하기 전에 미로를 탈출 할 수 없는 경우 IMPOSSIBLE 을 출력한다.

지훈이가 미로를 탈출할 수 있는 경우에는 가장 빠른 탈출시간을 출력한다. 

### 예제

    4 4
    ####
    #JF#
    #..#
    #..#

    output : 3

# 풀이
지훈이는 불이 확산된 곳에는 이동할 수 없지만, 불은 벽만 아니라면 이동할 수 있기 때문에 먼저 불이 각 위치에 확산되는 가장 빠른 시간을 구한다. (불 bfs) 이때 불은 하나라는 제한이 없다는 걸 알아둬야 한다.

그리고 나서 지훈이가 각 장소에 도달할 수 있는 가장 빠른 시간을 구한다. (지훈 bfs)
단, 지훈이가 2초에 어떤 공간에 도착할 수 있다면 불은 최소 3초에 그 공간에 도착해야 한다.
그리고 불이 아예 도착하지 못하는 공간이 있을 수 있다는 점을 생각해야 한다(`fireVisited[nx][ny] == 0`)

### 코드

```java
Pair jPos = null;
for (int i = 0; i < r; i++) {
    map[i] = br.readLine().toCharArray();
    for (int j = 0; j < c; j++) {
        if (map[i][j] == 'J') {
            jPos = new Pair(i, j); // 지훈 위치
        } else if (map[i][j] == 'F') { // 불
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
        if (fireVisited[nx][ny] != 0 && fireVisited[nx][ny] <= jihunVisited[cur.x][cur.y] + 1) // 지훈이보다 먼저 불이 방문한 경우(못 지나가는 경우)
            continue;

        jihunVisited[nx][ny] = jihunVisited[cur.x][cur.y] + 1;
        q.add(new Pair(nx, ny));
    }
} // 지훈 bfs

System.out.println("IMPOSSIBLE");
```
