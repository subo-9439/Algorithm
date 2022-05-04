package al_22_05;

//
public class Pro_서울에서김서방찾기 {
    public String solution(String[] seoul) {
        String answer = "";
        int idx = -1;

        for(int i = 0; i < seoul.length; i++){
            if(seoul[i].equals("Kim")){
                idx = i;
                break;
            }
        }
        answer = String.format("김서방은 %d에 있다", idx);
        return answer;
    }
}
