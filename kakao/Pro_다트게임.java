package kakao;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pro_다트게임 {
        public static int solution(String dartResult) {
            int answer = 0;
            Pattern p1 = Pattern.compile("([0-9]0?[S|D|T][*|#]?)");
            Matcher matcher = p1.matcher(dartResult);

            ArrayList<Integer> list = new ArrayList<>();
            //3스테이지
            int idx = 0;
            while (matcher.find()) {
//            System.out.println(matcher.group());
                Pattern p2 = Pattern.compile("([0-9]0?)|([SDT])|([*#])");
                Matcher matcher2 = p2.matcher(matcher.group());
                int num = 0;
                while (matcher2.find()) {
//                System.out.println(matcher2.group());
                    if(matcher2.group().equals("S")) num = (int)Math.pow(num,1);
                    else if(matcher2.group().equals("D")) num = (int)Math.pow(num,2);
                    else if(matcher2.group().equals("T")) num = (int)Math.pow(num,3);
                    else if(matcher2.group().equals("*")){
                        if(idx!=0){
                            list.set(idx-1,list.get(idx-1)*2);
                        }
                        num = num*2;
                    }else if(matcher2.group().equals("#")){
                        num = -num;
                    }else {
                        num = Integer.parseInt(matcher2.group());
                    }
                }

                list.add(num);
                idx++;

            }
            for (int i : list){
                answer+=i;
                System.out.println("중간과정" + answer);
                System.out.println(i);
            }
            return answer;
        }

        public static void main(String[] args) {
            System.out.println("정답은" + solution("1D2S#10S"));

        }

    }
