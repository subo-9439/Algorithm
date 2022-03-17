package kakao;

public class Pro_키패드누르기 {
    class Solution {
        Pos left;
        Pos right;

        public String solution(int[] numbers, String hand) {

            String answer = "";
            // 1. 왼손 오른손 위치를 초기화
            left = new Pos(3,0);
            right = new Pos(3,2);

            for(int num : numbers){
                // 2. 숫자를 누를 손가락 정하기
                Pos posNum = new Pos((num-1)/3,(num-1)%3);
                if(num == 0) {
                    posNum = new Pos(3,1);
                }
                String finger = posNum.getFinger(hand);

                //3. 정해진 손가락을 answer에 담고 손가락 위치 이동
                answer += finger;

                if(finger.equals("L"))
                    left = posNum;
                else
                    right = posNum;
            }
            return answer;
        }

        class Pos{
            int row;
            int col;

            public Pos(int row, int col){
                this.row = row;
                this.col = col;
            }

            public String getFinger(String hand){
                String finger = hand.equals("right")? "R":"L";

                if(this.col == 0) finger = "L";
                else if(this.col == 2) finger = "R";
                else{
                    int leftDist = left.getDistance(this);
                    int rightDist = right.getDistance(this);

                    if(leftDist < rightDist)
                        finger = "L";
                    else if(rightDist < leftDist)
                        finger = "R";

                }
                return finger;
            }

            public int getDistance(Pos p){
                return Math.abs(this.row - p.row) + Math.abs(this.col - p.col);
            }
        }

    }
}
