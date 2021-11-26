package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KEM_10825 {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Elem[] students;
    
    static class Elem implements Comparable<Elem>{
        private String name;
        private int kor, eng ,math;

        public Elem(String name, int kor, int eng, int math){
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Elem o) {
            if(this.kor != o.kor) return o.kor - this.kor;
            if(this.eng != o.eng) return this.eng - o.eng;
            if(this.math != o.kor && this.eng == o.eng) return o.math - this.math;
            return this.name.compareTo(o.name);
        }
        
    }
    static void pro(){
        Arrays.sort(students);
        for(int i=0; i<N; i++){
            sb.append(students[i].name).append('\n');
        }
        System.out.println(sb.toString());
    }
    static void input(){
        N = sc.nextInt();
        students = new Elem[N];
        for(int i=0; i<N; i++){
            Elem student = new Elem(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            students[i] = student;
        }
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