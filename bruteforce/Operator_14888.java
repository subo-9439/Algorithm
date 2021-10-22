package bruteforce;

import java.io.*;
import java.util.*;

public class Operator_14888 {
     static FastReader sc = new FastReader();
     static StringBuilder sb = new StringBuilder();

     static int N,max,min;
     static int[] nums, operator;

     static void input(){
         N = sc.nextInt();
         nums = new int[N+1];
         operator = new int[5];
         for(int i=1; i<=N;i++) nums[i] = sc.nextInt();
         for(int i=1; i<=4;i++) operator[i] = sc.nextInt();

         max= Integer.MIN_VALUE;
         min = Integer.MAX_VALUE;
     }
     static int calculator(int operand1, int operator, int operand2){
         if(operator==1) return  operand1+operand2;
         else if(operator==2) return  operand1-operand2;
         else if(operator==3) return  operand1*operand2;
         else return operand1/operand2;
     }
     static void rec_func(int k, int value){
         if(k==N){
             max = Math.max(max,value);
             min = Math.min(min,value);
         }else{
             for(int cand=1; cand<=4;cand++){
                 if(operator[cand]>=1){
                     operator[cand]--;
                     rec_func(k+1,calculator(value,cand,nums[k+1]));
                     operator[cand]++;
                 }
             }
         }
     }

     public static void main(String[] args) {
        input();
        // 1 번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1, nums[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}