package 마법사;

import 몬스터.Monster;

public class FireMageClass {
    public String name;
    public int MagicAttack = 10;
    public int Defence = 10;
    public int Hp = 80;
    public int Mp = 20;
    public int Experience;

    public FireMageClass(String MageName) {
        this.name = MageName;
    }

    public boolean SkillLevel1(Monster monster){
        System.out.println("파이어 볼을 시전했습니다.");
        return true;
    }

    public boolean SkillLevel2(Monster monster){
        System.out.println("파이어 애로우를 시전했습니다.");
        return true;
    }

    public boolean SkillLevel3(Monster monster){
        System.out.println("파이어 월을 시전했습니다.");
        return true;
    }

    public boolean SkillLevel4(Monster monster){
        System.out.println("익스플로젼을 시전했습니다.");
        return true;
    }

    public boolean SkillLevel5(Monster monster){
        System.out.println("메테오를 시전했습니다.");
        return true;
    }

}
