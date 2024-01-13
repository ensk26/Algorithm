import java.io.*;

public class Main {
  /*
   * 규칙: 1(1개),7(2개),19(3개),37(4개), 61(5개) 각 6의 배수 차이를 가진다.
   */

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int total = 1;
    int cnt = 1;
    while (n > total) {
      total += 6 * cnt;
      cnt++;
    }
    System.out.println(cnt);
  }
}
