package 사냥터;

import 마법사.MageClass;
import 마스터.MasterClass;
import 마을.VillageInner;
import 몬스터.Monster;
import 문자열색상변경.TextColorChange;

import java.util.Random;

public class 고급사냥터 extends 사냥터{
    public 고급사냥터(MasterClass master, MageClass mage, VillageInner vi) {
        super(master, mage, vi);
    }
    TextColorChange tcc = new TextColorChange();
    Monster 엔트 = new Monster("엔트",30,40,300,300,45);
    Monster 스켈레톤 = new Monster("스켈레톤",40,30,180,200,40);
    Monster 리자드맨 = new Monster("리자드맨",55,20,250,250,40);
    HuntingMenu HM = new HuntingMenu();
    Monster monster[] = {엔트, 스켈레톤, 리자드맨};
    public Monster copyMonster[] = monster.clone();
    public Monster CreateMonster(){
        Random rd = new Random();
        int MonsterIndex = rd.nextInt(3);

        // 만약 사냥당한 몬스터가 있으면 다시 몬스터를 생성
        for(int i = 0; i < copyMonster.length; i++ ){
            if(copyMonster[i].Hp == 0)
            {
                copyMonster[i] = monster[i];
            }
        }
        return copyMonster[MonsterIndex];
    }

    @Override
    public Monster createBattleMonster() {
        Monster monster = CreateMonster();
        String strTemp = """
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣶⣄⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣦⣄⣀⡀⣠⣾⡇⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀
                        ⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⢿⣿⣿⡇⠀⠀⠀⠀
                        ⠀⣶⣿⣦⣜⣿⣿⣿⡟⠻⣿⣿⣿⣿⣿⣿⣿⡿⢿⡏⣴⣺⣦⣙⣿⣷⣄⠀⠀⠀
                        ⠀⣯⡇⣻⣿⣿⣿⣿⣷⣾⣿⣬⣥⣭⣽⣿⣿⣧⣼⡇⣯⣇⣹⣿⣿⣿⣿⣧⠀⠀
                        ⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠸⣿⣿⣿⣿⣿⣿⣿⣷⠀
                        """;
        tcc.RedText(strTemp);
        strTemp = "몬스터는 ✴" + monster.Name + "✴ 입니다";
        tcc.RedText(strTemp);
        System.out.println("✴" + monster.Name + "✴ (이)가 공격을 하려고 합니다.");
        return monster;
    }
}
