import java.io.*;
import java.util.*;

public class Main {
  /*
   * 일곱난쟁이의 키가 합이 100이 되는 경우를 찾아야한다. 모든 경우의 수를 찾아 만족하는 경우를 구해야한다.
   */

  static List<Integer> result = new ArrayList<>();
  static int[] cm = new int[9];

  public static Boolean getSum(int depth, int cnt, int total) {

    if (cnt == 7 && total == 100) {
      return true;
    }
    if (cnt > 7 || depth == 9) {
      return false;
    }

    if (getSum(depth + 1, cnt + 1, total + cm[depth])) {
      result.add(cm[depth]);
      return true;
    }
    if (getSum(depth + 1, cnt, total)) {
      return true;
    }

    return false;
  }

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < 9; i++) {
      cm[i] = Integer.parseInt(br.readLine());
    }

    getSum(0, 0, 0);

    Collections.sort(result);
    for (int num : result) {
      System.out.println(num);
    }
  }
}
