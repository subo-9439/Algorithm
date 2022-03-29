import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();

        for(int i = 0 ; i < records.length; i++){
            String[] rec = records[i].split(" ");
            //0 시간 / 1 번호 / 2 IN.OUT
            StringTokenizer st = new StringTokenizer(rec[0],":");
            //시간을 분으로 계산
            int time = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
            String IO = rec[2];
            int carNum = Integer.parseInt(rec[1]);
            //IN이라면  시간을 -로
            if(IO.equals("IN")){
                time = -time;
            }
            char a = 's';
            int s = (int) a;

            //만약 map에 carNum이 없다면 ArrayList 생성
            // 있다면 list에 값추가
            if(map.containsKey(carNum)){
                map.get(carNum).add(time);
            }else {
                map.put(carNum,new ArrayList<>(Arrays.asList(time)));
            }
        }


        int[] answer = new int[map.size()];
        int idx=0;

        //차량에 맞게
        for(int carNum : map.keySet()){
            int res = 0;
            //만약 IN OUt이 짝수가 아니면 23: 59 넣어줘야함
            if(map.get(carNum).size()%2 != 0) res = 23*60+59;

            //차량에 입출차 합산
            for(int i :map.get(carNum)){
               res+=i;
            }
//            System.out.println(res);

            //만약 기본시간을 못채운다면 기본요금만 지불
            if(res < fees[0]) answer[idx++] = fees[1];
            else
                answer[idx++] = fees[1]+ (int)Math.ceil((res-fees[0]) /(double)fees[2]) * fees[3];
        }
        return answer;
    }
}