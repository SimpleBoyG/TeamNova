package 마을.무기상점;

import 캐릭터.마법사.MageClass;
import 캐릭터.마스터.MasterClass;
import 마을.VillageInner;
import 아이템.무기.Weapon;
import 아이템.무기.WeaponInstanceSend;
import 아이템.무기.레어무기.예리한양날검;
import 아이템.무기.일반무기.양날검;
import 아이템.무기.일반무기.휘어진지팡이;
import 인벤토리.All_Inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WeaponShop {
    public MasterClass master;
    public MageClass mage;
    VillageInner vi;
    All_Inventory ai;

    public WeaponShop(VillageInner vi, All_Inventory ai,MasterClass master, MageClass mage){
        this.vi = vi;
        this.ai = ai;
        this.master = master;
        this.mage = mage;
    }

    // 무기 객체를 담을 자료구조
    Map<Integer, Weapon> Weapons = new HashMap<>();
    // 팩토리 객체
    WeaponInstanceSend weaponFactory = new WeaponInstanceSend();
    Weapon weapon1 = weaponFactory.getWeapon(양날검.class);
    Weapon weapon2 = weaponFactory.getWeapon(예리한양날검.class);
    Weapon weapon3 = weaponFactory.getWeapon(휘어진지팡이.class);
    Scanner sc = new Scanner(System.in);

    public void hereWeaponShop() {
        System.out.println("안녕하세요. 여기는 무기 상점입니다.");
        System.out.println("무기를 구매하시겠습니까?");
        System.out.println("1) 예 2) 아니오");
        int WeaponBuy = sc.nextInt();
        // Map에 저장
        Weapons.put(1, weapon1);
        Weapons.put(2, weapon2);
        Weapons.put(3, weapon3);

        if (WeaponBuy == 1) {
            SelectWeapon();
        } else {
            goVillage();
        }
    }

    public void SelectWeapon() {
        System.out.println("어떤 무기를 구매하시겠습니까?");
        showWeapon();
        boolean SaveInvenSuccess = ShopToInven(BuyWeapon());
        if(SaveInvenSuccess == true){
            ContinueBuy();
        }
    }

    public void showWeapon() {
        System.out.println("가진돈 : " + master.Gold + " GOLD");
        System.out.println("================ 무기목록 ===============");

        for (Map.Entry<Integer, Weapon> entry : Weapons.entrySet()) {
            int Key = entry.getKey();
            Weapon value = entry.getValue();
            if(value.getWeaponType().equals("마스터")) {
                System.out.println(Key + ") " + "무기명 : " + value.getName() + " / " +
                        "가격 : " + value.getPrice()+ " / " +
                        "공격력 : " + value.getPhysicalAttack() + " / " +
                        "타입 : " + value.getWeaponType());
            }else{
                System.out.println(Key + ") " + "무기명 : " + value.getName() + " / " +
                        "가격 : " + value.getPrice() + " / " +
                        "마법공격력 : " + value.getMagicAttack() + " / " +
                        "타입 : " + value.getWeaponType());
            }
        }
    }

    public int BuyWeapon() {
        System.out.println("어떤 무기를 사시겠습니까?< 0. 은 이전 화면으로 돌아갑니다.>");
        int WeaponNum = sc.nextInt();
        if(WeaponNum == 0){
            hereWeaponShop();
        }
        return WeaponNum;
    }

    public boolean ShopToInven(int WeaponNum) {
        boolean Result = false;
        if(WeaponNum > 0) {
            Weapon weapon = Weapons.get(WeaponNum);
            if (weapon != null) {
                if(ai.weaponInventory.HaveWeaponCheck(weapon) != false) {
                    if (master.Gold > weapon.getPrice()) {
                        ai.weaponInventory.FromShop(weapon);
                        master.Gold = master.Gold - weapon.getPrice();
                        Result = true;
                        System.out.println(weapon.getName() + "을 샀습니다.");
                    } else {
                        System.out.println("가진 돈이 부족합니다.");
                        ContinueBuy();
                    }
                }else{
                    System.out.println("다른 무기를 구매해주세요.");
                    ContinueBuy();
                }
            } else {
                System.out.println("잘못된 선택입니다, 코드를 재수정 해주세요");
            }
        }
        return Result;
    }

    public void ContinueBuy() {
        System.out.println("다른 무기를 구매하시겠습니까?");
        System.out.println("1) 예 2) 아니오");
        int WeaponBuy = sc.nextInt();
        if (WeaponBuy == 1) {
            SelectWeapon();
        } else {
            goVillage();
        }
    }

    public void goVillage(){
        System.out.println("마을로 갑니다.");
        vi.goVillage();
    }
}
