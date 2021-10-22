package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sort_1015 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] P;
    static Num[] A;

    public static void main(String[] args) {
        input();
        sort();
    }
    static class Num implements Comparable<Num>{
        public int num;
        public int idx;

        @Override
        public int compareTo(Num o) {
            return this.num-o.num;
        }
    }
    static void input(){
        N = scan.nextInt();
        P = new int[N];
        A = new Num[N];
        for(int i=0; i<N;i++){
            A[i] = new Num();
            A[i].num = scan.nextInt();
            A[i].idx = i;
        }

    }
    static void sort(){
        Arrays.sort(A);
        for(int i=0; i<N; i++){
            P[A[i].idx] = i;
            sb.append(P[i]).append(' ');
        }
        System.out.println(sb.toString());
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
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str ="";
            try{
                str= br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
