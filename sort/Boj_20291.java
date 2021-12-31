import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_20291 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] a;

    static void input (){
        N = scan.nextInt();
        a = new String[N+1];
        for (int i = 1; i <= N; i++){
            a[i] = scan.nextLine().split("\\.")[1];
        }
    }

    static void pro(){
        Arrays.sort(a, 1, N+1);
        for (int i = 1; i <= N; ){
            int cnt = 1, j = i + 1;
            for( ; j <= N; j++){
                if(a[j].compareTo(a[i]) == 0) cnt ++;
                else break;
            }

            sb.append(a[i]).append(' ').append(cnt).append('\n');
            i = j;
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
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}