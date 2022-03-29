package 날짜별.a220329;
import java.util.*;

//카카오
public class Pro_주차요금계산 {
        public int[] solution(int[] fees, String[] records) {
            Map<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();

            for(int i = 0 ; i < records.length; i++){
                String[] rec = records[i].split(" ");
                //0 시간 / 1 번호 / 2 IN.OUT

                StringTokenizer st = new StringTokenizer(rec[0],":");
                int time = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
                String IO = rec[2];
                int carNum = Integer.parseInt(rec[1]);
                if(IO.equals("IN")){
                    time = -time;
                }
                if(map.containsKey(carNum)){
                    map.get(carNum).add(time);
                }else {
                    map.put(carNum,new ArrayList<>(Arrays.asList(time)));
                }
            }
            int[] answer = new int[map.size()];
            int idx=0;
            for(int carNum : map.keySet()){
                int res = 0;
                if(map.get(carNum).size()%2 != 0) res = 23*60+59;
                for(int i :map.get(carNum)){
                    res+=i;
                }
                System.out.println(res);
                if(res < fees[0]) answer[idx++] = fees[1];
                else
                    answer[idx++] = fees[1]+ (int)Math.ceil((res-fees[0]) /(double)fees[2]) * fees[3];
            }
            return answer;
        }
}
