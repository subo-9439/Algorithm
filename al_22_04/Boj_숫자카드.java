package al_22_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*백준 10815
    이분탐색
    L값과 R값 잘생각해서 하기
 */
public class Boj_숫자카드 {
    static FastReader scan = new FastReader();
    static int N,M;
    static int[] cards;
    static int[] needCards,ans;

    static void input(){
        N = scan.nextInt();
        cards = new int[N];
        for(int i = 0 ; i <N ;i++) cards[i] = scan.nextInt();

        M = scan.nextInt();
        needCards = new int[M];
        ans = new int[M];
        for(int i = 0 ; i <M ;i++) needCards[i] = scan.nextInt();
    }
    static void pro(){
        Arrays.sort(cards);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < M; i++){
            ans[i] =determinant(needCards[i]);
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
    static int determinant(int x){
        int L = 0; int R = N-1;
        int val=0;
        while (L<=R){
            int mid = (L+R)/2;
            if(x > cards[mid]){
                L= mid + 1;
            }else if(x < cards[mid]){
                R = mid - 1;
            }else {
                val = 1;
                break;
            }
        }
        return val;
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
            while (st == null || !st.hasMoreTokens()){
                try {
                    st  = new StringTokenizer(br.readLine());
                }catch (IOException e){
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
