package 마법사;

import 마을.무기상점.무기.Weapon;
import 마을.방어구상점.방어구.Armor;
import 몬스터.Monster;

public class MageClass {
    public String name;
    public int MagicAttack = 10;
    public int Defence = 10;
    public int Hp = 80;
    public int Mp = 20;
    public int Experience;

    public Weapon equipedWeapon;
    public Armor equipedArmor;

    public MageClass(String MageName) {
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

    public boolean WaterBall(){
        System.out.println("아쿠아 볼을 시전했습니다.");
        return true;
    }

    public boolean WaterArrow(){
        System.out.println("아쿠아 애로우를 시전했습니다.");
        return true;
    }

    public boolean WaterWall(){
        System.out.println("아쿠아 월을 시전했습니다.");
        return true;
    }

    public boolean WaterBomb(){
        System.out.println("워터 밤을 시전했습니다.");
        return true;
    }

    public boolean BigWave(){
        System.out.println("대해를 시전했습니다.");
        return true;
    }


}
