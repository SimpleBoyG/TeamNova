package 사냥터;

import 마법사.MageClass;
import 마스터.MasterClass;
import 몬스터.Monster;
import 문자열색상변경.TextColorChange;

import java.util.Random;

public class HitMonster {
    private int MeetingCount = 0;
    MasterClass master;
    MageClass mage;
    TextColorChange tcc = new TextColorChange();
    사냥터 사냥터;
    Monster monster;
    public HitMonster(사냥터 사냥터) {
        Random rd = new Random();
        MeetingCount = rd.nextInt(10);
        this.사냥터 = 사냥터;
        this.monster = 사냥터.monster;
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
                String strTemp = "(!) 몬스터를 만났다.";
                tcc.GreenText(strTemp);
                InitMeetingCount();
                사냥터.BattleZone();
                Result = true;
                break;
            } else {
                String strTemp = "몬스터를 만나지 못했다.";
                tcc.RedText(strTemp);
                break;
            }
        }
        return Result;
    }

    // 캐릭터 상태 정보 전달
    public void setCharacterInfo(MasterClass master, MageClass mage) {
        this.master = master;
        this.mage = mage;
    }

}
