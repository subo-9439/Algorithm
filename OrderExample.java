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
    public void giveItem(CafeCustomer cafeCustomer){
        if(cafeCustomer instanceof CafeCustomer && cafeCustomer != null){
            System.out.println(cafeCustomer.getOrder());
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

        cafeowner.giveItem(a);
        cafeowner.giveItem(b);
    }
}