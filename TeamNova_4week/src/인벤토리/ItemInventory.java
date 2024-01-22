package 인벤토리;

import 마법사.MageClass;
import 마스터.MasterClass;
import 마을.방어구상점.방어구.Armor;
import 마을.아이템상점.아이템.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemInventory {
    ArrayList<Item> Items = new ArrayList<>();
    MageClass mage;
    MasterClass master;
    Scanner sc = new Scanner(System.in);
    // 이전 방어구

    public ItemInventory(MasterClass master, MageClass mage) {
        this.master = master;
        this.mage = mage;
    }

    public void FromShop(Item item) {
        Items.add(item);
    }

    public void showItemInven(All_Inventory ai) {
        if (Items.isEmpty() == false) {
            for (int i = 0; i < Items.size(); i++) {
                System.out.println((i + 1) + ". " +
                        "아이템명 : " + Items.get(i).getName() + " / " +
                        "회복력 : HP " + Items.get(i).getRecoveryPoint());
            }

        } else {
            System.out.println("인벤토리에 아이템이 없습니다.");

        }
    }
}
