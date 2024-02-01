package 몬스터;

import 마법사.MageClass;
import 마스터.MasterClass;
import 문자열색상변경.TextColorChange;
import 사냥터.사냥터;

import java.util.Random;

public class Monster {
    static public boolean ThreadStop = true;
    public String Name;
    public int Attack;
    public int Defence;
    public int Hp;
    public int HaveGold;
    public int Exp;

    TextColorChange tcc = new TextColorChange();

    public Monster(String MonsterName, int Attack, int Defence, int Hp, int HavaCash, int Exp) {
        this.Name = MonsterName;
        this.Attack = Attack;
        this.Defence = Defence;
        this.Hp = Hp;
        this.HaveGold = HavaCash;
        this.Exp = Exp;
    }

    public boolean MonsterAction(MasterClass master, MageClass mage, 사냥터 사냥터) {
        final boolean[] bSuccessAttack = new boolean[1];
        Thread ThreadMonster = new Thread(new Runnable() {
            @Override
            public void run() {
                while (ThreadStop) {
                    // 랜덤으로 마스터, 마법사 공격
                    bSuccessAttack[0] = WhoAttack(master, mage);
                    사냥터.showAllStatus(master, mage, Monster.this);
                    // 몬스터 HP가 0일 경우
                    if(Hp <= 0){
                        return;
                    }
                    // 마스터, 마법사 HP가 0일 경우
                    if (master.Hp == 0 && mage.Hp == 0) {
                        System.out.println("모든 HP가 0이 되었습니다.");
                        break;
                    }
                    try {
                        // 10초에 한번씩 공격
                        Thread.sleep(10000);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        ThreadMonster.start();

        return bSuccessAttack[0];
    }

    public boolean WhoAttack(MasterClass master, MageClass mage) {
        Random rd = new Random();
        int whoAttack = rd.nextInt(2);
        String strTemp = " ";
        boolean AttackSuccess;
        // 마스터를 공격
        if (whoAttack == 0) {
            strTemp = Name + "가(이) 마스터를 공격했습니다.";
            tcc.PurpleText(strTemp);
            AttackSuccess = MasterAttack(master);
            if (AttackSuccess == false) {
                strTemp = "마스터의 Hp가 0이므로 " + Name + "가(이) 마법사를 공격했습니다.";
                tcc.PurpleText(strTemp);
                AttackSuccess = MageAttack(mage);
            }
        // 마법사를 공격
        } else {
            strTemp = Name + "가(이) 마법사를 공격했습니다.";
            tcc.PurpleText(strTemp);
            AttackSuccess = MageAttack(mage);
            if (AttackSuccess == false) {
                strTemp = "마법사 Hp가 0이므로 " + Name + "가(이) 마스터를 공격했습니다.";
                tcc.PurpleText(strTemp);
                AttackSuccess = MasterAttack(master);
            }
        }
        return AttackSuccess;
    }

    public boolean MasterAttack(MasterClass master) {
        boolean Result = false;
        int Damage = 0;
        if (master.Hp > 0) {
            Damage = master.Defence - Attack;
            if (Damage < 0) {
                master.Hp = master.Hp + Damage;
            } else {
                System.out.println("몬스터가 아무런 데미지를 입히지 못헀습니다.");
            }
            Result = true;
        }
        return Result;
    }

    public boolean MageAttack(MageClass mage) {
        boolean Result = false;
        int Damage = 0;
        if (mage.Hp > 0) {
            Damage = mage.Defence - Attack;
            if (Damage < 0) {
                mage.Hp = mage.Hp + Damage;
            } else {
                System.out.println("몬스터가 아무런 데미지를 입히지 못헀습니다.");
            }
            Result = true;
        }
        return Result;
    }

}
