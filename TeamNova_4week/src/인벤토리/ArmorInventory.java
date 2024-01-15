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

    public ArmorInventory(MasterClass master, MageClass mage){
        this.master = master;
        this.mage = mage;
    }
    public void FromShop(Armor armor){
        Armors.add(armor);
    }

    public void showArmorInven(All_Inventory ai){
        if(Armors.isEmpty() == false){
            for(int i = 0; i < Armors.size(); i++) {
                System.out.println((i+1) + ". " + "무기명 : " + Armors.get(i).Name + " / " + "공격력 : " + Armors.get(i).DefenceValue + " / " + "타입 : " + Armors.get(i).ArmorType + " / " + "상태 : " + Armors.get(i).Status);
            }
            putEquipment();
            ReturnPreWin(ai);
        }else{
            System.out.println("인벤토리에 무기가 없습니다.");
            putEquipment();
            ReturnPreWin(ai);
        }
    }

    public void putEquipment(){
        System.out.println("어떤 장비를 착용하시겠습니까?");
        int putIndex = sc.nextInt() - 1;
        if(Armors.get(putIndex).ArmorType.equals("마스터")){
            PutOffArmor_master(putIndex);
        }else{
            PutOffArmor_mage(putIndex);
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

    public void PutOffArmor_master(int putIndex){
        for(int i = 0; i < Armors.size();i++){
            // 마스터 장비만 벗는다.
            if(Armors.get(i).Status.equals("<<착용>>") && Armors.get(i).ArmorType.equals("마스터")){
                Armors.get(i).Status = "<<미착용>>";
                // 마스터 공격력을 장비 만큼 다운
                master.Defence = master.Defence - Armors.get(i).DefenceValue;
            }
        }
        // 마스터 장비를 입는다.
        if(Armors.get(putIndex).Status.equals("<<미착용>>") && Armors.get(putIndex).ArmorType.equals("마스터")) {
            Armors.get(putIndex).Status = "<<착용>>";
        }
        // 마스터의 선택한 장비를 입고 공격력을 올린다.
        PutArmor_master(Armors.get(putIndex));
    }

    public void PutOffArmor_mage(int putIndex){
        for(int i = 0; i < Armors.size();i++){
            // 마스터 장비만 벗는다.
            if(Armors.get(i).Status.equals("<<착용>>") && Armors.get(i).ArmorType.equals("마법사")){
                Armors.get(i).Status = "<<미착용>>";
                // 마스터 공격력을 장비 만큼 다운
                mage.Defence = mage.Defence - Armors.get(i).DefenceValue;
            }
        }
        // 마스터 장비를 입는다.
        if(Armors.get(putIndex).Status.equals("<<미착용>>") && Armors.get(putIndex).ArmorType.equals("마법사")) {
            Armors.get(putIndex).Status = "<<착용>>";
        }
        // 마스터의 선택한 장비를 입고 공격력을 올린다.
        PutArmor_mage(Armors.get(putIndex));
    }
    public void PutArmor_master(Armor armor){
        master.Defence = master.Defence + armor.DefenceValue;
        System.out.println("마스터가 " + "'" +armor.Name + "'" + " 을 착용했습니다.");
    }

    public void PutArmor_mage(Armor armor){
        mage.Defence = mage.Defence + armor.DefenceValue;
        System.out.println("마법사가 " + "'" +armor.Name + "'" + " 을 착용했습니다.");
    }
}
