package kakao;

public class Pro_신규아이디추천 {
  class Solution {
    public String solution(String new_id) {
        String answer;
        // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        String id = new_id.toLowerCase();
        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        id = id.replaceAll("[^-_.a-z0-9]", "");
        // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        id = id.replaceAll("[.]{2,}", ".");
        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        id = id.replaceAll("^[.]|[.]$", "");
        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(id.isBlank()) id = "a";
        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        if(id.length() >= 16){
            id = id.substring(0,15);
        //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
            id = id.replaceAll("[.]$", "");
        }
        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        while(id.length()<=2){
            id+= id.charAt(id.length()-1);
        } 
        return answer = id;
    }
}

// class Solution {
//     public String solution(String new_id) {
//         String answer = "";
//         StringBuilder sb = new StringBuilder();
//         String temp ="";
//         //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
//         temp = new_id.toLowerCase();
//         //2단계 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
//         char[] temp_arr = temp.toCharArray();
//         for(char c: temp_arr){
//             if((c >= 'a' && c <= 'z') || (c >= '0' && c <='9') || c =='-' || c=='_' || c=='.'){
//                 sb.append(c);
//             } 
//         }
//         temp = sb.toString();
//         //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
//         while(temp.contains("..")){
//             temp = temp.replace("..",".");
//         }

//         //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
//         if(temp.length()>0){
//             if(temp.startsWith("."))temp = temp.substring(1, temp.length());
//         }
//         if(temp.length()>0){
//             if(temp.endsWith("."))temp = temp.substring(0, temp.length()-1);
//         }

//         //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다
//         if(temp.isBlank()) 
//             temp = "a";
//         // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//         // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
//         if(temp.length() >= 16){
//             temp = temp.substring(0,15);
//         }
//         if(temp.endsWith(".")) temp = temp.substring(0, temp.length()-1);
//         //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
//         while(temp.length()<=2){
//             temp += temp.charAt(temp.length()-1);
//         }
//         return answer = temp;
//     }
// }
}
