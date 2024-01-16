package 사냥터;

import 마법사.MageClass;
import 마스터.MasterClass;
import 몬스터.Monster;
import 문자열색상변경.TextColorChange;

import java.util.Random;

public class BattleBeginnerStep {

    private String[] MonsterName = {"토끼", "슬라임", "오크"};
    private MasterClass master;
    private MageClass mage;
    private BattleBeginnerStep bbs;
    public TextColorChange textColor = new TextColorChange();
    Random rd = new Random();
    int MonsterIndex = rd.nextInt(3);
    HuntingMenu hm = new HuntingMenu();

    public Monster createBattleMonster() {
        Monster Monster = new Monster(MonsterName[MonsterIndex]); // 배틀할 몬스터 랜덤으로 지정
        System.out.println("몬스터는 " + Monster.name + "입니다.");
        return Monster;
    }

    // 캐릭터 상태 정보를 설정하는 메소드
    public void setCharacterStatus(MasterClass master, MageClass mage) {
        this.master = master;
        this.mage = mage;
    }

    // 마스터가 배틀할 때
    public void MasterBattle(MasterClass master) {
        System.out.println("마스터가 공격합니다");

    }

    // 메이지가 배틀할 때
    public void MageBattle(MageClass fire) {
        System.out.println("메이지가 공격합니다");
    }

    // 배틀 존
    public void BattleZone(MasterClass master, MageClass mage) {
        // 새로운 몬스터 생성
        Monster monster = createBattleMonster();
        // 배틀이 시작됩니다.
        System.out.println("배틀이 시작됩니다.");
        boolean bMasterMenu = true;
        while (monster.Hp != 0 && bMasterMenu != false) {
            // 마스터 메뉴 선택
            bMasterMenu = showActionSelect(master, monster);
            // 공격후 상태 확인
            if (bMasterMenu == true) {
                showAllStatus(master, mage, monster);
            }
        }
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
    }

    public void showMageStatus(MageClass mage) {
        System.out.println("=========" + mage.name + "============");
        System.out.println("HP : " + mage.Hp);
        System.out.println("MP : " + mage.Mp);
        System.out.println("========================================");
    }

    public void showMonsterStatus(Monster monster) {
        String TempStr = "=========" + monster.name + "============";
        textColor.RedText(TempStr);
        TempStr = "HP : " + monster.Hp;
        textColor.RedText(TempStr);
        TempStr = "========================================";
        textColor.RedText(TempStr);
    }

    public void showAllStatus(MasterClass master, MageClass mage, Monster monster) {
        showMasterStatus(master);
        showMageStatus(mage);
        showMonsterStatus(monster);
    }
}




















