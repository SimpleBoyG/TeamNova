package 캐릭터.마법사;

import 문자열색상변경.TextColorChange;
import 캐릭터.몬스터.Monster;
import 캐릭터.Character;
import java.util.ArrayList;

public class MageClass extends Character{
    public SkillSet SkillSet = new SkillSet(this);
    public ArrayList<Skill> HaveSkillList;
    public int SumMagicAttack;
    public MageClass(){
        super("마법사",1,0,10,10,80,200,100 );
    }

    @Override
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
}
