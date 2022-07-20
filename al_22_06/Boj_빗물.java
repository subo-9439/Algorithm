package al_22_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//14719
//구현 시뮬레이션 문제
//각 인덱스 위치에서 왼쪽에서 봤을 때 오른쪽으로 봤을때 가장 큰 높이를 찾는다.
//왼쪽과 오른쪽중의 큰 값 중 작은값을 더한다.
public class Boj_빗물 {
    static FastReader scan = new FastReader();
    static int N,M;
    static int[] arr;
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[M];
        for (int i = 0; i < M; i++){
            arr[i] = scan.nextInt();
        }
    }
    static void pro(){
        int sum = 0;
        for (int i = 1; i < M ; i++){
            int left = 0,right = 0;
            //왼쪽으로 향할 때 가장 큰 높이
            int max = 0;
            for (int L = i; L >=0; L--){
                left = Math.max(arr[L],left);
            }
            //오른쪽으로 향할 때 가장 큰 높이
            for (int R = i; R < M; R++){
                right = Math.max(arr[R],right);
            }
            //왼쪽중 큰 높이와 오른쪽중  큰높이 중 작은 값을 더해준다.
            sum += Math.min(left,right)-arr[i];
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        input();
        pro();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null || !st.hasMoreTokens()){
                try {
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
    }
}
