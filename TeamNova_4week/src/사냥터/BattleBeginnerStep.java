package 사냥터;

import 마법사.FireMageClass;
import 마법사.WaterMageClass;
import 마스터.MasterClass;
import 몬스터.Monster;

import java.util.Random;

public class BattleBeginnerStep {

    private String[] MonsterName = {"토끼", "슬라임", "오크"};
    private MasterClass master;
    private FireMageClass fire;
    private WaterMageClass water;
    private BattleBeginnerStep bbs;

    Random rd = new Random();
    int MonsterIndex = rd.nextInt(3);
    HuntingMenu hm = new HuntingMenu();

    public Monster createBattleMonster() {
        Monster Monster = new Monster(MonsterName[MonsterIndex]); // 배틀할 몬스터 랜덤으로 지정
        System.out.println("몬스터는 " + Monster.name + "입니다.");
        return Monster;
    }

    // 캐릭터 상태 정보를 설정하는 메소드
    public void setCharacterStatus(MasterClass master, FireMageClass fire, WaterMageClass water) {
        this.master = master;
        this.fire = fire;
        this.water = water;
    }

    // 마스터가 배틀할 때
    public void MasterBattle(MasterClass master) {
        System.out.println("마스터가 공격합니다");

    }

    // 메이지가 배틀할 때
    public void MageBattle(FireMageClass fire) {
        System.out.println("메이지가 공격합니다");
    }

    // 배틀 존
    public void BattleZone(MasterClass master, FireMageClass fire, WaterMageClass water) {
        // 새로운 몬스터 생성
        Monster monster = createBattleMonster();
        // 배틀이 시작됩니다.
        System.out.println("배틀이 시작됩니다.");
        while (monster.Hp != 0) {
            // 마스터 메뉴 선택
            boolean bMasterMenu = showActionSelect(master, monster);
            // 공격후 상태 확인
            if(bMasterMenu == true) {
                showAllStatus(master, fire, monster);
            }
        }
    }

    public boolean showActionSelect(MasterClass master, Monster monster) {
        boolean Result = false;
        while (Result != true) {
            switch (hm.MasterMenu(master)) {
                case 1:
                    master.Attack(monster);
                    Result = true;
                    break;
                case 2:
                    Result = master.ShildAttack(monster);
                    break;
                case 3:
                    master.MageGuard();
                    Result = true;
                    break;
                default:
                    System.out.println("잘못 입력된 경우 일반공격을 합니다.");
                    master.Attack(monster);
                    Result = true;
            }
        }
        return Result;
    }

    public void showMasterStatus(MasterClass master) {
        System.out.println("=========" + master.name + "============");
        System.out.println("HP : " + master.Hp);
        System.out.println("MP : " + master.Mp);
        System.out.println("========================================");
    }

    public void showMageStatus(FireMageClass fire) {
        System.out.println("=========" + fire.name + "============");
        System.out.println("HP : " + fire.Hp);
        System.out.println("MP : " + fire.Mp);
        System.out.println("========================================");
    }

    public void showMonsterStatus(Monster monster) {
        System.out.println("=========" + monster.name + "============");
        System.out.println("HP : " + monster.Hp);
        System.out.println("========================================");
    }

    public void showAllStatus(MasterClass master, FireMageClass fire, Monster monster) {
        showMasterStatus(master);
        showMageStatus(fire);
        showMonsterStatus(monster);
    }
}




















