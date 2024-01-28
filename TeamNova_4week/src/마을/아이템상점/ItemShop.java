package 마을.아이템상점;

import 마스터.MasterClass;
import 마을.VillageInner;

import 마을.아이템상점.아이템.Item;
import 마을.아이템상점.아이템.ItemInstanceSend;
import 마을.아이템상점.아이템.소모품.고급회복약;
import 마을.아이템상점.아이템.소모품.회복약;
import 인벤토리.All_Inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ItemShop {
    public MasterClass master;
    VillageInner vi;
    All_Inventory ai;

    Map<Integer, Item> Items = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    ItemInstanceSend itemFactory = new ItemInstanceSend();
    Item item1 = itemFactory.getItem(회복약.class);
    Item item2 = itemFactory.getItem(고급회복약.class);

    public ItemShop(VillageInner vi, All_Inventory ai,MasterClass master){
        this.vi = vi;
        this.ai = ai;
        this.master = master;
    }

    public void hereItemShop() {
        System.out.println("안녕하세요. 여기는 아이템 상점입니다.");
        System.out.println("아이템을 구매하시겠습니까?");
        System.out.println("1) 예 2) 아니오");
        int ItemBuy = sc.nextInt();
        // Map에 저장
        Items.put(1, item1);
        Items.put(2, item2);

        if (ItemBuy == 1) {
            SelectItem();
        } else {
            goVillage();
        }
    }

    public void SelectItem() {
        System.out.println("어떤 아이템을 구매하시겠습니까?");
        showItem();
        boolean SaveInvenSuccess = ShopToInven(BuyItem());
        if(SaveInvenSuccess == true){
            ContinueBuy();
        }
    }

    public void showItem() {
        System.out.println("가진돈 : " + master.Gold + " GOLD");
        System.out.println("================ Item목록 ===============");

        for (Map.Entry<Integer, Item> entry : Items.entrySet()) {
            int Key = entry.getKey();
            Item value = entry.getValue();

            System.out.println(Key + ") " + "아이템명 : " + value.getName() + " / " +
                    "가격 : " + value.getPrice()+ " / " +
                    "회복량 : HP " + value.getRecoveryPoint() + " / ");
        }
    }

    public int BuyItem() {
        System.out.println("어떤 아이템을 사시겠습니까?< 0. 은 이전 화면으로 돌아갑니다.>");
        int ItemNum = sc.nextInt();
        if(ItemNum == 0){
            hereItemShop();
        }
        return ItemNum;
    }

    public boolean ShopToInven(int ItemNum) {
        boolean Result = false;
        if(ItemNum > 0) {
            Item item = Items.get(ItemNum);
            if (item != null) {
                if (master.Gold > item.getPrice()) {
                    ai.itemInventory.FromShop(item);
                    master.Gold = master.Gold - item.getPrice();
                    Result = true;
                    System.out.println(item.getName() + "을 샀습니다.");
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
        System.out.println("다른 아이템을 구매하시겠습니까?");
        System.out.println("1) 예 2) 아니오");
        int ItemBuy = sc.nextInt();
        if (ItemBuy == 1) {
            SelectItem();
        } else {
            goVillage();
        }
    }

    public void goVillage(){
        System.out.println("마을로 갑니다.");
        vi.goVillage();
    }

}
