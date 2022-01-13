package binarysearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Boj_3273
// 문제
// n개의 서로 다른 양의 정수 a1, a2, ..., an으로 이루어진 수열이 있다. ai의 값은 1보다 크거나 같고, 1000000보다 작거나 같은 자연수이다. 자연수 x가 주어졌을 때, ai + aj = x (1 ≤ i < j ≤ n)을 만족하는 (ai, aj)쌍의 수를 구하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 수열의 크기 n이 주어진다. 다음 줄에는 수열에 포함되는 수가 주어진다. 셋째 줄에는 x가 주어진다. (1 ≤ n ≤ 100000, 1 ≤ x ≤ 2000000)

// 출력
// 문제의 조건을 만족하는 쌍의 개수를 출력한다.
public class Boj_3273 {
    
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static int[] A;
    static int sum;
    static void input(){
        N = scan.nextInt();
        A = new int[N+1];
        for(int i = 1; i <= N; i++){
            A[i] = scan.nextInt();
        }
        sum = scan.nextInt();
    }
    static boolean find(int[] A, int L, int R, int X){
        while(L <= R){
            int mid = (L+R) / 2;
            if(A[mid] == X){
                return true;
            }
            if(A[mid] < X){
                L = mid + 1;
            }else {
                R = mid - 1;
            }
        }
        return false;
    }
    static void pro() {
        int cnt = 0;
        for(int i = 1; i < N; i++){
            if(find(A, i+1, N, sum-A[i])){
                cnt++;
            }
        }
        sb.append(cnt);
    }
    public static void main(String[] args) {
        input();
        Arrays.sort(A,1,N+1);
        pro();
        System.out.println(sb);

    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}