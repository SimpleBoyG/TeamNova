package Master;

public class MasterClass {
    public String name;
    public int Attack = 10;
    public int defence = 5;
    public int Hp = 100;
    public int Mp = 10;
    int Experience;

    public MasterClass(String name){
        this.name = name;
    }
    public boolean MageGuard(){
        System.out.println("마법사를 방어했습니다.");
        return true;
    }

    public boolean Run(){
        System.out.println("도망 갔습니다.");
        return true;
    }

    public boolean ShildAttack(){
        System.out.println("방패로 공격했습니다.");
        return true;
    }

}
