import java.io.*;
import java.util.*;

class Solution {
  static class Node {
    int r;
    int c;
    int time;

    Node(int r, int c, int time) {
      this.r = r;
      this.c = c;
      this.time = time;
    }
  }

  static int[][] arr;
  static int[][] visited;
  static int n;
  static Queue<Node> q = new LinkedList<>();
  static int[][] drcs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

  public static int getMinTime() {
    int minTime = Integer.MAX_VALUE;
    q.offer(new Node(0, 0, 0));

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if (cur.r == n - 1 && cur.c == n - 1) {
        minTime = Math.min(minTime, cur.time);
        continue;
      }
      for (int[] drc : drcs) {
        int nr = drc[0] + cur.r;
        int nc = drc[1] + cur.c;
        if (0 <= nr && nr < n && 0 <= nc && nc < n && visited[nr][nc] > cur.time + arr[nr][nc]) {
          visited[nr][nc] = cur.time + arr[nr][nc];
          q.offer(new Node(nr, nc, cur.time + arr[nr][nc]));
        }
      }
    }
    return minTime;
  }

  public static void main(String args[]) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T;
    T = Integer.parseInt(br.readLine());

    for (int test_case = 1; test_case <= T; test_case++) {

      n = Integer.parseInt(br.readLine());
      arr = new int[n][n];

      for (int i = 0; i < n; i++) {
        String st = br.readLine();
        for (int j = 0; j < n; j++) {
          arr[i][j] = st.charAt(j) - '0';
        }
      }

      visited = new int[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          visited[i][j] = Integer.MAX_VALUE;
        }
      }

      System.out.println("#" + test_case + " " + getMinTime());
    }
  }
}
