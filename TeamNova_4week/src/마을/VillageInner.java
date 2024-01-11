package 마을;

import 마법사.FireMageClass;
import 마법사.WaterMageClass;
import 마스터.MasterClass;
import 마을.무기상점.WeaponShop;
import 마을.방어구상점.ArmorShop;
import 마을.아이템상점.ItemShop;
import 마을.여관.Inn;
import 사냥터.MonsterSearching;

import java.util.Scanner;

public class VillageInner {
    MasterClass master;
    FireMageClass fire;
    WaterMageClass water;
    public VillageInner(MasterClass master, FireMageClass fire, WaterMageClass water){
        System.out.println("""      
                마을
                """);
        this.master = master;
        this.fire = fire;
        this.water = water;

    }

    public void goVillage(){
        System.out.println("마을입니다. 목적지를 선택해주세요.");
        System.out.println("1) 무기 상점 2) 방어구 상점 3) 아이템 상점 4) 여관 5) 마을을 나갑니다.");
        Scanner sc = new Scanner(System.in);
        int selectDes = sc.nextInt();
        selectDestination(selectDes);
    }

    public void goWeaponShop(){
        System.out.println("무기 상점으로 갑니다.");
        WeaponShop ws = new WeaponShop();
        ws.hereWeaponShop();
    }

    public void goArmorShop(){
        System.out.println("방어구 상점으로 갑니다.");
        ArmorShop as = new ArmorShop();
        as.hereArmorShop();
    }

    public void goItemShop(){
        System.out.println("아이템 상점으로 갑니다.");
        ItemShop is = new ItemShop();
        is.hereItemShop();
    }

    public void goInn(){
        System.out.println("여관으로 갑니다.");
        Inn Inn = new Inn();
        Inn.hereInn();
    }

    public void goHunting(){
        System.out.println("사냥터로 향합니.");
        MonsterSearching ms = new MonsterSearching(master, fire, water);
        ms.MonsterSearching();
    }

    public void selectDestination(int selectDes){
        switch(selectDes){
            case 1:
                goWeaponShop();
                break;
            case 2:
                goArmorShop();
                break;
            case 3:
                goItemShop();
                break;
            case 4:
                goInn();
                break;
            default:
                goHunting();
                break;

        }
    }
}
