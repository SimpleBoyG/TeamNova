package 사냥터;

import 마법사.MageClass;
import 마스터.MasterClass;
import 마을.VillageInner;
import 몬스터.Monster;
import 문자열색상변경.TextColorChange;

import java.util.Random;
import java.util.Scanner;

public class 고급사냥터 extends 사냥터{
    public 고급사냥터(MasterClass master, MageClass mage, VillageInner vi) {
        super(master, mage, vi);
    }
    TextColorChange tcc = new TextColorChange();
    Random rd = new Random();
    int MonsterIndex = rd.nextInt(3);
    Monster 토끼 = new Monster("엔트",30,40,300,300,45);
    Monster 슬라임 = new Monster("스켈레톤",40,30,180,200,40);
    Monster 오크 = new Monster("리자드맨",55,20,250,250,40);
    HuntingMenu HM = new HuntingMenu();
    Monster monster[] = {토끼, 슬라임, 오크};
    @Override
    public Monster createBattleMonster() {
        String strTemp = """
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣶⣄⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣦⣄⣀⡀⣠⣾⡇⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀
                        ⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⢿⣿⣿⡇⠀⠀⠀⠀
                        ⠀⣶⣿⣦⣜⣿⣿⣿⡟⠻⣿⣿⣿⣿⣿⣿⣿⡿⢿⡏⣴⣺⣦⣙⣿⣷⣄⠀⠀⠀
                        ⠀⣯⡇⣻⣿⣿⣿⣿⣷⣾⣿⣬⣥⣭⣽⣿⣿⣧⣼⡇⣯⣇⣹⣿⣿⣿⣿⣧⠀⠀
                        ⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠸⣿⣿⣿⣿⣿⣿⣿⣷⠀
                        """;
        tcc.RedText(strTemp);
        strTemp = "몬스터는 ✴" + monster[MonsterIndex].Name + "✴ 입니다";
        tcc.RedText(strTemp);
        System.out.println("✴" + monster[MonsterIndex].Name + "✴ 가 공격을 하려고 합니다.");
        return monster[MonsterIndex];
    }

    // 배틀 존
    @Override
    public void BattleZone() {
        // 새로운 몬스터 생성
        Monster monster = createBattleMonster();
        if (HM.HuntingMenu() == 1) {
            // 배틀이 시작됩니다.
            System.out.println("배틀이 시작됩니다.");
            boolean bMasterMenu = true;
            boolean bMageMenu;

            // 배틀 시작시에 전체 스테이터스 전시
            super.showAllStatus(master, mage, monster);

            while (monster.Hp > 0 && bMasterMenu != false) {
                // 마스터 메뉴 선택
                bMasterMenu = MasterBattleAction(master, monster);
                if (bMasterMenu == true) {
                    showAllStatus(master, mage, monster);
                }
                bMageMenu = MageBattleAction(mage, monster);
                // 공격후 상태 확인
                if (bMageMenu == true) {
                    showAllStatus(master, mage, monster);
                }
            }
            System.out.println("배틀이 종료되었습니다.");
            // 경험치 획득
            EndAddExp();
            // Gold 획득
            EndAddGold();

            System.out.println("사냥을 계속 하시겠습니까?");
            System.out.println("1) 예 2) 아니오");
            Scanner sc = new Scanner(System.in);
            int TempSelect = sc.nextInt();
            if (TempSelect == 1) {
                super.MonsterSearching();
            } else {
                System.out.println("마을로 돌아갑니다.");
                vi.goVillage();
            }
        }else{
            System.out.println("마을로 돌아갑니다.");
            vi.goVillage();
        }
    }

    @Override
    public void EndAddGold(){
        String strTemp = "✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧";
        tcc.YellowText(strTemp);
        System.out.println();
        System.out.println("골드를 얻었습니다.");
        master.Gold = master.Gold + monster[MonsterIndex].HaveGold;
        System.out.printf("얻은 골드 : %d\n",monster[MonsterIndex].HaveGold);
        System.out.printf("현재 골드 : %d\n",master.Gold);
        tcc.YellowText(strTemp);
    }
    @Override
    public void EndAddExp(){
        String strTemp = "✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧";
        tcc.GreenText(strTemp);
        System.out.println("경험치를 얻었습니다.");
        master.Experience = master.Experience - monster[MonsterIndex].Exp;
        mage.Experience = mage.Experience - monster[MonsterIndex].Exp;
        System.out.println();
        System.out.printf("획득 경험치 : %d\n",monster[MonsterIndex].Exp);
        System.out.printf("마스터 경험치 : %d\n",master.Experience);
        System.out.printf("마법사 경험치 : %d\n",mage.Experience);
        tcc.GreenText(strTemp);
    }
}
