import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
// 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
// 입력
// 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
// 출력
// 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
// 예제 입력 1 
// 5 17
public class Main{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N,K;
    static boolean[] visit;
    static int[] dist;

    static void input(){
        N = scan.nextInt();
        K = scan.nextInt();
        visit = new boolean[100001];
        dist = new int[100001];
    }
    static void bfs(){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(N);
        visit[N] = true;

        while(!Q.isEmpty()){
            int x = Q.poll();
            if(x - 1 >= 0 && !visit[x-1]){
                visit[x-1] = true;
                dist[x - 1] = dist[x] + 1;
                Q.add(x-1);
            }
            if(x + 1 <= 100000 && !visit[x+1]){
                visit[x+1] = true;
                dist[x+1] = dist[x] + 1;
                Q.add(x+1);
            }
            if(x * 2 <= 100000 && !visit[x*2]){
                visit[2*x] = true;
                dist[2*x] = dist[x] + 1;
                Q.add(x * 2);
            }
        }
    }
    static void pro(){
        bfs();
        System.out.println(dist[K]);
    }
    public static void main(String[] args) {
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