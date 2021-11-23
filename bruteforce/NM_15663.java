package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NM_15663{
  static FastReader sc = new FastReader();
  static StringBuilder sb = new StringBuilder();
  static int N,M;
  static int[] selected;
  static int[] nums;
  static int[] last_printed;
  static int[] used;

  static void input(){
    N = sc.nextInt();
    M = sc.nextInt();
    selected = new int[M+1];
    nums = new int[N+1];
    used = new int[N+1];
    for(int i=1; i<=N;i++){
      nums[i] = sc.nextInt();
    }
    Arrays.sort(nums,1,N+1);

  }
  static void rec_func(int k){
    if(k == M+1){
      for(int i=1;i<=M;i++)sb.append(selected[i]).append(' ');
      sb.append('\n');
    } else{
      int last_cand = 0;
      for(int cand = 1; cand <=N; cand++){
        if(used[cand] == 1) continue;
        if(nums[cand] == last_cand) continue;

        last_cand = nums[cand];
        selected[k] = nums[cand];
        used[cand] = 1;
        rec_func(k+1);
        selected[k] = 0;
        used[cand] = 0;
      }
    }
  }
  public static void main(String[] args) {
    input();
    rec_func(1);
    System.out.println(sb.toString());
  }
  static class FastReader{
    BufferedReader br;
    StringTokenizer st;
    public FastReader(){
      br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next(){
      while(st==null||!st.hasMoreElements()){
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
    String nextLine(){
      String str = "";
      try{
        str = br.readLine();
      }catch(IOException e){
          e.printStackTrace();
      }
      return str;
    }
  }
  
}