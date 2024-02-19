package 사냥터.던전;

import 캐릭터.마법사.MageClass;
import 캐릭터.마스터.MasterClass;
import 마을.VillageInner;
import 캐릭터.몬스터.Monster;
import 문자열색상변경.TextColorChange;
import 사냥터.초급사냥터;

import java.util.Random;

public class 초급던전 extends 초급사냥터 {
    public 초급던전(MasterClass master, MageClass mage, VillageInner vi) {
        super(master, mage, vi);
        super.copyMonster = monster;
    }
    TextColorChange tcc = new TextColorChange();
    Random rd = new Random();
    int MonsterIndex = rd.nextInt(3);
    Monster 큰앞니토끼 = new Monster("큰 앞니 토끼",7,10,5,60,20,20);
    Monster 킹슬라임 = new Monster("킹 슬라임",8,30,20,100,30,30);
    Monster 홉고블린 = new Monster("홉 고블린",9,20,15,80,20,25);
    Monster monster[] = {큰앞니토끼, 킹슬라임, 홉고블린};

    @Override
    public Monster createBattleMonster() {
        String strTemp = """
⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣾⣿⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⢀⣾⠟⢿⣿⣿⣿⣿⡿⠻⢿⡄⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⢼⣗⠀⠀⣿⣿⣿⣿⠁⠀⢸⣷⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⢿⣿⣦⣤⣿⣿⣿⣿⣥⣴⣿⣿⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⢹⣿⣟⢟⣻⢙⡏⢿⢻⢻⣿⡯⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⣹⣿⣾⣼⣦⣧⣿⣼⣿⣯⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⣻⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⣴⣿⣯⣼⣿⣿⣿⣽⣿⣿⣧⣽⣿⣧⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⣴⣿⣿⣟⣹⣿⣿⣿⢾⣿⣿⣟⣹⣿⣿⣷⠀⠀⠀⠀⠀
⠀⠀⠀⠀⣰⣿⠣⣿⣟⢻⣿⣿⣿⣻⣿⣿⡿⢻⣿⡇⢿⣧⠀⠀⠀⠀
⠀⠀⠀⢰⣿⡇⠨⣿⡿⢿⣿⣿⣿⣽⣿⣿⡿⣻⣿⠆⠸⣿⣆⠀⠀⠀
⠀⠀⢀⣿⡿⠀⠀⣿⣿⠿⣿⣿⣿⢾⣻⣿⡽⣾⣿⠁⠀⣻⣿⡄⠀⠀
⠀⠀⣸⢈⡏⠀⠀⢽⣿⣿⣻⣿⡯⣿⢿⡻⡻⣿⣟⠀⠀⢸⡁⣧⠀⠀
⠀⠀⣾⣿⡃⠀⠀⢹⣿⣿⠟⠷⠿⠿⠝⠝⡽⣾⡏⠀⠀⢘⣷⣿⠀⠀
⠀⠀⣿⣿⡯⠀⠀⠨⣿⡿⠀⠀⠀⠀⠀⠀⢻⢯⡂⠀⠀⣺⣿⣿⡂⠀
⠀⠈⣟⡟⡍⠁⠀⠀⢻⣟⠀⠀⠀⠀⠀⠀⢭⡿⠀⠀⠐⢑⢟⢿⠂⠀
⠀⠀⠀⠑⠈⠀⠀⠀⠘⣿⡀⠀⠀⠀⠀⢀⣿⠏⠀⠀⠀⠀⠘⠈⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠇⠀⠀⠀⠀⠐⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
        """;
        tcc.RedText(strTemp);
        strTemp = "몬스터는 ✴" + monster[MonsterIndex].Name + "✴ 입니다";
        tcc.RedText(strTemp);
        System.out.println("✴" + monster[MonsterIndex].Name + "✴ (이)가 공격을 하려고 합니다.");
        return monster[MonsterIndex];
    }
}
