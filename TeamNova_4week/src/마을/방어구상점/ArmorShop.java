package 마을.방어구상점;

import 마법사.MageClass;
import 마스터.MasterClass;
import 마을.VillageInner;
import 마을.방어구상점.방어구.Armor;
import 마을.방어구상점.방어구.ArmorInstanceSend;
import 마을.방어구상점.방어구.레어방어구.강철갑옷;
import 마을.방어구상점.방어구.일반방어구.나무갑옷;
import 마을.방어구상점.방어구.일반방어구.천갑옷;
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
    ArmorInstanceSend armorFactory = new ArmorInstanceSend();
    Armor armor1 = armorFactory.getArmor(강철갑옷.class);
    Armor armor2 = armorFactory.getArmor(나무갑옷.class);
    Armor armor3 = armorFactory.getArmor(천갑옷.class);

    Scanner sc = new Scanner(System.in);

    public void hereArmorShop() {
        System.out.println("안녕하세요. 여기는 방어구 상점입니다.");
        System.out.println("방어구를 구매하시겠습니까?");
        System.out.println("1) 예 2) 아니오");
        int ArmorBuy = sc.nextInt();
        // Map에 저장
        Armors.put(1, armor1);
        Armors.put(2, armor2);
        Armors.put(3, armor3);


        if (ArmorBuy == 1) {
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
        System.out.println("가진돈 : " + master.Gold + " GOLD");
        System.out.println("================ 방어구목록 ===============");

        for (Map.Entry<Integer, Armor> entry : Armors.entrySet()) {
            int Key = entry.getKey();
            Armor value = entry.getValue();
            if(value.getArmorType().equals("마스터")) {
                System.out.println(Key + ") " + "방어구명 : " + value.getName() + " / " +
                        "가격 : " + value.getPrice()+ " / " +
                        "방어력 : " + value.getDefence() + " / " +
                        "타입 : " + value.getArmorType());
            }else{
                System.out.println(Key + ") " + "방어구명 : " + value.getName() + " / " +
                        "가격 : " + value.getPrice() + " / " +
                        "방어력 : " + value.getDefence() + " / " +
                        "타입 : " + value.getArmorType());
            }
        }
    }

    public int BuyArmor() {
        System.out.println("어떤 방어구를 사시겠습니까?< 0. 은 이전 화면으로 돌아갑니다.>");
        int ArmorNum = sc.nextInt();
        if(ArmorNum == 0){
            hereArmorShop();
        }
        return ArmorNum;
    }

    public boolean ShopToInven(int ArmorNum) {
        boolean Result = false;
        if(ArmorNum > 0) {
            Armor armor = Armors.get(ArmorNum);
            if (armor != null) {
                if (master.Gold > armor.getPrice()) {
                    ai.armorInventory.FromShop(armor);
                    master.Gold = master.Gold - armor.getPrice();
                    Result = true;
                    System.out.println(armor.getName() + "을 샀습니다.");
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
        } else {
            goVillage();
        }
    }

    public void goVillage(){
        System.out.println("마을로 갑니다.");
        vi.goVillage();
    }
}
