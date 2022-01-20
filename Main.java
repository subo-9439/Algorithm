import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class State{
    int[] X;
    State(int[] X){
        this.X = new int[3];
        for(int i=0; i<3; i++){
            this.X[i] = X[i];
        }
    }

    State move(int from, int to, int[] Limit){

        int[] nX = new int[] {X[1],X[2],X[3]};
        if(nX[from] + nX[to] <= Limit[to]){
            nX[to] = nX[from] + nX[to];
            nX[from] = 0;
        }else{
            nX[to] = Limit[to];
            nX[from] -= Limit[to] -nX[to]; 
        }

        return new State(nX);
    }
}
public class Main{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] Limit;
    static boolean[] possible;
    static boolean[][][] visit;

    static void input(){
        Limit = new int[3];
        for(int i=0; i<3; i++){
            Limit[i] = scan.nextInt();
        }
        possible = new boolean[205];
        visit = new boolean[205][205][205];
    }
    public static void main(String[] args) {
        
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

        int nextInt(){
            return Integer.parseInt(next());
        }
        
    }
}