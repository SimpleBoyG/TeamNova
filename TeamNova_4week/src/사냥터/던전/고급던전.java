package 사냥터.던전;

import 마법사.MageClass;
import 마스터.MasterClass;
import 마을.VillageInner;
import 몬스터.Monster;
import 문자열색상변경.TextColorChange;
import 사냥터.고급사냥터;

import java.util.Random;

public class 고급던전 extends 고급사냥터 {
    public 고급던전(MasterClass master, MageClass mage, VillageInner vi) {
        super(master, mage, vi);
        super.copyMonster = monster;
    }

    TextColorChange tcc = new TextColorChange();
    Random rd = new Random();
    int MonsterIndex = rd.nextInt(3);
    Monster 거대엔트 = new Monster("거대 엔트",50,20,360,20,20);
    Monster 스켈레톤전사 = new Monster("스켈레톤 전사",50,20,500,30,30);
    Monster 리자드맨전사 = new Monster("리자드맨 전사",60,30,380,20,25);
    Monster monster[] = {거대엔트, 스켈레톤전사, 리자드맨전사};

    @Override
    public Monster createBattleMonster() {
        String strTemp = """
⠀⠀⠀⠀⣠⠞⣆⠀⠀⣰⣶⣿⣿⣷⣷⣄⠀⠀⣾⠱⣦⡄⠀⠀⠀⠀
⠀⠀⢀⣾⠃⠢⠃⢠⣾⠿⣿⣿⣿⣿⢻⣿⣷⣄⠙⠀⠘⢷⡀⠀⠀⠀
⠀⠀⢸⡎⠀⢀⣴⣿⡏⠀⠸⣿⣿⠇⠀⢸⣿⣿⣷⣀⢀⣼⡇⠀⠀⠀
⠀⠀⢽⣧⣤⣿⣿⢿⣧⣤⣼⣿⣿⣧⣤⣼⣿⠙⠻⣿⡿⠃⠀⠀⠀⠀
⠀⠀⠀⠈⠛⠋⠀⢼⣿⣙⣹⣸⣡⣕⡹⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⣀⣠⣴⣿⣟⣶⣵⣧⣥⡷⣿⣷⣦⣠⡄⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⣿⣿⣿⣿⣷⡯⣿⣿⣺⣯⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⣼⣿⡿⣿⣿⣿⣿⣿⣿⣿⣗⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀
⠀⠀⢀⣰⣿⡟⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠨⣿⣿⣄⡀⠀⠀⠀
⠀⠀⣿⣿⣿⠁⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡅⠸⣿⣿⡇⠀⠀⠀
⠀⢀⣽⣿⡇⠀⢼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⣿⣿⣧⠀⠀⠀
⠀⣿⣿⣿⠅⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡗⠀⢺⣿⣿⡇⠀⠀
⠀⡺⣿⢿⡅⠀⣾⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡯⠀⣾⠿⡿⡇⠀⠀
⢰⣗⢤⣙⣷⡀⢺⡿⡿⡷⢿⣿⡿⡿⠿⣿⣿⣿⡏⣼⣟⣡⣒⣷⠀⠀
⢸⢿⣟⣿⠀⠁⠘⣽⣿⠀⠀⠀⠀⠀⠀⢹⣿⣿⠁⠁⠸⡿⢿⢻⠀⠀
⠈⠸⠀⠻⠀⠀⠀⢻⣗⠀⠀⠀⠀⠀⠀⠀⣿⠗⠀⠀⠘⠋⠘⠈⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠈⠿⠀⠀⠀⠀⠀⠀⠐⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
        """;
        tcc.RedText(strTemp);
        strTemp = "몬스터는 ✴" + monster[MonsterIndex].Name + "✴ 입니다";
        tcc.RedText(strTemp);
        System.out.println("✴" + monster[MonsterIndex].Name + "✴ (이)가 공격을 하려고 합니다.");
        return monster[MonsterIndex];
    }
}
