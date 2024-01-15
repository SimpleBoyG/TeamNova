package 사냥터;

import 마법사.MageClass;
import 마스터.MasterClass;

import java.util.Random;

public class HitMonster {
    private int MeetingCount = 0;
    MasterClass master;
    MageClass mage;

    HitMonster() {
        Random rd = new Random();
        MeetingCount = rd.nextInt(10);
    }

    // 몬스터 MeetingCount
    public void InitMeetingCount() {
        Random rd = new Random();
        MeetingCount = rd.nextInt(10);
    }

    public boolean HitMonsterStatus(int MonsterCount) {
        boolean Result = false;
        while (true) {
            if (MonsterCount == MeetingCount) {
                System.out.println(MeetingCount + " 번 만에 몬스터를 만났다");
                InitMeetingCount();
                Result = true;
                HitMonster();
                break;
            } else {
                System.out.println("몬스터를 만나지 못했다.");
                break;
            }
        }
        return Result;
    }

    public void HitMonster() {
        // 사냥 메뉴 전시 1) 공격한다 2) 도망친다
        HuntingMenu HM = new HuntingMenu();
        if (HM.HuntingMenu() == 1) {
            // 배틀 존으로 들어간다
            BattleBeginnerStep bbs = new BattleBeginnerStep();
            bbs.BattleZone(master,mage);

        }
    }

    // 캐릭터 상태 정보 전달
    public void setCharacterInfo(MasterClass master, MageClass mage) {
        this.master = master;
        this.mage = mage;
    }

}
