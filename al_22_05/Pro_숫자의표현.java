package al_22_05;
import java.util.ArrayList;
public class Pro_숫자의표현 {
        //     public int solution(int num) {
//          int answer = 0;
//        for (int i = 1; i <= num; i += 2) {
//            if (num % i == 0) {
//                answer++;
//            }
//        }
//        return answer;
// }
        public static void main(String[] args) {
            System.out.println(solution(20));
        }
        public static int solution(int n) {
            int sum = 0;
            int answer =0;
            //15이하
            //1~15
            //1~15
            int R = 1;
            int L = 1;

            while (L <= n ){
                if (sum <= n){
                    if(sum == n) answer++;
                    sum+=R;
                    R++;
                }
                else {
                    sum-=L;
                    L++;
                    System.out.println("L은" + L);
                }
            }
            return answer;
        }
}
