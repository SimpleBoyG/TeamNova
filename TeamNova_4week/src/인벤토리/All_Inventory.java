package 인벤토리;

import 캐릭터.마법사.MageClass;
import 캐릭터.마스터.MasterClass;
import 마을.VillageInner;

import java.util.Scanner;


public class All_Inventory {
    VillageInner vi;
    MasterClass master;
    MageClass mage;
    public ArmorInventory armorInventory;
    public ExpendablesInventory itemInventory;
    public WeaponInventory weaponInventory;
    public All_Inventory(MasterClass master, MageClass mage){
        this.master = master;
        this.mage = mage;
        armorInventory = new ArmorInventory(master, mage);
        itemInventory = new ExpendablesInventory(master, mage);
        weaponInventory = new WeaponInventory(master, mage);
    }

    public void showAllInventory(VillageInner vi){
        this.vi = vi;
        showInventoryList();
    }

    public void showInventoryList(){
        System.out.println("어떤 목록을 보시겠습니까?");
        System.out.println("1) 무기창 2) 방어구창 3) 아이템창 4) 이전 메뉴");

        Scanner sc = new Scanner(System.in);
        int EqIndex = sc.nextInt();
        switch(EqIndex){
            case 1:
                weaponInventory.showWeaponInven(this);
                break;
            case 2:
                armorInventory.showArmorInven(this);
                break;
            case 3:
                itemInventory.showVillageItemInven(this);
            case 4:
                ReturnPreWin(vi);
                break;
            default:
                ReturnPreWin(vi);
                break;
        }
    }

    public void ReturnPreWin(VillageInner vi){
        System.out.println("이전 창으로 돌아갑니다.(아무 숫자 입력)");
        System.out.println(":");
        Scanner sc = new Scanner(System.in);
        int Answer = sc.nextInt();
        if(Answer == 1){
            vi.goVillage();
        }else{
            vi.goVillage();
        }
    }

}
