package al_22_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
Boj_14889 조합접근
*/
public class Boj_스타트와링크 {
    static FastReader scan = new FastReader();
    static int[][] board;
    static boolean[] visited;
    static int N;
    static int Min = Integer.MAX_VALUE;
    static void input(){
        N = scan.nextInt();
        visited = new boolean[N];
        board = new int[N][N];
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < N; j++){
                board[i][j] = scan.nextInt();
            }
        }
    }
    static void comb(int idx, int count){
        if(count == N / 2){
            calc();
            return;
        }
        for(int i = idx; i < N; i++){
            if(!visited[i]) {
                visited[i] = true;
                comb(i+1 , count + 1);
                visited[i] = false;
            }
        }
    }
    static void calc(){
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < N-1; i++){
            for(int j = i + 1; j < N; j++){
                //i번째 사람과 j 번째 사람이 true라면 스타트팀으로 점수
                if(visited[i] && visited[j]) {
                    team_start += board[i][j];
                    team_start += board[j][i];
                }
                //i번째 사람과 j번째 사람이 false라면 링크팀으로 점수
                else if(!visited[i] && !visited[j]){
                    team_link += board[i][j];
                    team_link += board[j][i];
                }
            }
        }
        int val = Math.abs(team_start-team_link);
        //더이상 찾을 필요가없으므로 시스템을 종료한다
        if(val == 0){
            System.out.println(val);
//            System.exit(0);
        }
        Min = Math.min(val,Min);
    }
    public static void main(String[] args) {
        input();
        comb(0,0);
        System.out.println(Min);

    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null|| !st.hasMoreTokens()){
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
    }
}
