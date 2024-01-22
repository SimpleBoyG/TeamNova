package 마법사.스킬;

import 마법사.스킬.Skill;

public class Water extends Skill {

    public Water(String SkillName, int Magic_Grade, int Add_MagicAttack, int Pay_Mp) {
        super(SkillName,Magic_Grade,Add_MagicAttack,Pay_Mp);
    }

    @Override
    public int Use_Skill(){
        System.out.println("스킬 '" + SkillName + "' 을 시전했습니다.2" );
        return Add_MagicAttack;
    }

//    public boolean WaterBall(){
//        System.out.println("아쿠아 볼을 시전했습니다.");
//        return true;
//    }
//
//    public boolean WaterArrow(){
//        System.out.println("아쿠아 애로우를 시전했습니다.");
//        return true;
//    }
//
//    public boolean WaterWall(){
//        System.out.println("아쿠아 월을 시전했습니다.");
//        return true;
//    }
//
//    public boolean WaterBomb(){
//        System.out.println("워터 밤을 시전했습니다.");
//        return true;
//    }
//
//    public boolean BigWave(){
//        System.out.println("대해를 시전했습니다.");
//        return true;
//    }

}
