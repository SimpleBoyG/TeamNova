package 마법사;

import 마법사.스킬.Skill;
import 마을.무기상점.무기.Weapon;
import 마을.방어구상점.방어구.Armor;
import 몬스터.Monster;
import 문자열색상변경.TextColorChange;

import java.util.ArrayList;

public class MageClass {
    public String name = "마법사";
    public int MagicAttack = 10;
    public int Defence = 10;
    public int MaxHp = 80;
    public int Hp = MaxHp;
    public int MaxMp = 200;
    public int Mp = MaxMp;
    public int Level = 1;
    public int MaxExperience = 1;
    public int Experience = MaxExperience;
    public Weapon equipedWeapon;
    public Armor equipedArmor;
    public SkillSet SkillSet = new SkillSet(this);
    public ArrayList<Skill> HaveSkillList;
    public int SumMagicAttack;
    TextColorChange tcc = new TextColorChange();
    public void CommonAttack(Monster monster){
        int Damage = 0;
        Damage = monster.Defence - MagicAttack;
        if(Damage >= 0){
            System.out.println("아무런 데미지를 입히지 못했습니다.");
        }else {
            monster.Hp = monster.Hp + Damage;
            System.out.printf("%d 의 데미지를 입혔습니다.\n", Math.abs(Damage));
        }
    }
    public void Use_Skill(int SkillIndex,Monster monster) {
        int Damage = 0;
        SumMagicAttack = MagicAttack + HaveSkillList.get(SkillIndex).Use_Skill();
        Damage = monster.Defence - SumMagicAttack;
        if(Damage >= 0){
            System.out.println("아무런 데미지를 입히지 못했습니다.");
        }else {
            monster.Hp = monster.Hp + Damage;
            System.out.printf("%d 의 데미지를 입혔습니다.\n", Math.abs(Damage));
        }
        Mp = Mp - HaveSkillList.get(SkillIndex).Pay_Mp;
    }

    public void LevelUpMage(){
        String strTemp = "!!!!!!!!!!!!!!!!!!!!! 마법사가 레벨업 했습니다 !!!!!!!!!!!!!!!!!!!";
        tcc.YellowText(strTemp);
        Level = Level + 1;
        MaxHp = MaxHp + 30;
        Hp = MaxHp;
        MaxMp = MaxMp + 50;
        Mp = MaxMp;
        MagicAttack = MagicAttack + 10;
        Defence = Defence + 5;
        MaxExperience = MaxExperience + 50;
        Experience = MaxExperience;
    }

}
