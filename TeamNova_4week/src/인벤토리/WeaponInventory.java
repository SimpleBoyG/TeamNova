package 인벤토리;

import 마법사.MageClass;
import 마스터.MasterClass;
import 마을.무기상점.무기.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

public class WeaponInventory {
    ArrayList<Weapon> Weapons = new ArrayList<>();

    MageClass mage;
    MasterClass master;
    Scanner sc = new Scanner(System.in);
    // 이전 무기
    Weapon preWeapon;

    public WeaponInventory(MasterClass master, MageClass mage) {
        this.master = master;
        this.mage = mage;
    }

    public void FromShop(Weapon Weapon) {
        Weapons.add(Weapon);
    }

    public void showWeaponInven(All_Inventory ai) {
        if (Weapons.isEmpty() == false) {
            for (int i = 0; i < Weapons.size(); i++) {
                if(Weapons.get(i).getWeaponType().equals("마스터")) {
                    System.out.println((i + 1) + ". " +
                            "무기명 : " + Weapons.get(i).getName() + " / " +
                            "공격력 : " + Weapons.get(i).getPhysicalAttack() + " / " +
                            "타입 : " + Weapons.get(i).getWeaponType() + " / " +
                            "상태 : " + Weapons.get(i).getEquipStatus());
                }else{
                    System.out.println((i + 1) + ". " +
                            "무기명 : " + Weapons.get(i).getName() + " / " +
                            "마법공격력 : " + Weapons.get(i).getMagicAttack() + " / " +
                            "타입 : " + Weapons.get(i).getWeaponType() + " / " +
                            "상태 : " + Weapons.get(i).getEquipStatus());
                }
            }
            putEquipment();
            ReturnPreWin(ai);
        } else {
            System.out.println("인벤토리에 무기가 없습니다.");
            putEquipment();
            ReturnPreWin(ai);
        }
    }

    public void putEquipment() {
        System.out.println("어떤 장비를 착용하시겠습니까?");
        int putIndex = sc.nextInt() - 1;
        if (Weapons.get(putIndex).getWeaponType().equals("마스터")) {
            if(Weapons.get(putIndex) == preWeapon){
                PutOffWeapon_master();
            }else {
                PutOffWeapon_master();
                PutWeapon_master(Weapons.get(putIndex));
            }
        } else {
            if(Weapons.get(putIndex) == preWeapon){
                PutOffWeapon_mage();
            }else {
                PutOffWeapon_mage();
                PutWeapon_mage(Weapons.get(putIndex));
            }
        }

    }

    public void ReturnPreWin(All_Inventory ai) {
        System.out.println("이전 창으로 돌아갑니다.(아무 숫자 입력)");
        System.out.println(":");
        int Answer = sc.nextInt();
        if (Answer == 1) {
            ai.showWeaponList();
        } else {
            ai.showWeaponList();
        }
    }

    public void PutOffWeapon_master() {
        if(preWeapon != null) {
            preWeapon.setEquipStatus("<<미착용>>");
            System.out.println(preWeapon.getName() + " 장비를 착용 해제 했습니다.");
            master.Attack = master.Attack - preWeapon.getPhysicalAttack();
            preWeapon = null;
        }
    }

    public void PutOffWeapon_mage() {
        if(preWeapon != null) {
            preWeapon.setEquipStatus("<<미착용>>");
            System.out.println(preWeapon.getName() + " 장비를 착용 해제 했습니다.");
            mage.MagicAttack = mage.MagicAttack - preWeapon.getMagicAttack();
            preWeapon = null;
        }
    }

    public void PutWeapon_master(Weapon weapon) {
        master.Attack = master.Attack + weapon.getPhysicalAttack();
        weapon.setEquipStatus("<<착용>>");
        System.out.println("마스터가 " + "'" + weapon.getName() + "'" + " 을 착용했습니다.");
        master.equipedWeapon = weapon;
        preWeapon = weapon;
    }

    public void PutWeapon_mage(Weapon weapon) {
        mage.MagicAttack = mage.MagicAttack + weapon.getMagicAttack();
        weapon.setEquipStatus("<<착용>>");
        System.out.println("마법사가 " + "'" + weapon.getName() + "'" + " 을 착용했습니다.");
        mage.equipedWeapon = weapon;
        preWeapon = weapon;
    }
}
