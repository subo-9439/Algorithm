package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sum123_9095{
  static FastReader sc = new FastReader();
  static StringBuilder sb = new StringBuilder();
  static int[] dp;
  static void preprocess(){
    dp = new int[15];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    for(int i = 4; i <= 11; i++){
      dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
    }
  }
  public static void main(String[] args) {
    int T = sc.nextInt();
    preprocess();
    for(int i = 0; i < T ;i++){
      int n = sc.nextInt();
      sb.append(dp[n]).append('\n');
    }
    System.out.println(sb);
  }
  static class FastReader{
    BufferedReader br;
    StringTokenizer st;

    public FastReader(){
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next(){
      while(st == null || !st.hasMoreElements()){
        try{
          st = new StringTokenizer(br.readLine());
        }catch(IOException e){
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt(){
      return Integer.parseInt(next());
    }
  }
}