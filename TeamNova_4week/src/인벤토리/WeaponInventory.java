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
                    System.out.println((i + 1) + ". " + "무기명 : " + Weapons.get(i).getName() + " / " + "공격력 : " + Weapons.get(i).getPhysicalAttack() + " / " + "타입 : " + Weapons.get(i).getWeaponType() + " / " + "상태 : " + Weapons.get(i).EquipStatus);
                }else{
                    System.out.println((i + 1) + ". " + "무기명 : " + Weapons.get(i).getName() + " / " + "마법공격력 : " + Weapons.get(i).getMagicAttack() + " / " + "타입 : " + Weapons.get(i).getWeaponType() + " / " + "상태 : " + Weapons.get(i).EquipStatus);
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
            PutOffWeapon_mage(putIndex);
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
    // 1) 착용중인 장비를 선택을 할 경우에는 착용이 해제
    // 2) 새로운 미착용 중인 장비를 선택을 할 경우 착용
    public void PutOffWeapon_master() {
        // 착용중인 장비를 선택을 할 경우에는 착용이 해제
        if(preWeapon != null) {
            preWeapon.EquipStatus = "<미착용>";
            System.out.println(preWeapon.getName() + " 장비를 착용 해제 했습니다.");
            master.Attack = master.Attack - preWeapon.getPhysicalAttack();
            preWeapon = null;
        // 새로운 미착용 중인 장비를 선택을 할 경우 착용
        }
    }

    public void PutOffWeapon_mage(int putIndex) {
        if (preWeapon == Weapons.get(putIndex)) {
            Weapons.get(putIndex).EquipStatus = "<미착용>";
            System.out.println(Weapons.get(putIndex).getName() + " 장비를 착용 해제 했습니다.");
            mage.MagicAttack = mage.MagicAttack - Weapons.get(putIndex).getPhysicalAttack();
            preWeapon = null;
        } else {
            for (int i = 0; i < Weapons.size(); i++) {
                // 마스터 장비만 벗는다.
                if (Weapons.get(i).EquipStatus.equals("<<착용>>") && Weapons.get(i).getWeaponType().equals("마법사")) {
                    Weapons.get(i).EquipStatus = "<<미착용>>";
                    // 마스터 공격력을 장비 만큼 다운
                    mage.MagicAttack = mage.MagicAttack - Weapons.get(i).getPhysicalAttack();
                }
            }
            // 마스터 장비를 입는다.
            if (Weapons.get(putIndex).EquipStatus.equals("<<미착용>>") && Weapons.get(putIndex).getWeaponType().equals("마법사")) {
                Weapons.get(putIndex).EquipStatus = "<<착용>>";
            }
            // 마스터의 선택한 장비를 입고 공격력을 올린다.
            PutWeapon_mage(Weapons.get(putIndex));
        }

    }

    public void PutWeapon_master(Weapon weapon) {
        master.Attack = master.Attack + weapon.getPhysicalAttack();
        System.out.println("마스터가 " + "'" + weapon.getName() + "'" + " 을 착용했습니다.");
        preWeapon = weapon;
    }

    public void PutWeapon_mage(Weapon weapon) {
        mage.MagicAttack = mage.MagicAttack + weapon.getMagicAttack();
        System.out.println("마법사가 " + "'" + weapon.getName() + "'" + " 을 착용했습니다.");
        preWeapon = weapon;
    }
}
