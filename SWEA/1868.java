import java.io.*;
import java.util.*;

class Solution {

  /*
   * 지뢰 * : -1
   기준점에서 8방향, 주변 지뢰 개수를 저장 
   임의의 위치에서 주변 지뢰 개수가 0이면, 해당 위치에서 8방향 확인
   확인한 값이 0이면 이동해 그 주변도 확인
   */

  static class Node {
    int r;
    int c;

    Node(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  static int n;
  static int arr[][];
  static int[][] drcs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
  static Queue<Node> q = new LinkedList<>();

  public static void findValidNumber() {
    while (!q.isEmpty()) {
      Node cur = q.poll();

      for (int[] drc : drcs) {
        int nr = cur.r + drc[0];
        int nc = cur.c + drc[1];
        if (0 <= nr && nr < n && 0 <= nc && nc < n && arr[nr][nc] != -1) {
          if(arr[nr][nc]==0) {
            q.offer(new Node(nr, nc));						
          }
          arr[nr][nc] = -1;
        }
      }
    }
  }

  public static void setNumber() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (arr[i][j] == 0) {
          for (int[] drc : drcs) {
            int nr = i + drc[0];
            int nc = j + drc[1];
            if (0 <= nr && nr < n && 0 <= nc && nc < n && arr[nr][nc] == -1) {
              arr[i][j] += 1;
            }
          }
        }
      }
    }
  }

  public static void main(String args[]) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int test_case = 1; test_case <= T; test_case++) {
      n = Integer.parseInt(br.readLine());
      arr = new int[n][n];

      for (int i = 0; i < n; i++) {
        String temp = br.readLine();
        for (int j = 0; j < n; j++) {
          if (temp.charAt(j) == '*') {
            arr[i][j] = -1;
          } else {
            arr[i][j] = 0;
          }

        }
      }

      setNumber();

      int cnt = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (arr[i][j] == 0) {
            arr[i][j] = -1;
            q.offer(new Node(i, j));
            findValidNumber();
            cnt++;
          }
        }
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (arr[i][j]!=-1) {
            cnt++;
          }
        }
      }

      System.out.println("#" + test_case + " " + cnt);
    }
  }
}
