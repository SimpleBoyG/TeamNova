package 상태창;

import 마법사.MageClass;
import 마스터.MasterClass;

public class CharacterStatus {
    public MasterClass master;
    public MageClass mage;
    public CharacterStatus(MasterClass master, MageClass mage){
        this.master = master;
        this.mage = mage;
    }
    public void showAllStatus(){
        showMasterStatus();
        showMageStatus();
    }
    // 상태창 확인
    public void showMasterStatus(){
        System.out.println("============ 마스터 ===============");
        System.out.println("이름 : " + master.name);
        System.out.println("HP : " + master.Hp);
        System.out.println("MP : " + master.Mp);
        System.out.println("공격력 : " + master.Attack);
        System.out.println("방어력 : " + master.Defence);
        System.out.println("방어력 : " + master.Experience);
        System.out.println("GOLD : " + master.Cash);
        System.out.println("============ 착용중인 장비 ===============");

    }

    public void showMageStatus(){
        System.out.println("============ 마법사 ===============");
        System.out.println("HP : " + mage.Hp);
        System.out.println("MP : " + mage.Mp);
        System.out.println("공격력 : " + mage.MagicAttack);
        System.out.println("공격력 : " + mage.Defence);
        System.out.println("방어력 : " + mage.Experience);
        System.out.println("GOLD : " + mage.Experience);
        System.out.println("============ 착용중인 장비 ===============");
    }

}
