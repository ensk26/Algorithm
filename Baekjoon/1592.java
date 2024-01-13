import java.io.*;
import java.util.*;

public class Main {
  /*
   * 1~N 까지의 자리가 있다. 
   * 한 사람이 공을 M번 받으면 끝난다. 
   * 공 받는 횟수 홀수 -> 시계 방향 L번째 사람에게 준다. 
   * 공 받는 횟수 짝수 -> 반시계 방향 L번째 사람에게 준다. 
   * 인덱스 0이 1번 자리라서 홀수와 짝수 조건을 반대로 생각한다.
   */

  static int n;

  public static int getValidPos(int pos) {
    if (pos >= n) {
      return pos - n;
    } else if (pos < 0) {
      return pos + n;
    }
    return pos;
  }

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());
    int[] ballCnt = new int[n];
    int pos = 0;
    ballCnt[pos] = 1;
    int cnt = 0;

    while (ballCnt[pos] < m) {
      if (ballCnt[pos] % 2 == 0) {
        pos = getValidPos(pos + l);
      } else {
        pos = getValidPos(pos - l);
      }
      ballCnt[pos] += 1;
      cnt++;
    }
    System.out.print(cnt);
  }
}
