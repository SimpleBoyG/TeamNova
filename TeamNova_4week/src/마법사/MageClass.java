package 마법사;

import 마법사.스킬.Skill;
import 마을.무기상점.무기.Weapon;
import 마을.방어구상점.방어구.Armor;
import 몬스터.Monster;

import java.util.ArrayList;

public class MageClass {
    public String name = "마법사";
    public int MagicAttack = 10;
    public int Defence = 10;
    public int Hp = 80;
    public int Mp = 20;
    public int Level = 1;
    public int Experience = 100;
    public int FullHp = Hp;
    public Weapon equipedWeapon;
    public Armor equipedArmor;
    public SkillSet SkillSet = new SkillSet(this);
    public ArrayList<Skill> HaveSkillList;
    public int SumMagicAttack;
    public int Use_Skill(int SkillIndex,Monster monster) {
        SumMagicAttack = MagicAttack + HaveSkillList.get(SkillIndex).Use_Skill();
        monster.Hp = monster.Hp - SumMagicAttack;
        return 0;
    }

}
