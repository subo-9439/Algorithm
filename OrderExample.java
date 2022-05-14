import java.util.Objects;

class CafeCustomer {
    public String CafeCustomerName;

    public void setCafeCustomerName(String CafeCustomerName) {
        this.CafeCustomerName = CafeCustomerName;
    }
    public String getOrder(){
        return "a glass of iced americano";
    }
}

//CafeCustomer 클래스로부터 단골 손님A와 단골 손님B 상속
class CafeCustomerA extends CafeCustomer {
    public String getOrder(){
        return "a glass of iced americano";
    }
}

class CafeCustomerB extends CafeCustomer {
    public String getOrder(){
        return "a glass of strawberry latte";
    }
}

//카페 사장님
class CafeOwner {
    public void giveItem(Object cafeCustomer){
        if(cafeCustomer instanceof  CafeCustomer){
            System.out.println(((CafeCustomer) cafeCustomer).getOrder());
        }else {
            System.out.println("CafeCustomer가 아닌데여ㅛㅂ");
        }
    }
//    public void giveItem(CafeCustomerB cafeCustomerB) {
//        System.out.println("give a glass of strawberry latte to CafeCustomer B");
//    }
//
//    public void giveItem(CafeCustomerA cafeCustomerA) {
//        System.out.println("give a glass of iced americano to CafeCustomer A");
//    }
}

//메뉴 주문
public class OrderExample {
    public static void main(String[] args) throws Exception {
        CafeOwner cafeowner = new CafeOwner();
        CafeCustomerA a = new CafeCustomerA();
        CafeCustomerB b = new CafeCustomerB();
        String str = new String();
        cafeowner.giveItem(str);
        cafeowner.giveItem(a);
        cafeowner.giveItem(b);
    }
}