package 사냥터;

import 마법사.MageClass;
import 마스터.MasterClass;
import 마을.VillageInner;
import 몬스터.Monster;
import 문자열색상변경.TextColorChange;


import java.util.Random;

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

    // 캐릭터 상태 정보를 설정하는 메소드
    public void setCharacterStatus(MasterClass master, MageClass mage){};

    // 마스터가 배틀할 때
    public void MasterBattle(MasterClass master){};

    // 메이지가 배틀할 때
    public void MageBattle(MageClass fire){};

    // 배틀 존
    public void BattleZone(){
        System.out.println("배틀이 시작됩니다.");
    }

    public boolean MasterBattleAction(MasterClass master, Monster monster) {
        boolean Result = true;
        switch (hm.MasterMenu(master)) {
            case 1:
                master.Attack(monster);
                break;
            case 2:
                Result = master.ShildAttack(monster);
                break;
            case 3:
                master.MageGuard();
                break;
            default:
                master.Run();
                Result = false;
                break;
        }
        return Result;
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

    public boolean showActionSelect(MasterClass master, Monster monster) {
        boolean Result = true;
        switch (hm.MasterMenu(master)) {
            case 1:
                master.Attack(monster);
                break;
            case 2:
                Result = master.ShildAttack(monster);
                break;
            case 3:
                master.MageGuard();
                break;
            default:
                master.Run();
                Result = false;
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
        TempStr = "========================================";
        textColor.YellowText(TempStr);
    }

    public void showMonsterStatus(Monster monster) {
        String TempStr = "=========" + monster.name + "============";
        textColor.RedText(TempStr);
        if(monster.Hp > 0) {
            TempStr = "HP : " + monster.Hp;
        }else{
            TempStr = "HP : 0";
        }
        textColor.RedText(TempStr);
        TempStr = "========================================";
        textColor.RedText(TempStr);
    }

    public void showAllStatus(MasterClass master, MageClass mage, Monster monster) {
        showMasterStatus(master);
        showMageStatus(mage);
        showMonsterStatus(monster);
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
}




















