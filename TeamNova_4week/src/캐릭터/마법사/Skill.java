package 캐릭터.마법사;

public abstract class Skill {
    public String SkillName = "";
    public int Magic_Grade = 0;
    public int Add_MagicAttack = 0;
    public int Pay_Mp = 0;

    public Skill(String SkillName,int Magic_Grade,int Add_MagicAttack,int Pay_Mp){
        this.SkillName = SkillName;
        this.Magic_Grade = Magic_Grade;
        this.Add_MagicAttack = Add_MagicAttack;
        this.Pay_Mp = Pay_Mp;
    };

    public abstract int Use_Skill();
}
