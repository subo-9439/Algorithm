package kakao;

public class Pro_비밀지도 {
  class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n ; i++){
            String temp = Integer.toBinaryString(arr1[i]|arr2[i]);
            System.out.println(temp);  


            //길이가 넘어가는거 처리
            int length = n;
            while(length-- > temp.length()){
                sb.append(' ');
            }

            //
            for(int j = 0 ; j < temp.length(); j++){
                if(temp.charAt(j) == '1') sb.append('#');
                else sb.append(' ');
            }
            answer[i] = sb.toString();
            sb.setLength(0);
        }

        return answer;
    }
}

}
