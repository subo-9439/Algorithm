class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        int cursor = 0;
        boolean hasA = false;
        for(int i = 0; i < name.length(); i++){
            answer += Math.min(name.charAt(i)-'A', 'Z' - name.charAt(i) + 1);
            if(name.charAt(i) != 'A' ) {
                answer += cursor;
                cursor = 0;
            }
            cursor++;
            //A를 갖고 있는가
            if(name.charAt(i) == 'A') hasA = true;
            if(hasA && i == name.length()-1 && name.charAt(length-1) != 'A' ){
                answer-=1;
            }
        }
        return answer;
    }
}
