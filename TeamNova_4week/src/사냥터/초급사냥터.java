package 사냥터;

import 캐릭터.마법사.MageClass;
import 캐릭터.마스터.MasterClass;
import 마을.VillageInner;
import 캐릭터.몬스터.Monster;
import 문자열색상변경.TextColorChange;

import java.util.Random;

public class 초급사냥터 extends 사냥터{
    public 초급사냥터(MasterClass master, MageClass mage, VillageInner vi) {
        super(master, mage, vi);
    }
    TextColorChange tcc = new TextColorChange();
    Random rd = new Random();
    int MonsterIndex = rd.nextInt(3);
    final Monster 토끼 = new Monster("토끼",2,5,0,50,10,10);
    Monster 복제_토끼 = new Monster("토끼",2,5,0,50,10,10);
    final Monster 슬라임 = new Monster("슬라임",3,10,5,75,15,15);
    Monster 복제_슬라임 = new Monster("슬라임",3,10,5,75,15,15);
    final Monster 고블린 = new Monster("고블린",4,15,10,100,20,20);
    Monster 복제_고블린 = new Monster("고블린",4,15,10,100,20,20);
    Monster monster[] = {토끼, 슬라임, 고블린};
    public Monster copyMonster[] = {복제_토끼,복제_슬라임,복제_고블린};
    public Monster CreateMonster(){
        Random rd = new Random();
        int MonsterIndex = rd.nextInt(3);

        // 만약 사냥당한 몬스터가 있으면 다시 몬스터를 생성
        for(int i = 0; i < copyMonster.length; i++ ){
            if(copyMonster[i].Hp <= 0)
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
