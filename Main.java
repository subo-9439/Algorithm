import java.util.Scanner;

public class Main{
        
    
    public static void main(String[] args) {
        abc a = new abc(1);
        abc b = new abc(1,2);
        abc c = new abc(1,3);
        
    }

    static class abc{
        public abc(){
            System.out.println("무조건 출력");
        }
        public abc(int a){
            super();
            System.out.println(a);
        }
        public abc(int a, int b){
            super();
            System.out.println(a+ " " + b);
        }
        public abc(int a, int b,int c){
            super();
            System.out.printf("%d,%d,%d",a,b,c);
        }
    }
}