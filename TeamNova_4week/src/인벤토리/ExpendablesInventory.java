package 인벤토리;

import 캐릭터.마법사.MageClass;
import 캐릭터.마스터.MasterClass;
import 아이템.소모품.Expendables;

import java.util.ArrayList;
import java.util.Scanner;

public class ExpendablesInventory {
    ArrayList<Expendables>[] Expendables = new ArrayList[2];
    ArrayList<Expendables> 회복약 = new ArrayList<>();
    ArrayList<Expendables> 고급회복약 = new ArrayList<>();
    MageClass mage;
    MasterClass master;
    Scanner sc = new Scanner(System.in);
    int SelectCount = 0;
    int indexItem = 0;

    public ExpendablesInventory(MasterClass master, MageClass mage) {
        this.master = master;
        this.mage = mage;
        master.itemInventory = this;
    }

    public void FromShop(Expendables item) {
        // 각 아이템에 추가
        // Add to specific items

        if (item.getName().equals("회복약")) {
            Expendables[0] = ItemCount(회복약,item);
        } else if (item.getName().equals("고급 회복약")) {
            Expendables[1] = ItemCount(고급회복약,item);
        }
    }

    public ArrayList<Expendables> ItemCount(ArrayList<Expendables> ItemName, Expendables item){
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
    public void showVillageItemInven(All_Inventory ai) {
        int ItemCount = 0;
        int sumItemCount = 0;
        ItemCount = ItemCount(Expendables[0]);
        sumItemCount = sumItemCount + ItemCount;
        ItemCount = ItemCount(Expendables[1]);
        sumItemCount = sumItemCount + ItemCount;

        if (sumItemCount <= 0) {
            System.out.println("인벤토리에 아이템이 없습니다.");
            ReturnPreWin(ai);
        } else {
            // 회복약 전시
            ArrayList<Expendables> Expendable = Expendables[0];
            if (ItemCount(Expendable) > 0) {
                System.out.println((indexItem + 1) + ". " +
                        "아이템명 : " + Expendable.get(0).getName() + " / " +
                        "회복력 : HP " + Expendable.get(0).getRecoveryPoint() +
                        " x " + Expendable.size());
                indexItem++;
            }
            // 고급 회복약 전시
            Expendable = Expendables[1];
            if (ItemCount(Expendable) > 0) {
                System.out.println((indexItem + 1) + ". " +
                        "아이템명 : " + Expendable.get(0).getName() + " / " +
                        "회복력 : HP " + Expendable.get(0).getRecoveryPoint() +
                        " x " + Expendable.size());
            }
            indexItem = 0;
        }
    }

    // 사냥시에 전시할 아이템 항목
    public boolean showHuntingItemInven() {
        boolean bEmptyItem = true;
        int ItemCount = 0;
        int sumItemCount = 0;
        ItemCount = ItemCount(Expendables[0]);
        sumItemCount = sumItemCount + ItemCount;
        ItemCount = ItemCount(Expendables[1]);
        sumItemCount = sumItemCount + ItemCount;

        if (sumItemCount <= 0) {
            System.out.println("인벤토리에 아이템이 없습니다.");
            bEmptyItem = false;
        } else {
            // 회복약 전시
            ArrayList<Expendables> item = Expendables[0];
            if (ItemCount(item) > 0) {
                System.out.println((indexItem + 1) + ". " +
                        "아이템명 : " + item.get(0).getName() + " / " +
                        "회복력 : HP " + item.get(0).getRecoveryPoint() +
                        " x " + item.size());
                indexItem++;
            }
            // 고급 회복약 전시
            item = Expendables[1];
            if (ItemCount(item) > 0) {
                System.out.println((indexItem + 1) + ". " +
                        "아이템명 : " + item.get(0).getName() + " / " +
                        "회복력 : HP " + item.get(0).getRecoveryPoint() +
                        " x " + item.size());
            }
            indexItem = 0;
        }
        return bEmptyItem;
    }

    public int ItemCount(ArrayList<Expendables> item) {
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
    public Expendables SpendItem() {
        boolean bEmptyItem = showHuntingItemInven();
        Expendables item = null;
        if(bEmptyItem == true){
        System.out.println("어떤 아이템을 사용하시겠습니까?");
        System.out.println(":");
        int iTemSelect = sc.nextInt();
        item = SpendItemSelect(iTemSelect);
        deleteUseItem(iTemSelect);
        }
        return item;
    }

    // 소비 아이템 내부 선택
    public Expendables SpendItemSelect(int ItemSelect) {
        Expendables useItem = Expendables[ItemSelect-1].get(0);
        return useItem;
    }

    public void deleteUseItem(int ItemSelect) {
        // 아이템 하나 사용
        Expendables[ItemSelect-1].remove(0);
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
