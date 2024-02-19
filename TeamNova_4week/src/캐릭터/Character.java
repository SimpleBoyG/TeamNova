package 캐릭터;

import 아이템.무기.Weapon;
import 아이템.방어구.Armor;
import 문자열색상변경.TextColorChange;
import 캐릭터.몬스터.Monster;

public abstract class Character {
    public String Name;
    public int Level;
    public int Attack;
    public int MagicAttack;
    public int Defence;
    public int MaxHp;
    public int Hp;
    public int MaxMp;
    public int Mp;
    public int MaxExperience;
    public int Experience;
    public Weapon equipedWeapon;
    public Armor equipedArmor;

    TextColorChange tcc = TextColorChange.GetInstance();

    // 이름, 레벨, 일반공격력, 마법공격력, 방어력, 최대 Hp, 최대 Mp
    public Character(String Name, int Level, int Attack, int MagicAttack,int Defence, int MaxHp, int MaxMp, int Experience){
        this.Name = Name;
        this.Level = Level;
        this.Attack = Attack;
        this.MagicAttack = MagicAttack;
        this.Defence = Defence;
        this.MaxHp = MaxHp;
        this.MaxMp = MaxMp;
        Hp = this.MaxHp;
        Mp = this.MaxMp;
        this.Experience = Experience;
    }

    public int CommonAttack(Monster monster) {
        int iTemp = 1;
        System.out.println("일반 공격을 했습니다.");
        int Damage = monster.Defence - Attack;
        if (Damage >= 0) {
            System.out.println("아무런 데미지를 입히지 못했습니다.");
        } else {
            monster.Hp = monster.Hp + Damage;
            System.out.printf("%d 의 데미지를 입혔습니다.\n", Math.abs(Damage));
        }
        return iTemp;
    }

    public void LevelUp(Character character) {
        String strTemp = "!!!!!!!!!!!!!!!!!!!!! " + character.Name + "가 레벨업 했습니다 !!!!!!!!!!!!!!!!!!!";
        tcc.YellowText(strTemp);

        Level = Level + 1;
        Defence = Defence + 5;
        MaxExperience = MaxExperience + 50;
        Experience = MaxExperience;

        if (character.getClass().getSimpleName().equals("MageClass")) {
            MaxHp = MaxHp + 30;
            Hp = MaxHp;
            MaxMp = MaxMp + 50;
            Mp = MaxMp;
            MagicAttack = MagicAttack + 10;
        } else {
            MaxHp = MaxHp + 50;
            Hp = MaxHp;
            MaxMp = MaxMp + 30;
            Mp = MaxMp;
            Attack = Attack + 10;
        }
    }

    public abstract void Use_Skill(int SkillIndex,Monster monster);
}


