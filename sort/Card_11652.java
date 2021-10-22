package sort;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Card_11652 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static long[] arr;

    static void input(){
        N = scan.nextInt();
        arr = new long[N];
        for(int i=0; i<N; i++){
            arr[i] = scan.nextLong();
        }
    }

    static void sort(){
        Arrays.sort(arr);
        long mode= arr[0];
        int modeCnt = 1;
        int curCnt = 1;

        for(int i=1; i<N;i++){
             if(arr[i]==arr[i-1]) curCnt++;
             else curCnt = 1;
             if(modeCnt < curCnt){
                 modeCnt = curCnt;
                 mode = arr[i];
             }
        }
        System.out.println(mode);
    }

    public static void main(String[] args) {
        input();
        sort();
    }

    static class FastReader{
        BufferedReader br ;
        StringTokenizer st ;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next(){
            while(st==null||!st.hasMoreElements()){
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
            String str = "";
            try {
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
