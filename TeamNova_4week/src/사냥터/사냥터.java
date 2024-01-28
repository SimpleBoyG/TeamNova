package 사냥터;

import 마법사.MageClass;
import 마스터.MasterClass;
import 마을.VillageInner;
import 몬스터.Monster;
import 문자열색상변경.TextColorChange;


import java.util.Random;
import java.util.Scanner;

public class 사냥터 {
    public Monster monster;
    public MasterClass master;
    public MageClass mage;
    public VillageInner vi;
    public HuntingMenu hm = new HuntingMenu();
    public TextColorChange textColor = new TextColorChange();
    public MonsterSearching ms = new MonsterSearching(master,mage,vi,this);

    // 몬스터 생성
    public Monster createBattleMonster(){
        return monster;
    }

    public 사냥터(MasterClass master, MageClass mage, VillageInner vi){
        this.master = master;
        this.mage = mage;
        this.vi = vi;
    }

    // 배틀 존
    public void BattleZone(){
        // 새로운 몬스터 생성
        monster = createBattleMonster();
        // 배틀이 시작됩니다.
        System.out.println("배틀이 시작됩니다.");
        int iMasterMenu = 1;
        boolean bMageMenu;

        // 배틀 시작시에 전체 스테이터스 전시
        showAllStatus(master, mage, monster);

        while (monster.Hp > 0 && iMasterMenu != 0){
            // 마스터 메뉴 선택
            iMasterMenu = MasterBattleAction(master, monster);
            if (iMasterMenu != 0) {
                showAllStatus(master, mage, monster);
                bMageMenu = MageBattleAction(mage, monster);
                // 공격후 상태 확인
                if (bMageMenu == true) {
                    showAllStatus(master, mage, monster);
                }
                System.out.println("배틀이 종료되었습니다.");
                // 경험치 획득
                EndAddExp();
                // Gold 획득
                EndAddGold();

                System.out.println("사냥을 계속 하시겠습니까?");
                System.out.println("1) 예 2) 아니오");
                System.out.println(":");
                Scanner sc = new Scanner(System.in);
                int TempSelect = sc.nextInt();
                if(TempSelect == 1){
                    MonsterSearching();
                }else{
                    vi.goVillage();
                }
            }else{
                MonsterSearching();
            }
        }

    }

    public int MasterBattleAction(MasterClass master, Monster monster) {
        int iResult = 0;
        switch (hm.MasterMenu(master)) {
            case 1:
                iResult = master.Attack(monster);
                break;
            case 2:
                iResult = master.ShildAttack(monster);
                break;
            case 3:
                iResult = master.UseItem();
                break;
            default:
                iResult = master.Run();;
                break;
        }
        return iResult;
    }

    public boolean MageBattleAction(MageClass mage, Monster monster) {
        boolean Result = true;
        int TempSelect = hm.MageMenu(mage);
        switch (TempSelect) {
            case 2:
                mage.Use_Skill(TempSelect-2,monster);
                break;
            case 3:
                mage.Use_Skill(TempSelect-2,monster);
                break;
            case 4:
                mage.Use_Skill(TempSelect-2,monster);
                break;
            case 5:
                mage.Use_Skill(TempSelect-2,monster);
                break;
            default:
                System.out.println("스킬을 잘못 고르셨습니다.");
                System.out.println("턴이 넘어갑니다.");
                break;
        }
        return Result;
    }

    public void showMasterStatus(MasterClass master) {
        String TempStr = "=========" + master.name + "============";
        textColor.CyanText(TempStr);
        TempStr = "HP : " + master.Hp;
        textColor.CyanText(TempStr);
        TempStr = "MP : " + master.Mp;
        textColor.CyanText(TempStr);
        TempStr = "물리 공격력 : " + master.Attack;
        textColor.CyanText(TempStr);
        TempStr = "========================================";
        textColor.CyanText(TempStr);
    }

    public void showMageStatus(MageClass mage) {
        String TempStr = "=========" + mage.name + "============";
        textColor.YellowText(TempStr);
        TempStr = "HP : " + mage.Hp;
        textColor.YellowText(TempStr);
        TempStr = "MP : " + mage.Mp;
        textColor.YellowText(TempStr);
        TempStr = "마법 공격력 : " + mage.MagicAttack;
        textColor.YellowText(TempStr);
        TempStr = "========================================";
        textColor.YellowText(TempStr);
    }

    public void showMonsterStatus(Monster monster) {
        String TempStr = "=========" + monster.Name + "============";
        textColor.RedText(TempStr);
        if(monster.Hp > 0) {
            TempStr = "HP : " + monster.Hp;
        }else{
            TempStr = "HP : 0";
        }
        textColor.RedText(TempStr);
        TempStr = "방어력 : "  + monster.Defence;
        textColor.RedText(TempStr);
        TempStr = "========================================";
        textColor.RedText(TempStr);
    }

    public void showAllStatus(MasterClass master, MageClass mage, Monster monster) {
        showMonsterStatus(monster);
        showMasterStatus(master);
        showMageStatus(mage);
    }

    public void MonsterSearching(){
        int iTemp = hm.HuntingStartMenu();
        if(iTemp == 1){
            ms.MonsterSearching();
        }else if(iTemp == 2){
            mage.SkillSet.showSkillList();
            ms.MonsterSearching();
        }else{
            vi.goVillage();
        }
    }

    public void EndAddGold(){
        String strTemp = "✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧";
        textColor.YellowText(strTemp);
        System.out.println("골드를 얻었습니다.");
        System.out.println();
        master.Gold = master.Gold + monster.HaveGold;
        System.out.printf("얻은 골드 : %d\n",monster.HaveGold);
        System.out.printf("현재 골드 : %d\n",master.Gold);
        textColor.YellowText(strTemp);
    }

    public void EndAddExp(){
        String strTemp = "✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧";
        textColor.GreenText(strTemp);
        System.out.println("경험치를 얻었습니다.");
        master.Experience = master.Experience - monster.Exp;
        mage.Experience = mage.Experience - monster.Exp;
        System.out.println();
        System.out.printf("획득 경험치 : %d\n",monster.Exp);
        System.out.printf("마스터 경험치 : %d\n",master.Experience);
        System.out.printf("마법사 경험치 : %d\n",mage.Experience);
        textColor.GreenText(strTemp);
    }
}




















