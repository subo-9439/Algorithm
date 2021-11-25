package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class WordSort_1181{
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static String[] words;
    
    static class Mycomparator implements Comparator<String> {
        @Override
        public int compare(String lhs, String rhs){
            if(lhs.length() != rhs.length()){
                return lhs.length() - rhs.length();
            }
            return lhs.compareTo(rhs);
        }
    }
    static void input(){
        N = sc.nextInt();
        words = new String[N];
        for(int i=0; i<N; i++) words[i] = sc.next();
    }
    static void pro(){
        Arrays.sort(words, new Mycomparator());
        for(int i=0; i<N; i++){
            if(i == 0 || words[i].compareTo(words[i-1])!=0)
            sb.append(words[i]).append('\n');
        }
        System.out.println(sb);
    }
    public static void main(String[] args) {
        input();
        pro();
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