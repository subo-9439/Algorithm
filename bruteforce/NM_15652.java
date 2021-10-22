package bruteforce;

import java.io.*;
import java.util.*;
//중복YES 순서YES CASE1
//중복NO 순서YES CASE2
//중복Yes 순서NO CASE3 <<3번
//중복NO 순서NO CASE4
public class NM_15652 {
     static StringBuilder sb = new StringBuilder();
     static int N,M;
     static int[] selected;

     static void input(){
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         try{
             StringTokenizer st = new StringTokenizer(br.readLine());
             N = Integer.parseInt(st.nextToken());
             M = Integer.parseInt(st.nextToken());
             selected = new int[M+1];
         }catch (IOException e){
             e.printStackTrace();
         }
     }
     static void rec_func(int k){
         if(k==M+1){
             for(int i=1;i<=M;i++)sb.append(selected[i]).append(' ');
             sb.append('\n');
         }else {
             int start = selected[k-1];
             if(start==0)start=1;
             for(int cand=start;cand<=N;cand++){
                 selected[k] = cand;
                 rec_func(k+1);
                 selected[k] = 0;
             }
         }
     }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }
}