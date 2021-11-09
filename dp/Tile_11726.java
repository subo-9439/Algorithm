package dp;

import java.util.Scanner;

public class Tile_11726{
  static Scanner sc = new Scanner(System.in);
  static int N;
  static int[] dp;

  static void input(){
    N = sc.nextInt();
  }

  static void pro(){
    dp = new int[1005];
    dp[1] = 1;
    dp[2] = 2;
    for(int i = 3; i <= N; i++){
      dp[i] = (dp[i-1] + dp[i-2])%10007;
    }
    System.out.println(dp[N]);
  }
  public static void main(String[] args){
    input();
    pro();
  }
}