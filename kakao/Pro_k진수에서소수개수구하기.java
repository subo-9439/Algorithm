package kakao;


//프로그래머스 k진수에서 소수 개수 구하기
public class Pro_k진수에서소수개수구하기 {
  public int solution(int n, int k) {
    int answer = 0;
    String str = "";
    //진수 바꾸기
    while(n>0){
      str = (n%k) + str;
      n /= k;
    }
    String[] nums = str.split("[0]+");
    // for(int i = 0 ; i <nums.length; i++) System.out.println(i+"="+nums[i]);

    for(String num : nums){
      long a = Long.parseLong(num);
      if(primeNumber(a)) answer++;

    }

    return answer;
}

//소수 판별(에라토스테네스의 체)
static boolean primeNumber(long num){
  if(num < 2) return false;
  for(int i = 2; i<= Math.sqrt(num); i++){
    if(num%i == 0){
      return false;
    }
  }
  return true;
}
}
