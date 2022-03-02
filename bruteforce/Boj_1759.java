package bruteforce;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//Boj_1759 암호 만들기
public class Boj_1759{
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int L,C;
    static int[] ans;
    static char[] code;
    
    static boolean[] visit;
    
    static boolean isVowel(char v){
        return (v == 'a' || v == 'e' || v == 'i' || v == 'o' || v == 'u') ;
    }
    static void input(){
        L = sc.nextInt();
        C = sc.nextInt();
        code = new char[C+1];
        ans = new int[L+1];
        visit = new boolean[C+1];
        String[] tokens = sc.nextLine().split(" ");
        for(int i = 1; i <= C; i++) code[i] = tokens[i-1].charAt(0);

    }
    static void rec_func(int k){
        //k == L
        if(k == L+1){
            int vowel_cnt = 0, consonant_cnt = 0;
            for(int i = 1; i <= L; i++){
                if(isVowel(code[ans[i]])) vowel_cnt++;
                else consonant_cnt ++;
            }
            if(vowel_cnt >= 1 && consonant_cnt >= 2){
                for(int i = 1; i <= L; i++) sb.append(code[ans[i]]);
                sb.append('\n');
            }
        }else{
            for(int cand = ans[k-1]+1; cand <= C; cand++){
                if(visit[cand])continue;
                visit[cand] = true; ans[k] = cand;
                rec_func(k+1);
                visit[cand] = false; ans[k] = 0;
            }
        }
         
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(code,1 ,C+1);
        rec_func(1);
        System.out.println(sb);

    }
    static class FastReader{
        static BufferedReader br;
        static StringTokenizer st;

        public FastReader() {
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
