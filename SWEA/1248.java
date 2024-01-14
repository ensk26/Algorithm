import java.io.*;
import java.util.*;

class Solution {
  /*
   * 정점수 v, 간선 e 루트는 1
   */

  static class Node {
    int parent;
    int leftChild;
    int rightChild;
  }

  static Node[] graph;
  static int v;
  static int cnt;

  public static void getCnt(Node node) {
    if (node.leftChild != 0) {
      getCnt(graph[node.leftChild]);
    }
    if (node.rightChild != 0) {
      getCnt(graph[node.rightChild]);
    }
    cnt += 1;
  }

  public static int getCommParent(int a, int b) {
    boolean[] isVisited = new boolean[v + 1];

    while (a != 1) {
      isVisited[a] = true;
      a = graph[a].parent;
    }

    while (b != 1) {
      if (isVisited[b]) {
        return b;
      }
      b = graph[b].parent;
    }
    return 1;
  }

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T;
    T = Integer.parseInt(br.readLine());

    for (int test_case = 1; test_case <= T; test_case++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      v = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph = new Node[v + 1];
      for (int i = 0; i < v + 1; i++) {
        graph[i] = new Node();
      }

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < e; i++) {
        int p = Integer.parseInt(st.nextToken());
        int ch = Integer.parseInt(st.nextToken());

        if (graph[p].leftChild == 0) {
          graph[p].leftChild = ch;
        } else {
          graph[p].rightChild = ch;
        }
        graph[ch].parent = p;
      }

      cnt = 0;
      // 공통 부모 찾기
      int commParent = getCommParent(a, b);
      getCnt(graph[commParent]);

      System.out.println("#" + test_case + " " + commParent + " " + cnt);
    }
  }
}
