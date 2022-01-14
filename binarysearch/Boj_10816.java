package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
// 셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
// 10
// 6 3 2 10 10 10 -10 -10 7 3
// 8
// 10 9 -5 2 3 4 5 -10

// 출력
// 첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.
// 3 0 0 1 2 0 0 2
// lower_bound, upper_bound 이용
public class Boj_10816 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N,M;
    static int[] cards, finds;
    static void input(){
        N = scan.nextInt();
        cards = new int[N+1];
        for(int i=1; i<=N; i++){
            cards[i] = scan.nextInt();
        }
        //
        M = scan.nextInt();
        finds = new int[M];
        for(int i=0; i<M ;i++){
            finds[i] = scan.nextInt();
        }

        
    }
    static int lower_bound(int[] arr, int L, int R, int X){
        int ans = R + 1;
        while(L <= R){
            int mid = (L+R)/2;
            if(arr[mid] >= X) {
                R = mid - 1;
                ans = mid;
            }else{
                L = mid + 1;
            }
        }
        return ans;
    }
    static int upper_bound(int[] arr, int L, int R, int X){
        int ans = R + 1;
        while(L <= R) {
            int mid = (L+R)/2;
            if(arr[mid] > X){
                R = mid - 1;
                ans = mid;
            }else {
                L = mid + 1;
            }

        }
        return ans;
    }
    static void pro(){
        Arrays.sort(cards,1,N+1);
        for(int find:finds){
            int upper = upper_bound(cards, 1, N, find);
            int lower = lower_bound(cards, 1, N, find);
            sb.append(upper-lower).append(' ');
            }
        System.out.println(sb);
    }
    public static void main(String[] args){
        input();
        pro();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null || !st.hasMoreElements()){
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