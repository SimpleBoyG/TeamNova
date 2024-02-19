package 인벤토리;

import 캐릭터.마법사.MageClass;
import 캐릭터.마스터.MasterClass;
import 아이템.무기.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

public class WeaponInventory {
    ArrayList<Weapon> Weapons = new ArrayList<>();

    MageClass mage;
    MasterClass master;
    Scanner sc = new Scanner(System.in);
    // 이전 무기
    Weapon preWeapon_Master;
    Weapon preWeapon_Mage;

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
                if (Weapons.get(i).getWeaponType().equals("마스터")) {
                    System.out.println((i + 1) + ". " +
                            "무기명 : " + Weapons.get(i).getName() + " / " +
                            "공격력 : " + Weapons.get(i).getPhysicalAttack() + " / " +
                            "타입 : " + Weapons.get(i).getWeaponType() + " / " +
                            "상태 : " + Weapons.get(i).getEquipStatus());
                } else {
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
            ReturnPreWin(ai);
        }
    }

    public void putEquipment() {
        System.out.println("어떤 장비를 착용하시겠습니까? ('0' 선택시 이전창으로 돌아갑니다.)");
        System.out.println(":");
        int putIndex = sc.nextInt();
        if (putIndex != 0) {
            putIndex = putIndex - 1;
            if (Weapons.get(putIndex).getWeaponType().equals("마스터")) {
                if (Weapons.get(putIndex) == preWeapon_Master) {
                    PutOffWeapon_master();
                } else {
                    PutOffWeapon_master();
                    PutWeapon_master(Weapons.get(putIndex));
                }
            } else {
                if (Weapons.get(putIndex) == preWeapon_Mage) {
                    PutOffWeapon_mage();
                } else {
                    PutOffWeapon_mage();
                    PutWeapon_mage(Weapons.get(putIndex));
                }
            }
        } else {
            System.out.println("아무 장비도 선택하지 않았습니다.");
        }
    }

    public void ReturnPreWin(All_Inventory ai) {
        System.out.println("이전 창으로 돌아갑니다.(아무 숫자 입력)");
        System.out.println(":");
        int Answer = sc.nextInt();
        if (Answer == 1) {
            ai.showInventoryList();
        } else {
            ai.showInventoryList();
        }
    }

    public void PutOffWeapon_master() {
        if (preWeapon_Master != null) {
            preWeapon_Master.setEquipStatus("<<미착용>>");
            System.out.println(preWeapon_Master.getName() + " 장비를 착용 해제 했습니다.");
            master.Attack = master.Attack - preWeapon_Master.getPhysicalAttack();
            preWeapon_Master = null;
        }
    }

    public void PutOffWeapon_mage() {
        if (preWeapon_Mage != null) {
            preWeapon_Mage.setEquipStatus("<<미착용>>");
            System.out.println(preWeapon_Mage.getName() + " 장비를 착용 해제 했습니다.");
            mage.MagicAttack = mage.MagicAttack - preWeapon_Mage.getMagicAttack();
            preWeapon_Mage = null;
        }
    }

    public void PutWeapon_master(Weapon weapon) {
        master.Attack = master.Attack + weapon.getPhysicalAttack();
        weapon.setEquipStatus("<<착용>>");
        System.out.println("마스터가 " + "'" + weapon.getName() + "'" + " 을 착용했습니다.");
        master.equipedWeapon = weapon;
        preWeapon_Master = weapon;
    }

    public void PutWeapon_mage(Weapon weapon) {
        mage.MagicAttack = mage.MagicAttack + weapon.getMagicAttack();
        weapon.setEquipStatus("<<착용>>");
        System.out.println("마법사가 " + "'" + weapon.getName() + "'" + " 을 착용했습니다.");
        mage.equipedWeapon = weapon;
        preWeapon_Mage = weapon;
    }

    // 인벤토리에 같은 무기가 있는지 확인
    public Boolean HaveWeaponCheck(Weapon weapon) {
        boolean haveCheck = true;
        for (int i = 0; i < Weapons.size(); i++)
            if (Weapons.get(i).getName().equals(weapon.getName())) {
                System.out.println("이미 소유한 무기입니다.");
                haveCheck = false;
            }
        return haveCheck;
    }

}
