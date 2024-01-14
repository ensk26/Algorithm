import java.util.*;
import java.io.*;

/*
* 장애물 1, 소용돌이 2, 빈 공간 0
* 소용돌이 사라지는 시간 2,5,8,11,14 .. n%3==2
* 소용돌이가 사라지기까지 걸리는 시간 1 : n%3==1
* 소용돌이가 사라지기까지 걸리는 시간 2 : n%3==0
* 이동할 수 있는 모든 공간은 1 시간이 걸린다.
* 경로가 없으면 -1 출
*/

class Node {
  int r, c, time;

  Node(int r, int c, int time) {
    this.r = r;
    this.c = c;
    this.time = time;
  }
}

class Solution {
  static int[][] drcs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Queue<Node> q = new LinkedList<>();
    int T;
    T = Integer.parseInt(br.readLine());

    for (int test_case = 1; test_case <= T; test_case++) {
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][n];
      int[][] visited = new int[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          visited[i][j] = Integer.MAX_VALUE;
        }
      }

      StringTokenizer st;
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      q.offer(new Node(a, b, 0));

      st = new StringTokenizer(br.readLine());
      int c = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      int result = Integer.MAX_VALUE;

      while (!q.isEmpty()) {
        Node cur = q.poll();

        if (cur.r == c && cur.c == d) {
          result = Math.min(result, cur.time);
        }

        for (int[] drc : drcs) {
          int nr = drc[0] + cur.r;
          int nc = drc[1] + cur.c;
          if (0 <= nr && nr < n && 0 <= nc && nc < n && arr[nr][nc] != 1) {
            if (arr[nr][nc] == 2 && cur.time % 3 == 2 && visited[nr][nc] > cur.time + 1) {
              visited[nr][nc] = cur.time + 1;
              q.offer(new Node(nr, nc, cur.time + 1));
            } else if (arr[nr][nc] == 2 && cur.time % 3 == 0 && visited[nr][nc] > cur.time + 3) {
              visited[nr][nc] = cur.time + 3;
              q.offer(new Node(nr, nc, cur.time + 3));
            } else if (arr[nr][nc] == 2 && cur.time % 3 == 1 && visited[nr][nc] > cur.time + 2) {
              visited[nr][nc] = cur.time + 2;
              q.offer(new Node(nr, nc, cur.time + 2));
            } else if (arr[nr][nc] == 0 && visited[nr][nc] > cur.time + 1) {
              visited[nr][nc] = cur.time + 1;
              q.offer(new Node(nr, nc, cur.time + 1));
            }
          }
        }
      }
      if (result == Integer.MAX_VALUE) {
        result = -1;
      }
      System.out.println("#" + test_case + " " + result);
    }
  }
}
