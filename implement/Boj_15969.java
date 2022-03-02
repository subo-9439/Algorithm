package implement;

//Boj 15969
//행복
import java.util.Scanner;
public class Boj_15969 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    int[] arr = new int[N];
    for(int i = 0; i < N; i++){
      arr[i] = sc.nextInt();
      if(arr[i] < min) min = arr[i];
      if(arr[i] > max) max = arr[i];
    }
    System.out.println(max-min);
  }
}
