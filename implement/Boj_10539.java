package implement;
import java.util.Scanner;

//Boj_10539
//수빈이와 수열
public class Boj_10539 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int N = sc.nextInt();
    int[] arr = new int[N+1];
    int[] ans = new int[N+1];
    for(int i = 1; i <= N; i++){
      arr[i] = sc.nextInt();
      ans[i] = i*arr[i] - (i-1)*arr[i-1];
      sb.append(ans[i]).append(' ');
    }
    System.out.println(sb);
  }
}
