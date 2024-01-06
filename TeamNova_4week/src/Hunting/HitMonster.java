package Hunting;
import java.util.Random;

public class HitMonster {
    int MeetingCount = 0;
    HitMonster(){
        Random rd = new Random();
        MeetingCount = rd.nextInt(10);
    }

    // 몬스터 MeetingCount
    public void InitMeetingCount(){
        Random rd = new Random();
        MeetingCount = rd.nextInt(10);
    }

    public boolean MonterHitMotion(int MonsterCount){
        boolean bInit = false;
        while(true){
            if(MonsterCount == MeetingCount){
                System.out.println(MeetingCount + " 번 만에 몬스터를 만났다");
                InitMeetingCount();
                bInit = true;
                break;
            }else{
                System.out.println("몬스터를 만나지 못했다.");
                break;
            }
        }
        return bInit;
    }
}
