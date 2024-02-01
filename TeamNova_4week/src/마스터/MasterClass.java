package 마스터;

import 마법사.MageClass;
import 마을.무기상점.무기.Weapon;
import 마을.방어구상점.방어구.Armor;
import 마을.아이템상점.아이템.Item;
import 몬스터.Monster;
import 문자열색상변경.TextColorChange;
import 인벤토리.ItemInventory;

public class MasterClass {
    public String name;
    public int Attack = 10;
    public int Defence = 5;
    public int MaxHp = 100;
    public int Hp = MaxHp;
    public int MaxMp = 20;
    public int Mp = MaxMp;
    public int Level = 1;
    public int MaxExperience = 1;
    public int Experience = MaxExperience;
    public int Gold = 10000;
    public Weapon equipedWeapon;
    public Armor equipedArmor;
    public ItemInventory itemInventory;
    public Item Item;
    TextColorChange tcc = new TextColorChange();
    public MasterClass(String name) {
        this.name = name;
    }

    public boolean MageGuard() {
        System.out.println("마법사를 방어했습니다.");
        return true;
    }

    public int Run() {
        System.out.println("전투에서 도망 갔습니다.");
        return 0;
    }

    public int Attack(Monster monster) {
        int iTemp = 1;
        System.out.println("일반 공격을 했습니다.");
        int Damage = monster.Defence - Attack;
        if (Damage >= 0) {
            System.out.println("아무런 데미지를 입히지 못했습니다.");
        } else {
            monster.Hp = monster.Hp + Damage;
            System.out.printf("%d 의 데미지를 입혔습니다.\n", Math.abs(Damage));
        }
        return iTemp;
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

    public void LevelUpMaster(){
        String strTemp = "!!!!!!!!!!!!!!!!!!!!! 마스터가 레벨업 했습니다 !!!!!!!!!!!!!!!!!!!";
        tcc.YellowText(strTemp);
        Level = Level + 1;
        MaxHp = MaxHp + 50;
        Hp = MaxHp;
        MaxMp = MaxMp + 30;
        Mp = MaxMp;
        Attack = Attack + 10;
        Defence = Defence + 5;
        MaxExperience = MaxExperience + 50;
        Experience = MaxExperience;
    }
}
