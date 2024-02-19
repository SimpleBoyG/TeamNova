package 사냥터;

import BGM.BGMPlayer;
import BGM.ThreadManager;
import 캐릭터.마법사.MageClass;
import 캐릭터.마스터.MasterClass;
import 마을.VillageInner;
import 캐릭터.몬스터.Monster;
import 문자열색상변경.TextColorChange;


import java.util.Scanner;

public class 사냥터 {
    public Monster monster;
    public MasterClass master;
    public MageClass mage;
    public VillageInner vi;
    public HuntingMenu hm = new HuntingMenu();
    public TextColorChange textColor = TextColorChange.GetInstance();
    public MonsterSearching ms = new MonsterSearching(master, mage, vi, this);
    BGMPlayer BGMPlayer = BGM.BGMPlayer.getInstance();
    // 몬스터 생성
    public Monster createBattleMonster() {
        return monster;
    }

    public 사냥터(MasterClass master, MageClass mage, VillageInner vi) {
        this.master = master;
        this.mage = mage;
        this.vi = vi;
    }

    // 배틀 존
    public void BattleZone() {
        // 새로운 몬스터 생성
        monster = createBattleMonster();
        // 배틀이 시작됩니다.
        System.out.println("배틀이 시작됩니다.");

        // ================= BGM 실행 ================================
        BGMPlayer = BGM.BGMPlayer.getInstance();
        ThreadManager threadManager = ThreadManager.getInstance();

        // 기존 쓰레드 종료
        threadManager.ThreadTerminate(1);
        threadManager.createThread2();
        // 기존 BGM 정지, 닫기
        BGMPlayer.pause();
        threadManager.ThreadStart(2);
        // ===========================================================


        int iMasterMenu = 1;

        // 배틀 시작시에 전체 스테이터스 전시
        showAllStatus(master, mage, monster);

        while (monster.Hp > 0 && iMasterMenu != 0) {
            // 마스터 공격 메뉴 선택
            if (master.Hp > 0 && mage.Hp > 0) {
                iMasterMenu = MasterBattleAction(master, monster);
                while (iMasterMenu == 2) {
                    iMasterMenu = MasterBattleAction(master, monster);
                }
                if (iMasterMenu != 0) {
                    showAllStatus(master, mage, monster);
                    // 마법사 공격 메뉴 선택
                    MageBattleAction(mage, monster);
                    // 공격후 상태 확인
                    showAllStatus(master, mage, monster);

                    // 몬스터 공격 쓰레드 시작 - 쓰레드는 단독으로 돌아간다
                    Monster.ThreadStop = true;
                    boolean bMonsterAction = MonsterBattleAction();

                    // 몬스터 승리
                    if (bMonsterAction == false && master.Hp <= 0 && mage.Hp <= 0) {
                        System.out.println("배틀이 종료되었습니다.");
                        System.out.println("배틀에서 패배한 경우 마을로 이동하거나 아이템을 사용 후 사냥을 재개할 수 있습니다.");
                        Monster.ThreadStop = false;

                        // BGM 종료
                        BGMPlayer.pause();
                        threadManager.ThreadTerminate(2);
                        break;
                    }

                    // 마스터, 메이지 승리
                    if (monster.Hp <= 0) {
                        System.out.println("배틀이 종료되었습니다.");
                        Monster.ThreadStop = false;
                        // 경험치 획득
                        EndAddExp();
                        // Gold 획득
                        EndAddGold();

                        // BGM 종료
                        BGMPlayer.pause();
                        threadManager.ThreadTerminate(2);
                        break;
                    }
                }else{
                    // BGM 종료
                    BGMPlayer.pause();
                    threadManager.ThreadTerminate(2);
                }
            } else {
                System.out.println("마을로 돌아갑니다.");
                Monster.ThreadStop = false;
                vi.goVillage();
            }
        }

        if (iMasterMenu == 0) {
            Monster.ThreadStop = false;
            MonsterSearching();
        } else {
            Monster.ThreadStop = false;
            System.out.println("사냥을 계속 하시겠습니까?");
            System.out.println("1) 예 2) 아니오");
            System.out.println(":");
            Scanner sc = new Scanner(System.in);
            int TempSelect = sc.nextInt();
            if (TempSelect == 1) {
                MonsterSearching();
            } else {
                vi.goVillage();
            }
        }

    }

    public int MasterBattleAction(MasterClass master, Monster monster) {
        int iResult = 0;
        //0 : 도망 | 1 : 실행완료 | 2 : 아이템이 없음
        switch (hm.MasterMenu(master)) {
            case 1:
                iResult = master.CommonAttack(monster);
                break;
            case 2:
                master.Use_Skill(0, monster);
                iResult = 1;
                break;
            case 3:
                iResult = master.UseItem();
                break;
            default:
                iResult = master.Run();
                break;
        }
        return iResult;
    }

    public void MageBattleAction(MageClass mage, Monster monster) {
        int TempSelect = hm.MageMenu(mage);
        switch (TempSelect) {
            case 1:
                mage.CommonAttack(monster);
                break;
            case 2:
                mage.Use_Skill(TempSelect - 2, monster);
                break;
            case 3:
                mage.Use_Skill(TempSelect - 2, monster);
                break;
            case 4:
                mage.Use_Skill(TempSelect - 2, monster);
                break;
            case 5:
                mage.Use_Skill(TempSelect - 2, monster);
                break;
            default:
                System.out.println("스킬을 잘못 고르셨습니다.");
                System.out.println("턴이 넘어갑니다.");
                break;
        }
    }

    public boolean MonsterBattleAction() {
        boolean bSuccessAttack = monster.MonsterAction(master, mage, this);
        return bSuccessAttack;
    }

    public void showMasterStatus(MasterClass master) {
        String TempStr = "=========" + master.Name + "============";
        textColor.CyanText(TempStr);
        TempStr = "Level : " + +master.Level;
        textColor.CyanText(TempStr);
        if (master.Hp < 0) {
            master.Hp = 0;
            TempStr = "HP : " + master.Hp;
        } else {
            TempStr = "HP : " + master.Hp;
        }
        textColor.CyanText(TempStr);
        if (master.Hp < 0) {
            master.Mp = 0;
            TempStr = "MP : " + master.Mp;
        } else {
            TempStr = "MP : " + master.Mp;
        }

        textColor.CyanText(TempStr);
        TempStr = "물리 공격력 : " + master.Attack;
        textColor.CyanText(TempStr);
        TempStr = "방어력 : " + master.Defence;
        textColor.CyanText(TempStr);
        TempStr = "========================================";
        textColor.CyanText(TempStr);
    }

    public void showLevelUpMasterStatus(MasterClass master) {
        String TempStr = "=========" + master.Name + "============";
        textColor.CyanText(TempStr);
        TempStr = "Level : " + +master.Level;
        textColor.CyanText(TempStr);
        TempStr = "HP : " + master.Hp + "<< Hp + 50 >>";
        textColor.CyanText(TempStr);
        TempStr = "MP : " + master.Mp + "<< Mp + 30 >>";
        textColor.CyanText(TempStr);
        TempStr = "물리 공격력 : " + master.Attack + "<< 공격력 + 10 >>";
        textColor.CyanText(TempStr);
        TempStr = "방어력 : " + master.Defence + "<< 공격력 + 5 >>";
        textColor.CyanText(TempStr);
        TempStr = "경험치 : " + master.MaxExperience + "<< 경험치 + 50 >>";
        textColor.CyanText(TempStr);
        TempStr = "========================================";
        textColor.CyanText(TempStr);
    }

    public void showMageStatus(MageClass mage) {
        String TempStr = "=========" + mage.Name + "============";
        textColor.YellowText(TempStr);
        if (mage.Hp < 0) {
            mage.Hp = 0;
            TempStr = "HP : " + mage.Hp;
        } else {
            TempStr = "HP : " + mage.Hp;
        }
        textColor.YellowText(TempStr);
        if (mage.Mp < 0) {
            mage.Mp = 0;
            TempStr = "MP : " + mage.Mp;
        } else {
            TempStr = "MP : " + mage.Mp;
        }
        textColor.YellowText(TempStr);
        TempStr = "마법 공격력 : " + mage.MagicAttack;
        textColor.YellowText(TempStr);
        TempStr = "방어력 : " + mage.Defence;
        textColor.YellowText(TempStr);
        TempStr = "========================================";
        textColor.YellowText(TempStr);
    }

    public void showLevelUpMageStatus(MageClass mage) {
        String TempStr = "=========" + mage.Name + "============";
        textColor.YellowText(TempStr);
        TempStr = "Level : " + +mage.Level;
        textColor.YellowText(TempStr);
        TempStr = "HP : " + mage.Hp + "<< Hp + 30 >>";
        textColor.YellowText(TempStr);
        TempStr = "MP : " + mage.Mp + "<< Mp + 50 >>";
        textColor.YellowText(TempStr);
        TempStr = "마법 공격력 : " + mage.MagicAttack + "<< 마법 공격력 + 10>>";
        textColor.YellowText(TempStr);
        TempStr = "방어력 : " + mage.Defence + "<< 방어력 + 5 >>";
        textColor.YellowText(TempStr);
        TempStr = "경험치 : " + mage.MaxExperience + "<< 경험치 + 50 >>";
        textColor.YellowText(TempStr);
        TempStr = "========================================";
        textColor.YellowText(TempStr);
    }

    public void showMonsterStatus(Monster monster) {
        String TempStr = "=========" + monster.Name + "============";
        textColor.RedText(TempStr);
        TempStr = "Level : " + monster.Level;
        textColor.RedText(TempStr);
        if (monster.Hp > 0) {
            TempStr = "HP : " + monster.Hp;
        } else {
            monster.Hp = 0;
            TempStr = "HP : " + monster.Hp;
        }
        textColor.RedText(TempStr);
        TempStr = "공격력 : " + monster.Attack;
        textColor.RedText(TempStr);
        TempStr = "방어력 : " + monster.Defence;
        textColor.RedText(TempStr);
        TempStr = "========================================";
        textColor.RedText(TempStr);
    }

    public void showAllStatus(MasterClass master, MageClass mage, Monster monster) {
        showMonsterStatus(monster);
        showMasterStatus(master);
        showMageStatus(mage);
    }

    public void MonsterSearching() {
        int iTemp = hm.HuntingStartMenu();
        if (iTemp == 1) {
            ms.MonsterSearching();
        } else if (iTemp == 2) {
            mage.SkillSet.showSkillList();
            ms.MonsterSearching();
        } else {
            vi.goVillage();
        }
    }

    public void EndAddGold() {
        String strTemp = "✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧";
        textColor.YellowText(strTemp);
        System.out.println("골드를 얻었습니다.");
        System.out.println();
        master.Gold = master.Gold + monster.HaveGold;
        System.out.printf("얻은 골드 : %d\n", monster.HaveGold);
        System.out.printf("현재 골드 : %d\n", master.Gold);
        textColor.YellowText(strTemp);
    }

    public void EndAddExp() {
        String strTemp = "✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧";
        textColor.GreenText(strTemp);
        System.out.println("경험치를 얻었습니다.");
        master.Experience = master.Experience - monster.Exp;
        mage.Experience = mage.Experience - monster.Exp;
        System.out.println();
        System.out.printf("획득 경험치 : %d\n", monster.Exp);

        // 마스터 경험치 표시
        if (master.Experience <= 0) {
            master.Experience = 0;
            System.out.printf("마스터 경험치 : %d\n", master.Experience);
            master.LevelUp(master);
            showLevelUpMasterStatus(master);
        } else {
            System.out.printf("마스터 경험치 : %d\n", master.Experience);
        }

        // 메이지 경험치 표시
        if (mage.Experience <= 0) {
            mage.Experience = 0;
            System.out.printf("마법사 경험치 : %d\n", mage.Experience);
            mage.LevelUp(mage);
            showLevelUpMageStatus(mage);
        } else {
            System.out.printf("마법사 경험치 : %d\n", mage.Experience);
        }
        textColor.GreenText(strTemp);
    }
}




















