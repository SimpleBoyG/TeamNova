package 사냥터;

import 마법사.MageClass;
import 마스터.MasterClass;
import 마을.VillageInner;
import 몬스터.Monster;
import 문자열색상변경.TextColorChange;

import java.util.Random;
import java.util.Scanner;

public class 중급사냥터 extends 사냥터{

    public 중급사냥터(MasterClass master, MageClass mage, VillageInner vi) {
        super(master, mage, vi);
    }
    TextColorChange tcc = new TextColorChange();

    Monster 오크 = new Monster("오크",20,10,100,10,15);
    Monster 오우거 = new Monster("오우거",30,20,200,100,30);
    Monster 산성슬라임 = new Monster("산성 슬라임",25,10,100,100,25);

    Monster monster[] = {오크,오우거,산성슬라임};
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
