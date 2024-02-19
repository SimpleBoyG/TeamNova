package 사냥터.던전;

import 캐릭터.마법사.MageClass;
import 캐릭터.마스터.MasterClass;
import 마을.VillageInner;
import 캐릭터.몬스터.Monster;
import 문자열색상변경.TextColorChange;
import 사냥터.중급사냥터;

import java.util.Random;

public class 중급던전 extends 중급사냥터 {
    public 중급던전(MasterClass master, MageClass mage, VillageInner vi) {
        super(master, mage, vi);
        super.copyMonster = monster;
    }
    TextColorChange tcc = new TextColorChange();
    Random rd = new Random();
    int MonsterIndex = rd.nextInt(3);
    Monster 오크전사 = new Monster("오크 전사",20,30,10,150,100,30);
    Monster 오우거전사 = new Monster("오우거 전사",21,40,25,200,150,40);
    Monster 늑대인간 = new Monster("늑대인간",22,50,20,300,200,25);

    Monster monster[] = {오크전사, 오우거전사, 늑대인간};
    @Override
    public Monster createBattleMonster() {
        String strTemp = """
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢲⡄⠀⠀⠀⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⢠⣴⣶⣿⣿⢞⣶⣴⣤⣤⣽⣧⡀⠀⠘⣆⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⣰⠀⣴⣿⣿⣿⣿⣿⣹⣿⡿⣿⡛⡛⠛⠉⠀⠀⢹⡆⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⢠⣗⣴⣷⣻⣿⣿⢯⠞⠉⠘⣿⣿⣿⣿⣿⣿⣾⣶⣿⣿⠀⠀⠀⠀⠀⠀⠀
⠀⠀⢰⠀⢼⠟⢫⣟⠉⠱⡿⣿⡄⠀⡰⣯⣿⣿⠛⠛⠛⠛⠟⠿⠿⠀⠀⠀⠀⠀⠀⠀
⠀⠀⣼⠀⣠⣼⣿⡿⣶⣼⡆⡹⣿⣳⣿⣿⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⣿⣾⡿⠟⠁⠐⣿⢿⠛⡟⡯⣻⢹⣿⣿⣥⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠻⠋⠀⠀⠀⠀⠀⠑⢷⣷⣽⡾⢟⣽⣿⣿⣿⣿⣷⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣿⣷⡁⣰⣿⣿⣿⣥⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣭⣿⣿⣿⣿⣿⣿⣫⣿⣿⣿⣿⣿⣷⡄⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⣠⣿⣿⣏⣿⣿⣿⣿⣿⣟⣻⣿⣿⣿⡎⠻⣿⣿⣦⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⣴⣿⡟⣼⣯⣿⣿⣿⣿⣿⡟⣿⣿⣿⣿⡇⠀⠘⣿⣿⣧⡀⠀⠀⠀⠀
⠀⠀⠀⠀⢀⣾⣿⣿⢀⣿⣧⣿⣿⣿⣿⣿⣻⣿⣿⣿⣿⠇⠀⠀⣿⡿⢿⣷⣀⠀⠀⠀
⠀⠀⣠⣶⠾⣏⣿⣃⢰⣿⣷⢿⣿⣿⣿⡿⣿⣿⣿⣿⡿⠀⠠⣾⡿⠳⠞⠛⣿⣧⡀⠀
⠀⢰⡿⠁⠀⠀⠈⣿⡔⣿⣿⣿⣿⣿⣿⣿⡿⣿⣿⣿⡇⠀⢸⣿⠅⠀⠀⠀⢸⣿⠇⠀
⠀⠐⣿⡤⠀⡀⣠⣿⠂⣿⣿⣿⠛⠛⠛⠁⠀⠈⢿⣿⣇⠀⠘⢿⣷⡔⠈⣤⣾⡿⠁⠀
⠀⠀⠈⠀⠀⠟⠛⠁⠀⢽⣿⠇⠀⠀⠀⠀⠀⠀⠨⣿⡇⠀⠀⠈⠙⠀⠀⠙⠉⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⠅⠀⠀⠀⠀⠄⠀⠀⢽⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠇⠀⠀⠀⠀⠀⠀⠀⠸⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
        """;
        tcc.RedText(strTemp);
        strTemp = "몬스터는 ✴" + monster[MonsterIndex].Name + "✴ 입니다";
        tcc.RedText(strTemp);
        System.out.println("✴" + monster[MonsterIndex].Name + "✴ (이)가 공격을 하려고 합니다.");
        return monster[MonsterIndex];
    }
}
