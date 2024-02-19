package 캐릭터.마법사.스킬;

import 캐릭터.마법사.Skill;

import java.util.ArrayList;

public class Fire extends Skill {

    ArrayList<Skill> Skill_Package = new ArrayList<>();

    public Fire(String SkillName, int Magic_Grade, int Add_MagicAttack, int Pay_Mp) {
        super(SkillName,Magic_Grade,Add_MagicAttack,Pay_Mp);
    }

    @Override
    public int Use_Skill(){
        System.out.println("스킬 '" + SkillName + "' 을 시전했습니다.2" );
        return Add_MagicAttack;
    }


    //Skill Skill_Level4 = new 불("메테오",1,20);
}
