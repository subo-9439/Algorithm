package kakao;

// https://programmers.co.kr/learn/courses/30/lessons/60058
public class Pro_괄호변환 {
    public String solution(String p) {
        String answer = "";
        answer = dfs(p);
        return answer;
    }

    public String dfs(String p){
        if (p.length() == 0) return "";
        boolean flag = false;
        // 균형잡힌 문자열로 만들기
        char standard = p.charAt(0);
        int leftCnt = 1;
        int rightCnt = 0;
        int idx = 0;

        for (int j = 1; j < p.length(); j++){
            if(p.charAt(j) != standard) {
                rightCnt++;
            }else {
                leftCnt++;
            }
            if(leftCnt == rightCnt) {//마지막은 제외시켜야 조건멈춤
                idx = j+1;
                flag = true;
                break;
            }
        }

        String u = p.substring(0,idx);
        String v = p.substring(idx,p.length());

        v = dfs(v);
        if(isCorrect(u)){
            return u+v;
        }else {
            String n;
            n = "(" + v +")";
            String b = u.substring(1,u.length()-1);
            for (int pp = 0; pp < b.length(); pp++){
                if(b.charAt(pp)== '(') n+= Character.toString(')');
                else n += Character.toString('(');
            }
            return  n;
        }

    }
    public boolean isCorrect(String p){
//       u ((()())()) v ""
        //
        int leftCnt = 0;
        int rightCnt = 0;
        for (int i = 0; i < p.length()/2; i++){
            if(p.charAt(i) == ')') rightCnt++;
            else leftCnt++;

            if(leftCnt-rightCnt < 0) return false;
        }

        return true;
    }
}
