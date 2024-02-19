package 캐릭터.마스터;

import 아이템.소모품.Expendables;
import 캐릭터.Character;
import 캐릭터.몬스터.Monster;
import 인벤토리.ExpendablesInventory;

public class MasterClass extends Character {
//    public String name;
    public int Gold = 10000;
    public ExpendablesInventory itemInventory;
    public Expendables Item;

    public MasterClass(String name) {
        super(name,1,10,0,5,100,20,100);
    }

    public int Run() {
        System.out.println("전투에서 도망 갔습니다.");
        return 0;
    }

    public int ShildAttack(Monster monster) {
        int iResult = 0;
        int Damage = monster.Defence - (Attack + 5);
        if (Damage >= 0) {
            System.out.println("아무런 데미지를 입히지 못했습니다.");
            iResult = 1;
        } else {
            if (Mp > 1) {
                System.out.println("방패로 공격을 했습니다.");
                monster.Hp = monster.Hp + Damage;
                System.out.printf("%d 의 데미지를 입혔습니다.\n", Math.abs(Damage));
                Mp = Mp - 2;
                iResult = 1;
            } else {
                System.out.println("Mp가 모자랍니다. 다른 선택을 해주세요");
                iResult = 2;
            }
        }
        return iResult;
    }

    public int UseItem() {
        int iResult = 0;
        Item = itemInventory.SpendItem();
        if (Item != null) {
            System.out.println(Item.getName() + "을 사용합니다.");
            Hp = Hp + Item.getRecoveryPoint();
            if (Hp > MaxHp) {
                Hp = MaxHp;
            }
            iResult = 1;
        } else {
            System.out.println("아이템이 없습니다.");
            iResult = 2;
        }
        return iResult;
    }

    @Override
    public void Use_Skill(int SkillIndex, Monster monster) {
        if(SkillIndex == 0){
            ShildAttack(monster);
        }
    }
}
