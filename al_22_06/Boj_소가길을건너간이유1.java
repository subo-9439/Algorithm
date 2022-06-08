package al_22_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

//
public class Boj_소가길을건너간이유1 {

    static FastReader scan = new FastReader();
    static int N;
    static Map<Integer, Stack<Integer>> map;
    static void input(){
        N = scan.nextInt();
        map = new HashMap<>();

        for (int i = 0; i < N; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            Stack<Integer> stack = map.getOrDefault(x,new Stack<>());
            if(stack.size() != 0 && stack.peek() == y) continue;

            stack.push(y);
            map.put(x,stack);
        }

    }
    static void pro(){
        int cnt = 0;
        for (Integer key : map.keySet()){
            Stack<Integer> a = map.get(key);
            while (!a.isEmpty()){
                int cur = a.pop();
                if(a.size()!=0 && cur != a.peek()){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
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
            while (st==null || !st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e) {
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
