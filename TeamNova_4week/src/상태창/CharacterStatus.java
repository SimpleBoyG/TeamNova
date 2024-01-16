package 상태창;

import 마법사.MageClass;
import 마스터.MasterClass;
import 마을.VillageInner;

import java.util.Scanner;

public class CharacterStatus {
    public MasterClass master;
    public MageClass mage;
    public VillageInner vi;
    public CharacterStatus(VillageInner vi, MasterClass master, MageClass mage){
        this.master = master;
        this.mage = mage;
        this.vi = vi;
    }
    public void showAllStatus(){
        showMasterStatus();
        showMageStatus();
        StatusToVillage();
    }
    // 상태창 확인
    public void showMasterStatus(){
        System.out.println("============ 마스터 ===============");
        System.out.println("이름 : " + master.name);
        System.out.println("HP : " + master.Hp);
        System.out.println("MP : " + master.Mp);
        System.out.println("공격력 : " + master.Attack);
        System.out.println("방어력 : " + master.Defence);
        System.out.println("경험치 : " + master.Experience);
        System.out.println("GOLD : " + master.Cash);
        System.out.println("============ 착용중인 장비 ===============");
        if(master.equipedWeapon==null){
            System.out.println("무기 : ---------------------------");
        }else{
            System.out.println("무기 : " + master.equipedWeapon.getName());
        }
        if(master.equipedArmor==null){
            System.out.println("방어구 : ---------------------------");
        }else{
            System.out.println("방어구 : " + master.equipedArmor.getName());
        }

    }

    public void showMageStatus(){
        System.out.println("============ 마법사 ===============");
        System.out.println("HP : " + mage.Hp);
        System.out.println("MP : " + mage.Mp);
        System.out.println("마법 공격력 : " + mage.MagicAttack);
        System.out.println("방어력 : " + mage.Defence);
        System.out.println("경험치 : " + mage.Experience);
        System.out.println("============ 착용중인 장비 ===============");
        if(mage.equipedWeapon==null){
            System.out.println("무기 : ---------------------------");
        }else{
            System.out.println("무기 : " + mage.equipedWeapon.getName());
        }
        if(mage.equipedArmor==null){
            System.out.println("방어구 : ---------------------------");
        }else{
            System.out.println("방어구 : " + mage.equipedArmor.getName());
        }
    }

    public void StatusToVillage() {
        Scanner sc = new Scanner(System.in);
        int goVillage = sc.nextInt();
        System.out.println("마을로 돌아갑니다.(아무 숫자나 입력해주세요.)");
        if(goVillage > 0){
            vi.goVillage();
        }
    }
}
