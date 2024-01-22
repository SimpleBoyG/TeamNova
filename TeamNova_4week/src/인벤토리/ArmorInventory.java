package 인벤토리;

import 마법사.MageClass;
import 마스터.MasterClass;
import 마을.방어구상점.방어구.Armor;

import java.util.ArrayList;
import java.util.Scanner;

public class ArmorInventory {
    ArrayList<Armor> Armors = new ArrayList<>();
    MageClass mage;
    MasterClass master;
    Scanner sc = new Scanner(System.in);
    // 이전 방어구
    Armor preArmor_Master;
    Armor preArmor_Mage;

    public ArmorInventory(MasterClass master, MageClass mage){
        this.master = master;
        this.mage = mage;
    }
    public void FromShop(Armor armor){
        Armors.add(armor);
    }

    public void showArmorInven(All_Inventory ai) {
        if (Armors.isEmpty() == false) {
            for (int i = 0; i < Armors.size(); i++) {
                if(Armors.get(i).getArmorType().equals("마스터")) {
                    System.out.println((i + 1) + ". " +
                            "무기명 : " + Armors.get(i).getName() + " / " +
                            "방어력 : " + Armors.get(i).getDefence() + " / " +
                            "타입 : " + Armors.get(i).getArmorType() + " / " +
                            "상태 : " + Armors.get(i).getEquipStatus());
                }else{
                    System.out.println((i + 1) + ". " +
                            "무기명 : " + Armors.get(i).getName() + " / " +
                            "방어력 : " + Armors.get(i).getDefence() + " / " +
                            "타입 : " + Armors.get(i).getArmorType() + " / " +
                            "상태 : " + Armors.get(i).getEquipStatus());
                }
            }
            putEquipment();
            ReturnPreWin(ai);
        } else {
            System.out.println("인벤토리에 방어구가 없습니다.");
            ReturnPreWin(ai);
        }
    }

    public void putEquipment() {
        System.out.println("어떤 장비를 착용하시겠습니까?");
        int putIndex = sc.nextInt() - 1;
        if (Armors.get(putIndex).getArmorType().equals("마스터")) {
            if(Armors.get(putIndex) == preArmor_Master){
                PutOffArmor_master();
            }else {
                PutOffArmor_master();
                PutArmor_master(Armors.get(putIndex));
            }
        } else {
            if(Armors.get(putIndex) == preArmor_Mage){
                PutOffArmor_mage();
            }else {
                PutOffArmor_mage();
                PutArmor_mage(Armors.get(putIndex));
            }
        }

    }
    public void ReturnPreWin(All_Inventory ai){
        System.out.println("이전 창으로 돌아갑니다.(아무 숫자 입력)");
        System.out.println(":");
        int Answer = sc.nextInt();
        if(Answer == 1){
            ai.showWeaponList();
        }else{
            ai.showWeaponList();
        }
    }

    public void PutOffArmor_master() {
        if(preArmor_Master != null) {
            preArmor_Master.setEquipStatus("<<미착용>>");
            System.out.println(preArmor_Master.getName() + " 장비를 착용 해제 했습니다.");
            master.Defence = master.Defence - preArmor_Master.getDefence();
            preArmor_Master = null;
        }
    }

    public void PutOffArmor_mage() {
        if(preArmor_Mage != null) {
            preArmor_Mage.setEquipStatus("<<미착용>>");
            System.out.println(preArmor_Mage.getName() + " 장비를 착용 해제 했습니다.");
            mage.Defence = mage.Defence - preArmor_Mage.getDefence();
            preArmor_Mage = null;
        }
    }
    public void PutArmor_master(Armor armor){
        master.Defence = master.Defence + armor.getDefence();
        armor.setEquipStatus("<<착용>>");
        System.out.println("마스터가 " + "'" + armor.getName() + "'" + " 을 착용했습니다.");
        master.equipedArmor = armor;
        preArmor_Master = armor;
    }

    public void PutArmor_mage(Armor armor){
        mage.Defence = mage.Defence + armor.getDefence();
        armor.setEquipStatus("<<착용>>");
        System.out.println("마법사가 " + "'" + armor.getName() + "'" + " 을 착용했습니다.");
        mage.equipedArmor = armor;
        preArmor_Mage = armor;
    }
}
