import java.io.*;
import java.util.*;

class Main {
  // 남학생 1, 여학생 2

  static String[] lights;
  static int n;

  // 자기가 받은수 배수
  public static void man(int num) {
    for (int i = num; i <= n; i += num) {
      if (lights[i - 1].equals("0")) {
        lights[i - 1] = "1";
      } else {
        lights[i - 1] = "0";
      }
    }
  }

  // 인접한 두수가 값이 같으면
  public static void women(int num) {
    int k = 0;
    while (0 <= num - k && num + k < n) {
      if (lights[num - k].equals(lights[num + k])) {
        if (lights[num - k].equals("0")) {
          lights[num - k] = lights[num + k] = "1";
        } else {
          lights[num - k] = lights[num + k] = "0";
        }
        k++;
      } else {
        break;
      }
    }
  }

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    lights = br.readLine().split(" ");
    int cnt = Integer.parseInt(br.readLine());

    for (int i = 0; i < cnt; i++) {
      String[] info = br.readLine().split(" ");
      if (info[0].equals("1")) {
        man(Integer.parseInt(info[1]));
      } else {
        women(Integer.parseInt(info[1]) - 1);
      }
    }
    for (int i = 0; i <= (n - 1) / 20; i++) {
      for (int j = 20 * i; j < Math.min(n, 20 * (i + 1)); j++) {
        System.out.print(lights[j] + " ");
      }
      System.out.println();
    }
  }
}