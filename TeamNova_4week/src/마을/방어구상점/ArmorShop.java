package 마을.방어구상점;

import 마법사.MageClass;
import 마스터.MasterClass;
import 마을.VillageInner;
import 마을.방어구상점.방어구.Armor;
import 인벤토리.All_Inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArmorShop {

    public MasterClass master;
    public MageClass mage;
    VillageInner vi;
    All_Inventory ai;

    public ArmorShop(VillageInner vi, All_Inventory ai,MasterClass master, MageClass mage){
        this.vi = vi;
        this.ai = ai;
        this.master = master;
        this.mage = mage;
    }

    // 무기 객체를 담을 자료구조
    Map<Integer, Armor> Armors = new HashMap<>();
    Armor armor1 = new Armor("나무 갑옷", 1000, 10, "마스터");
    Armor armor2 = new Armor("기본 갑옷", 500, 5, "마스터");
    Armor armor3 = new Armor("천 로브", 500, 5, "마법사");

    Scanner sc = new Scanner(System.in);

    public void hereArmorShop() {
        System.out.println("안녕하세요. 여기는 방어구 상점입니다.");
        System.out.println("방어구를 구매하시겠습니까?");
        System.out.println("1) 예 2) 아니오");
        int WeaponBuy = sc.nextInt();
        // Map에 저장
        Armors.put(1, armor1);
        Armors.put(2, armor2);
        Armors.put(3, armor3);

        if (WeaponBuy == 1) {
            SelectArmor();
        } else {
            goVillage();
        }
    }

    public void SelectArmor() {
        System.out.println("어떤 무기를 구매하시겠습니까?");
        showArmor();
        boolean SaveInvenSuccess = ShopToInven(BuyArmor());
        if(SaveInvenSuccess == true){
            ContinueBuy();
        }
    }

    public void showArmor() {
        System.out.println("가진돈 : " + master.Cash + " GOLD");
        System.out.println("================ 방어구목록 ===============");

        for (Map.Entry<Integer, Armor> entry : Armors.entrySet()) {
            int Key = entry.getKey();
            Armor value = entry.getValue();
            System.out.println(Key + ") " + "방어구명 : " + value.Name + " / " + "가격 : " + value.Price + " / " + "방어력 : " + value.DefenceValue + " / " + "타입 : " + value.ArmorType);
        }
    }

    public int BuyArmor() {
        System.out.println("어떤 무기를 사시겠습니까?< 0. 은 이전 화면으로 돌아갑니다.>");
        int WeaponNum = sc.nextInt();
        if(WeaponNum == 0){
            hereArmorShop();
        }
        return WeaponNum;
    }

    public boolean ShopToInven(int WeaponNum) {
        boolean Result = false;
        if(WeaponNum > 0) {
            Armor armor = Armors.get(WeaponNum);
            if (armor != null) {
                if (master.Cash > armor.Price) {
                    ai.armorInventory.FromShop(armor);
                    master.Cash = master.Cash - armor.Price;
                    Result = true;
                    System.out.println(armor.Name + "을 샀습니다.");
                } else {
                    System.out.println("가진 돈이 부족합니다.");
                    ContinueBuy();
                }
            } else {
                System.out.println("잘못된 선택입니다, 코드를 재수정 해주세요");
            }
        }
        return Result;
    }

    public void ContinueBuy() {
        System.out.println("다른 방어구를 구매하시겠습니까?");
        System.out.println("1) 예 2) 아니오");
        int ArmorBuy = sc.nextInt();
        if (ArmorBuy == 1) {
            SelectArmor();
            ContinueBuy();
        } else {
            goVillage();
        }
    }

    public void goVillage(){
        System.out.println("마을로 갑니다.");
        vi.goVillage();
    }
}
