package al_22_06;

public class 유클리드호제법 {
    //최대 공약수 구하는법
    //숫자 두개 가 있을 때 ex)M,N
    //N과 M%N 을 비교해준다.
    //어떤 수가 더 큰 지 미리 알필요가 없다.
    //재귀로 인해 다시 돌기떄문이다.
    public int GCD(int M, int N){
        if(M%N == 0) return N;
        return GCD(N,M%N);      //작은수와 큰수에서 나눈 나머지
    }
}
