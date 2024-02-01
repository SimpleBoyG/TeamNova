package 인벤토리;

import 마법사.MageClass;
import 마스터.MasterClass;
import 마을.방어구상점.방어구.Armor;
import 마을.아이템상점.아이템.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemInventory {
    ArrayList<Item>[] Items = new ArrayList[2];
    ArrayList<Item> 회복약 = new ArrayList<>();
    ArrayList<Item> 고급회복약 = new ArrayList<>();
    MageClass mage;
    MasterClass master;
    Scanner sc = new Scanner(System.in);
    int SelectCount = 0;
    int indexItem = 0;

    public ItemInventory(MasterClass master, MageClass mage) {
        this.master = master;
        this.mage = mage;
        master.itemInventory = this;
    }

    public void FromShop(Item item) {
        // 각 아이템에 추가
        // Add to specific items

        if (item.getName().equals("회복약")) {
            Items[0] = ItemCount(회복약,item);
        } else if (item.getName().equals("고급 회복약")) {
            Items[1] = ItemCount(고급회복약,item);
        }
    }

    public ArrayList<Item> ItemCount(ArrayList<Item> ItemName,Item item){
        int ItemCount = 0;
        System.out.println(item.getName() + "을 선택하셨습니다.");
        System.out.println("몇개를 구입하겠습니까?");
        System.out.println(":");
        ItemCount = sc.nextInt();
        SelectCount = ItemCount;
        for(int i = 0; i < ItemCount; i++) {
            ItemName.add(item);
        }
        return ItemName;
    }

    // 아이템 인벤토리에서 전시할 아이템 항목
    public void showItemInven(All_Inventory ai) {
        int ItemCount = 0;
        int sumItemCount = 0;
        ItemCount = ItemCount(Items[0]);
        sumItemCount = sumItemCount + ItemCount;
        ItemCount = ItemCount(Items[1]);
        sumItemCount = sumItemCount + ItemCount;

        if (sumItemCount <= 0) {
            System.out.println("인벤토리에 아이템이 없습니다.");
            ReturnPreWin(ai);
        } else {
            // 회복약 전시
            ArrayList<Item> item = Items[0];
            if (ItemCount(item) > 0) {
                System.out.println((indexItem + 1) + ". " +
                        "아이템명 : " + item.get(0).getName() + " / " +
                        "회복력 : HP " + item.get(0).getRecoveryPoint() +
                        " x " + item.size());
                indexItem++;
            }
            // 고급 회복약 전시
            item = Items[1];
            if (ItemCount(item) > 0) {
                System.out.println((indexItem + 1) + ". " +
                        "아이템명 : " + item.get(0).getName() + " / " +
                        "회복력 : HP " + item.get(0).getRecoveryPoint() +
                        " x " + item.size());
            }
            indexItem = 0;
        }
    }

    // 사냥시에 전시할 아이템 항목
    public void showItemInven() {
        int ItemCount = 0;
        int sumItemCount = 0;
        ItemCount = ItemCount(Items[0]);
        sumItemCount = sumItemCount + ItemCount;
        ItemCount = ItemCount(Items[1]);
        sumItemCount = sumItemCount + ItemCount;

        if (sumItemCount <= 0) {
            System.out.println("인벤토리에 아이템이 없습니다.");
        } else {
            // 회복약 전시
            ArrayList<Item> item = Items[0];
            if (ItemCount(item) > 0) {
                System.out.println((indexItem + 1) + ". " +
                        "아이템명 : " + item.get(0).getName() + " / " +
                        "회복력 : HP " + item.get(0).getRecoveryPoint() +
                        " x " + item.size());
                indexItem++;
            }
            // 고급 회복약 전시
            item = Items[1];
            if (ItemCount(item) > 0) {
                System.out.println((indexItem + 1) + ". " +
                        "아이템명 : " + item.get(0).getName() + " / " +
                        "회복력 : HP " + item.get(0).getRecoveryPoint() +
                        " x " + item.size());
            }
            indexItem = 0;
        }
    }

    public int ItemCount(ArrayList<Item> item) {
        int TempCount = 0;
        if (item == null) {
            TempCount = 0;
        } else {
            TempCount = item.size();
        }
        return TempCount;
    }

    public int getSelectItemCount(){
        return SelectCount;
    }

    // 소비 아이템 선택
    public Item SpendItem() {
        showItemInven();
        System.out.println("어떤 아이템을 사용하시겠습니까?");
        System.out.println(":");
        int iTemSelect = sc.nextInt();
        Item item = SpendItemSelect(iTemSelect);
        deleteUseItem(iTemSelect);
        return item;
    }

    // 소비 아이템 내부 선택
    public Item SpendItemSelect(int ItemSelect) {
        Item useItem = Items[ItemSelect-1].get(0);
        return useItem;
    }

    public void deleteUseItem(int ItemSelect) {
        // 아이템 하나 사용
        Items[ItemSelect-1].remove(0);
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
}
