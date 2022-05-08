
# [숨바꼭질](https://www.acmicpc.net/problem/1697)

수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

### 입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

### 출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

### 예제

    5 17

    output : 4

# 풀이
수빈이는 일초에 +1, -1, *2칸 이동할 수 있다.
이때 현재 수빈이와 동생은 `0~100,000` 사이에 위치한다.
    - 단, 수빈이가 계속 `0~100,000` 사이에서 이동해야 한다는 것은 아니기 때문에 이 점을 유의해야 한다. 이 문제에서는 사실 상관 없다.

수빈이가 5번칸에 있고, 동생이 17번칸에 있는 상황이라면 `5-10-9-18-17`으로 이동하는게 가장 빠른 경로이고 이때의 정답은 4초이다.

### 경우의 수
```
5
4                       6                       10
3       8               7   12                  9       11      20
2   6   16              14  13  24              18      22      19  21  40
1       15 17  28       26  23  25  48          17      ... 생략
```

이미 방문했던 칸에 방문하지 않아도 된다. 어떤 경로로 그 칸에 도달했던, 우리는 **가장 빠른 시간**을 찾아야 하기 때문에 이미 방문했던 칸을 또 방문하는 것은 더 느린 시간에 도달하는 경로를 찾는 것이다.

> bfs로 풀 수 있는 문제는 어떤 지점에 가장 빨리 도착한 경우가 다른 지점에도 가장 빨리 도착한다는 게 보장되어야 한다.

### 코드

```java
if (k <= n) { // 수빈이는 뒤로 갈 때는 한칸씩밖에 가지 못하니까 동생이 뒤에 있다면 그냥 뺀다
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
    for (int i = 0; i < size; i++) { // 시간 계산을 위한 for문
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
```
