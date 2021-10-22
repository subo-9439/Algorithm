package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KEM_10825 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Student[] a;

    static void input(){
        N = scan.nextInt();
        a = new Student[N];

        for(int i=0;i<N;i++){
            a[i] = new Student();
            a[i].name = scan.next();
            a[i].kor = scan.nextInt();
            a[i].eng = scan.nextInt();
            a[i].math = scan.nextInt();
        }
    }

    static void pro(){
        Arrays.sort(a);
        for(int i=0; i<N; i++){
            sb.append(a[i].name).append('\n');
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        input();
        pro();
    }
    static class Student implements Comparable<Student>{
        public String name;
        public int kor,eng,math;

        @Override
        public int compareTo(Student other){
            if(this.kor!=other.kor) return other.kor-this.kor;
            if(this.eng!=other.eng) return this.eng- other.eng;
            if(this.math!=other.math) return  other.math-this.math;

            return this.name.compareTo(other.name);
        }
    }
    static class FastReader{
         BufferedReader br ;
         StringTokenizer st;

         public FastReader(){
             br = new BufferedReader(new InputStreamReader(System.in));
         }

         String next(){
             while(st==null || !st.hasMoreElements()){
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
             String str="";
             try{
                 str = br.readLine();
             }catch (IOException e){
                 e.printStackTrace();
             }
             return str;
         }
    }
}
