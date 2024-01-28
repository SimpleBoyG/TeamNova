package 마을;

import 마법사.MageClass;
import 마스터.MasterClass;
import 마을.무기상점.WeaponShop;
import 마을.방어구상점.ArmorShop;
import 마을.아이템상점.ItemShop;
import 마을.여관.Inn;
import 사냥터.초급사냥터;
import 사냥터.중급사냥터;
import 사냥터.고급사냥터;
import 사냥터.던전.초급던전;
import 사냥터.던전.중급던전;
import 사냥터.던전.고급던전;
import 사냥터.사냥터;
import 상태창.CharacterStatus;
import 시간.낮과밤;
import 인벤토리.All_Inventory;

import java.util.Scanner;

public class VillageInner {
    MasterClass master;
    MageClass mage;
    낮과밤 낮과밤;
    All_Inventory ai;

    public VillageInner(MasterClass master, MageClass mage) {
        this.master = master;
        this.mage = mage;
        ai = new All_Inventory(master, mage);
    }

    public void goVillage() {
        System.out.println("================================================ 아라한 마을 ================================================");
        System.out.println("""
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⡀⡀⢀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢐⠀⠀⠈⠀⠀⠱⠠⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠰⠱⡀⠀⠀⡠⠊⢆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠄⠄⠤⠠⠠⠄⠄⠄⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢘⡊⡢⢲⢸⢐⢘⢠⢢⠈⣊⠀⠀⠀⠀⠀⢀⡠⠢⠠⢒⠰⡰⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠠⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠠⠊⠉⠢⠢⣀⠀⠈⠀⠀⢀⠆⢀⠇⠭⠸⠰⡀⡐⠸⢨⠁⡂⢡⠀⠀⠀⠀⠀⠑⠄⢀⠀⠪⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠈⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠂⠒⠐⠂⠂⠂⠁⠈⠀⢀⠂⠈⠁⠣⠠⠠⠘⠐⠈⠄⠄⠄⠊⠀⢅⠀⠀⠀⠀⠀⠅⢕⠑⢠⠑⠀⠀⠀⠀⠀⡀⡠⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠈⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠐⠀⠀⠠⠀⠁⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠂⠀⠀⠀⢀⠆⠐⠄⠢⠐⠀⠰⠐⠀⠢⠂⠐⠔⠄⠂⠈⡄⠀⠀⡀⠀⠈⠐⠀⠀⠀⠀⠀⠀⠀⢎⡈⣀⢈⢌⠂⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠀⠠⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠂⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠐⣑⠠⡀⠰⠂⡢⠀⠠⠀⠀⠀⠀⠀⠀⠂⢒⠐⠐⠐⠐⠐⠐⠈⠂⠑⠈⠈⠈⠈⠈⡊⠀⠀⠀⠀⠀⠠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠄⠄⡀⠀⠀⢀⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠔⡡⠊⠀⠑⢌⠢⡊⠀⠀⠂⠀⠀⠀⠀⠀⠀⠀⢐⠀⢸⢈⡇⣑⠀⣃⣑⣁⠇⢘⡨⣈⡅⡅⠀⢀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠠⠀⠄⠠⢀⠀⠀⠀⠀⢔⢘⢈⢀⣀⣈⠸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠔⡡⠊⢀⠔⡂⢢⠀⠑⢌⠪⡈⠈⠈⠈⠈⠈⠈⢢⠀⠐⠀⠸⠀⠇⢐⠀⠆⠰⠀⠇⠨⠐⠄⠆⠆⡠⠁⢀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠠⡀⠄⠀⢢⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠃⡇⠀⠀⠐⢅⢑⠘⠀⠀⠀⠑⡌⢀⠄⣀⠠⠠⡀⠠⠣⠁⠀⢀⠠⡤⡀⠀⡀⣀⡀⠀⣀⢀⡀⠀⡕⠀⠀⠀⠁⠀⠀⠈⠂⠒⠐⠈⠀⢄⠠⢀⠀⢀⢂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡃⠁⠁⠠⠤⠤⠤⠀⠀⢀⠀⠌⠀⡀⠀⢀⠀⠀⢀⠈⡂⠀⡌⡐⢕⢈⠄⡅⡐⢨⠀⡂⡠⢨⠌⠀⠘⠄⠂⠔⠂⠀⠀⠈⠤⠁⠀⠀⠀⠀⠀⠑⠁⠀⢂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠧⠀⠀⢘⠂⡓⠂⠅⠀⠀⠀⡃⢂⢁⢒⢀⢁⢁⢁⢁⡁⠨⠄⠤⠠⠠⠣⠢⠐⠔⠄⠆⠔⠌⠜⡈⠈⠈⠈⠈⠈⠈⠈⠈⠈⠈⠈⠈⠈⠈⠈⠈⠈⠈⡊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠰⠠⠥⠠⠁⠁⠁⠀⠅⢅⢀⢀⠀⢀⢀⢀⢄⢂⡊⡁⡁⡁⢅⢁⢁⢁⢁⢁⠡⡁⡡⠡⢅⠀⡅⡁⡅⡑⠀⠨⡈⡸⡈⡨⠀⢨⢁⠩⡈⡇⡁⡡⡁⡁⠥⡡⢅⠍⠌⠥⠩⢑⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠈⠀⢀⠄⢄⠀⠁⠀⠀⠨⢈⠢⠅⢔⠀⢰⠠⡇⢔⠬⠠⠐⠤⡨⠈⠥⡠⠄⠄⠄⠢⠀⠢⠐⠐⡄⡂⠀⡂⢨⠀⠨⠀⢸⠀⠨⠀⢸⠀⢐⢀⢃⠄⡀⡄⢎⢊⢀⡁⡣⡢⡐⠄⠄⢅⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⡇⡀⠀⡂⠀⠀⢘⠀⠀⠄⢌⢐⠀⡅⢸⠀⢰⠀⡇⡘⡀⠁⡠⡃⢀⢄⠈⢒⡈⠀⠁⠈⠀⠁⡈⠠⠁⠂⠂⠂⠂⠀⠈⠒⠘⠒⠈⠀⠘⠐⢒⠂⣀⢀⣈⠂⠨⠸⠠⠪⠂⢨⢁⢀⢀⢄⢆⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⡐⡨⡢⡃⠀⢀⠂⠀⠀⠂⡂⠀⠀⠰⢐⠀⡍⠈⠉⡇⡂⠔⡈⡂⢔⠅⠀⢌⢕⠀⠀⢪⠀⡎⢇⠀⡃⢃⠨⠀⡒⠐⡒⠐⠄⢰⠐⠐⠐⢂⠀⢐⠂⢥⠡⢠⠐⣁⠩⡩⠩⠩⠩⠉⠂⠂⠂⠂⠒⡐⠁⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠀⠀⠀⡀⢊⠊⠀⠈⢊⢢⠰⠠⠄⠄⠄⠆⠄⠤⠸⠠⠠⡱⠈⡰⡨⠊⡈⠪⡢⠈⠐⡄⠀⠀⠀⠀⢸⠈⢈⠁⠈⢉⠁⠨⠀⡂⠂⡂⠂⠅⢸⠀⠀⡀⢐⠀⢨⠉⢱⠐⡡⠪⠀⠑⡐⢄⡠⠢⡀⢀⣀⣀⢀⠀⡂⠀⠀⡀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⡀⠂⠀⠂⢀⠔⡑⣁⣀⣀⣀⣀⠑⡑⢄⠀⠠⣀⠄⠀⠠⠀⡠⡰⡈⢅⢘⠨⠄⡇⠅⠌⠌⠍⠌⡇⡰⠑⠄⠜⢔⢝⠆⠄⠣⠅⠜⠄⠦⠤⠢⠤⠅⠔⠄⠥⠰⠠⠀⡜⠤⢁⠂⠀⢰⢨⡉⠈⢂⠪⡐⠀⠰⠐⡂⢘⠀⡅⠀⠀⠀⠀⢀⠀⠀⠀
⠀⠀⠀⠀⠀⠠⠀⢀⠀⠀⡰⠠⠊⠀⡂⢆⢰⢰⠠⡁⠈⠢⡑⡄⠀⢀⠀⡀⠁⡜⠐⢐⠐⢐⠘⠈⠊⠊⡂⠊⡂⠊⢠⠃⢄⠄⢌⠂⡇⡣⢄⠐⠔⢀⢌⠢⠀⠐⠄⠢⠐⠔⡀⡀⢇⠠⢊⠔⠁⠂⠀⠈⠂⠂⠐⠀⠱⡘⢄⠘⠐⠐⠐⠀⡇⠀⠀⡀⠂⠀⠀⠀⠀
⠀⠀⠀⠀⠂⠀⠂⠀⢀⠊⠔⠁⠀⠀⠢⠬⠸⠰⠡⠂⠀⠀⠐⢌⠢⡀⠁⠨⠅⠬⠌⠄⠭⠠⠡⠡⠡⠡⠨⠨⠨⠨⡌⠀⢀⢪⢑⠀⡇⡂⢱⠠⡠⡡⢹⠨⡡⡀⠠⠀⢀⠀⠀⡡⢊⠐⠁⠀⡇⡍⡆⠀⠀⠅⡍⡂⠀⠈⢄⠡⡀⠄⡄⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠈⠀⠀⠀⠐⢅⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢡⠌⡀⡈⢊⠨⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠰⠤⠤⢱⠘⠘⠐⠑⠘⢘⢜⠌⢨⢸⠐⡌⢌⠬⠌⠤⠠⠄⠆⡆⠐⠀⠀⠇⠆⠇⠈⠀⠅⠇⡂⠀⣀⢀⠱⠸⠂⡇⠀⡇⠀⠁⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⢰⠀⡐⢐⢐⠀⠀⡒⡂⡆⠀⡀⣀⢀⠀⠀⢸⠀⡆⡆⡂⢘⠀⠧⠥⠭⢘⠬⠧⠅⠀⠀⠀⠀⡇⠀⢸⠀⢠⠥⠭⡂⢦⠁⠁⡐⢐⢡⠀⠈⡎⠂⢀⢀⡀⠀⡇⠀⡄⠤⠄⠑⠀⠀⠠⠄⠒⡀⡀⡀⡀⠅⠀⠐⡅⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠌⠨⠨⠀⠀⠌⡎⡆⢀⠂⠀⠀⡇⠀⢸⠀⡇⡃⡂⢐⠀⡇⢌⢨⢨⢂⢇⡃⢸⠈⠨⠀⡇⠀⢸⠀⢄⢠⢁⡂⢸⠀⠀⠡⠅⠊⠀⠀⡇⠀⠖⠲⢸⠀⡇⠀⠧⠅⠌⠀⢅⢅⢇⡣⡂⠢⠔⠤⡇⠅⠀⠀⡇⠀⠇⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠣⠡⠩⠂⠘⠤⠅⠕⢰⠀⠀⠀⡃⠀⢸⠐⠑⠑⠈⠢⠁⠉⠈⠈⠈⠀⠁⠈⢨⠀⠡⠁⡇⠀⠰⠀⠀⠀⠀⠀⢸⠀⠀⢔⠕⡄⠀⠀⠅⠨⡀⡘⡀⠂⡇⠠⡃⡃⠬⠀⠅⠕⡕⠜⠄⡑⡈⡂⠣⡉⠊⠑⠑⠙⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠸⠒⠒⠒⠒⠒⠒⠒⠒⠲⠸⠒⠒⠆⠗⠲⠸⠒⠒⠒⠲⠸⡠⡠⡠⡠⢠⠠⡠⠠⡰⠠⡨⠠⡣⡠⠸⡠⢄⠤⡠⢄⢼⢀⢐⢸⢐⢸⢀⠨⠠⡠⠠⠠⠠⠠⣃⢀⢀⢐⢂⢀⢅⢀⢇⢀⢇⠠⡀⡀⡂⡂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠠⠠⠠⠠⠠⠠⠁⠃⠈⠈⠈⠈⠈⠈⠈⠈⠈⠈⠈⠈⠈⠈⠀⠁⠁⠈⠈⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
        """);
        System.out.println("마을입니다. 목적지를 선택해주세요.");
        System.out.println("1) 무기 상점 2) 방어구 상점 3) 아이템 상점 4) 여관 5) 상태창 6) 인벤토리 7) 사냥터");
        Scanner sc = new Scanner(System.in);
        int selectDes = sc.nextInt();
        selectDestination(selectDes);
    }

    public void goWeaponShop() {
        System.out.println("무기 상점으로 갑니다.");
        WeaponShop ws = new WeaponShop(this, ai, master, mage);
        ws.hereWeaponShop();
    }

    public void goArmorShop() {
        System.out.println("방어구 상점으로 갑니다.");
        ArmorShop as = new ArmorShop(this, ai, master, mage);
        as.hereArmorShop();
    }

    public void goItemShop() {
        System.out.println("아이템 상점으로 갑니다.");
        ItemShop is = new ItemShop(this, ai, master);
        is.hereItemShop();
    }

    public void goInn() {
        System.out.println("여관으로 갑니다.");
        Inn Inn = new Inn(this, master, mage);
        Inn.hereInn();
    }

    public void goStatusWindow() {
        System.out.println("캐릭터 상태창을 확인합니다.");
        CharacterStatus cs = new CharacterStatus(this, master, mage);
        cs.showAllStatus();
    }

    public void goInventoryWindow() {
        System.out.println("캐릭터 인벤토리창을 확인합니다.");
        ai.showAllInventory(this);
    }

    public void goHuntArea() {
        System.out.println("사냥터로 향합니다.");
        System.out.println("어떤 사냥터로 떠나시겠습니까?");
        System.out.println("1) 초급 사냥터 2) 중급 사냥터 3) 고급 사냥터");
        Scanner sc = new Scanner(System.in);
        int TempSelect = sc.nextInt();
        if (TempSelect == 1) {
            System.out.println("초급 사냥터로 향합니다.");
            사냥터 초급사냥터 = new 초급사냥터(master, mage, this);
            초급사냥터.MonsterSearching();
        } else if (TempSelect == 2) {
            System.out.println("중급 사냥터로 향합니다.");
            사냥터 중급사냥터 = new 중급사냥터(master, mage, this);
            중급사냥터.MonsterSearching();
        } else {
            System.out.println("중급 사냥터로 향합니다.");
            사냥터 고급사냥터 = new 고급사냥터(master, mage, this);
            고급사냥터.MonsterSearching();
        }

    }

    public void goHuntAreaAndDungeon() {
        System.out.println("사냥터로 향합니다.");
        System.out.println("어떤 사냥터로 떠나시겠습니까?");
        System.out.println("1) 초급 사냥터 2) 중급 사냥터 3) 고급 사냥터 4) 초급 던전 5) 중급 던전 6) 고급 던전");
        Scanner sc = new Scanner(System.in);
        int TempSelect = sc.nextInt();
        switch (TempSelect) {
            case 1:
                System.out.println("초급 사냥터로 향합니다.");
                사냥터 초급사냥터 = new 초급사냥터(master, mage, this);
                초급사냥터.MonsterSearching();
                break;
            case 2:
                System.out.println("중급 사냥터로 향합니다.");
                사냥터 중급사냥터 = new 중급사냥터(master, mage, this);
                중급사냥터.MonsterSearching();
                break;
            case 3:
                System.out.println("고급 사냥터로 향합니다.");
                사냥터 고급사냥터 = new 고급사냥터(master, mage, this);
                고급사냥터.MonsterSearching();
                break;
            case 4:
                System.out.println("초급 던전으로 향합니다.");
                초급사냥터 초급던전 = new 초급던전(master, mage, this);
                초급던전.MonsterSearching();
                break;
            case 5:
                System.out.println("중급 던전으로 향합니다.");
                중급사냥터 중급던전 = new 중급던전(master, mage, this);
                중급던전.MonsterSearching();
                break;
            case 6:
                System.out.println("중급 던전으로 향합니다.");
                고급사냥터 고급던전 = new 고급던전(master, mage, this);
                고급던전.MonsterSearching();
                break;
            default:
                System.out.println("사냥터를 잘못 선택했습니다");
                break;
        }


    }

    public void selectDestination(int selectDes) {
        switch (selectDes) {
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
            case 5:
                goStatusWindow();
                break;
            case 6:
                goInventoryWindow();
                break;
            default:
                this.낮과밤 = 낮과밤.getInstance();
                낮과밤.ReDay();
                String strTemp = 낮과밤.getDayAndNight();
                if (strTemp.equals("night")) {
                    goHuntAreaAndDungeon();
                } else {
                    goHuntArea();
                }
                break;
        }
    }
}
