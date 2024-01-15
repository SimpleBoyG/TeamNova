package 마스터;

import 마법사.MageClass;
import 마을.무기상점.무기.Weapon;
import 마을.방어구상점.방어구.Armor;
import 몬스터.Monster;

public class MasterClass {
    public String name;
    public int Attack = 10;
    public int Defence = 5;
    public int Hp = 100;
    public int Mp = 10;
    public int Experience;
    public int Cash = 5000;
    public Weapon weapon;
    public Armor armor;

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

    public void Attack(Monster monster){
        System.out.println("일반 공격을 했습니다.");
        monster.Hp = monster.Hp - 5;
    }
    public boolean ShildAttack(Monster monster){
        boolean Result = true;
            if (Mp > 1) {
                System.out.println("방패로 공격을 했습니다.");
                monster.Hp = monster.Hp - 5;
                Mp = Mp - 2;
            } else {
                System.out.println("Mp가 모자랍니다. 다른 선택을 해주세요");
                Result = false;
            }
        return Result;
    }
}
