public class Starcraft {
    public static void main(String[] args) {
        Marin marin1 = new Marin(50,10,5); //   생성자 => 생성 객체의 의미
        Marin marin2 = new Marin(50,10,5);
        SCV scv = new SCV(60,5,0);
        //객체는 new를 써서 Scanner sc  = new Scanner();
    }
}

// 마린이란거 마린 12마리;
// 인간 다 다른사람
//객체 마린
class Marin extends Terran{
    public Marin(int health, int weapon, int defense) {
        super(health, weapon, defense);
    }

    @Override
    public void move() {
        System.out.println("마린이 움직입니다.");
    }

    public void attack() {
        System.out.println("마린이 공격합니다.");
    }
}

// 객체 SCV
class SCV extends Terran{

    public SCV(int health, int weapon, int defense) {
        super(health, weapon, defense);
    }

    @Override
    public void move() {
        System.out.println();
        System.out.println("SCV가 움직입니다.");
    }

    public void makeMoney() {
        System.out.println("SCV가 돈을 법니다.");
    }

}

class Terran{
    int weapon;
    int health;
    int defense;
    String tribe = "Terran";

    public Terran(int health, int weapon, int defense) {
        this.health = health;
        this.weapon = weapon;
        this.defense = defense;
    }
    public void terran(){
        System.out.println("나는"+ tribe +"입니다");
    }
    public void move(){
        System.out.println("움직입니다.");
    }
}