
public class Main{
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[] nums,operator;
    static int N,max,min;

    static void input(){
        N = sc.nextInt();
        nums = new int[N];
        operator = new int[4];
        for(int i=0; i<N; i++) nums[i] = sc.nextInt();
        for(int i=0; i<4; i++) nums[i] = sc.nextInt();
    }
    static void calculator(int a,int[] operator,int b){
        for(int i=0; i<4;i++){
            //a + b 
            if(operator[i]>0){
                calculator(a, operator, b);
            }
        }

    }
    static void rec_func(int k){
        if()
    }
    public static void main(String[] args) {
        rec_func(0);
    }
}