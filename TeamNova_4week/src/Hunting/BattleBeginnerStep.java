package Hunting;
import Mage.FireMageClass;
import Mage.WaterMageClass;
import Master.MasterClass;
import Monster.Monster;

import java.util.Random;

public class BattleBeginnerStep {
    
    private String[] MonsterName = {"토끼", "슬라임", "오크"};
    private MasterClass master;
    private FireMageClass fire;
    private WaterMageClass water;
    private BattleBeginnerStep bbs;

    Random rd = new Random();
    int MonsterIndex = rd.nextInt(3);

    public Monster createBattleMonster(){
        Monster Monster = new Monster(MonsterName[MonsterIndex]); // 배틀할 몬스터 랜덤으로 지정
        System.out.println("몬스터는 "+ Monster.name + "입니다.");
        return Monster;
    }

    // 캐릭터 상태 정보를 설정하는 메소드
    public void setCharacterStatus(MasterClass master, FireMageClass fire, WaterMageClass water){
        this.master = master;
        this.fire = fire;
        this.water = water;
    }

    // 마스터가 배틀할 때
    public void MasterBattle(MasterClass master) {
        System.out.println("마스터가 공격합니다");

    }

    // 메이지가 배틀할 때
    public void MageBattle(FireMageClass fire){
        System.out.println("메이지가 공격합니다");
    }

    // 배틀 존
    public void BattleZone(MasterClass master, FireMageClass fire, WaterMageClass water){
        // 새로운 몬스터 생성
        Monster monster = createBattleMonster();

        // 배틀이 시작됩니다.
        System.out.println("배틀이 시작됩니다.");

        master.ShildAttack();
        fire.FireArrow();
        water.BigWave();
    }


}




















