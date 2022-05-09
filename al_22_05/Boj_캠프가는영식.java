package al_22_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_캠프가는영식 {
    static FastReader scan = new FastReader();
    static int N,T,sum;
    static int[] start;
    static ArrayList<Bus> busList;
    static ArrayList<Integer> arriveList;
    static int MIN = Integer.MAX_VALUE;
    static void input(){
        N = scan.nextInt();
        T = scan.nextInt();
        busList = new ArrayList<>();
        arriveList = new ArrayList<>();
        for(int i = 0; i<N; i++) {
            //시간, 간격 ,대수
            busList.add(new Bus(scan.nextInt(), scan.nextInt(), scan.nextInt()));
        }
    }

    static void pro(){
        for(Bus bus: busList){
            if(bus.start == T) arriveList.add(0);
            for(int i = 0; i < bus.cnt; i++){
                int arrive = bus.start+(i* bus.interval);
                if(arrive>=T && arrive <=1000000) {
                    arriveList.add(arrive);
                    MIN = Math.min(MIN,arrive-T);
                    break;
                }
            }
        }
        if(arriveList.size()==0) System.out.println(-1);
        else System.out.println(MIN);
    }
    public static void main(String[] args) {
        input();
        pro();
    }
    static class Bus{
        int start;
        int interval;
        int cnt;
        public Bus(int start, int interval, int cnt){
            this.start = start;
            this.interval = interval;
            this.cnt = cnt;
        }
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null ||!st.hasMoreTokens()){
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
