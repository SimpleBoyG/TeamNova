package 사냥터;

import 마법사.MageClass;
import 마스터.MasterClass;
import 마을.VillageInner;
import 몬스터.Monster;
import 문자열색상변경.TextColorChange;

import java.util.Random;
import java.util.Scanner;

public class 초급사냥터 extends 사냥터{
    private String[] MonsterName = {"토끼", "슬라임", "오크"};
    public TextColorChange textColor = new TextColorChange();
    Random rd = new Random();
    int MonsterIndex = rd.nextInt(3);
    HuntingMenu hm = new HuntingMenu();

    public 초급사냥터(MasterClass master, MageClass mage, VillageInner vi) {
        super(master, mage, vi);
    }

    Monster 토끼 = new Monster("토끼",5,0,50,10,10);
    Monster 슬라임 = new Monster("슬라임",10,5,75,15,15);
    Monster 오크 = new Monster("오크",15,10,100,20,20);

    Monster monster[] = {토끼, 슬라임, 오크};
    @Override
    public Monster createBattleMonster() {
        System.out.println("몬스터는 " + monster[MonsterIndex].name + "입니다.");
        return monster[MonsterIndex];
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
    @Override
    public void BattleZone() {
        // 새로운 몬스터 생성
        Monster monster = createBattleMonster();
        // 배틀이 시작됩니다.
        System.out.println("초급 사냥터로 이동했습니다.");
        System.out.println("배틀이 시작됩니다.");
        boolean bMasterMenu = true;
        boolean bMageMenu = true;
        
        // 배틀 시작시에 전체 스테이터스 전시
        super.showAllStatus(master, mage, monster);
        
        while (monster.Hp > 0 && bMasterMenu != false){
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
        System.out.println("사냥을 계속 하시겠습니까?");
        System.out.println("1) 예 2) 아니오");
        Scanner sc = new Scanner(System.in);
        int TempSelect = sc.nextInt();
        if(TempSelect == 1){
            super.MonsterSearching();
        }else{
            vi.goVillage();
        }
    }
}
