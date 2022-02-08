import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
// 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
// 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.

// 첫째 줄에 보드의 크기 N이 주어진다. (2 ≤ N ≤ 100) 다음 줄에 사과의 개수 K가 주어진다. (0 ≤ K ≤ 100)
// 다음 K개의 줄에는 사과의 위치가 주어지는데, 첫 번째 정수는 행, 두 번째 정수는 열 위치를 의미한다. 사과의 위치는 모두 다르며, 맨 위 맨 좌측 (1행 1열) 에는 사과가 없다.
// 다음 줄에는 뱀의 방향 변환 횟수 L 이 주어진다. (1 ≤ L ≤ 100)
// 다음 L개의 줄에는 뱀의 방향 변환 정보가 주어지는데,  정수 X와 문자 C로 이루어져 있으며. 게임 시작 시간으로부터 X초가 끝난 뒤에 왼쪽(C가 'L') 또는 오른쪽(C가 'D')로 90도 방향을 회전시킨다는 뜻이다. X는 10,000 이하의 양의 정수이며, 방향 전환 정보는 X가 증가하는 순으로 주어진다.

public class Main{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, K, L;
    static int[][] apple;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static ArrayList<String>[] info; 
    static boolean[][] visit;


    static void input(){
        N = scan.nextInt();
        K = scan.nextInt();
        apple = new int[N+1][N+1];
        visit = new boolean[N+1][N+1];
        for(int i=1; i<=K; i++){
            int x = scan.nextInt(), y = scan.nextInt();
            apple[x][y] = 1;
            apple[y][x] = 1;
        }
        info = new ArrayList;
        L = scan.nextInt();
        for(int i=1; i<=L; i++){

        }


    }

    public static void main(String[] args) {
        
    }
    
    static class FastReader{
        StringTokenizer st;
        BufferedReader br;

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