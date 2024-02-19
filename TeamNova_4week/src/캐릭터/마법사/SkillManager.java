package 캐릭터.마법사;

import 캐릭터.마법사.스킬.Fire;
import 캐릭터.마법사.스킬.Water;

import java.util.ArrayList;

public class SkillManager {

    ArrayList<Skill> SkillPackage = new ArrayList<>();

    public Skill FireSkill_Level1 = new Fire("파이어 볼", 1, 20, 10);
    public Skill FireSkill_Level2 = new Fire("파이어 애로우", 2, 30, 15);
    public Skill FireSkill_Level3 = new Fire("파이어 스피어", 3, 40, 20);
    public Skill FireSkill_Level4 = new Fire("파이어 익스플로젼", 4, 50, 25);

    Skill WaterSkill_Level1 = new Water("아쿠아 볼", 1, 20, 10);
    Skill WaterSkill_Level2 = new Water("아쿠아 애로우", 2, 30, 15);
    Skill WaterSkill_Level3 = new Water("아쿠아 월", 3, 40, 20);
    Skill WaterSkill_Level4 = new Water("워터 밤", 4, 50, 25);

    public SkillManager() {
        SkillPackage.add(FireSkill_Level1);
        SkillPackage.add(FireSkill_Level2);
        SkillPackage.add(FireSkill_Level3);
        SkillPackage.add(FireSkill_Level4);
        SkillPackage.add(WaterSkill_Level1);
        SkillPackage.add(WaterSkill_Level2);
        SkillPackage.add(WaterSkill_Level3);
        SkillPackage.add(WaterSkill_Level4);
    }

    public ArrayList<Skill> getSkillPackage() {
        return SkillPackage;
    }


}
