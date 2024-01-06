package Mage;

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

    public boolean FireBall(){
        System.out.println("파이어 볼을 시전했습니다.");
        return true;
    }

    public boolean FireArrow(){
        System.out.println("파이어 애로우를 시전했습니다.");
        return true;
    }

    public boolean FireWall(){
        System.out.println("파이어 월을 시전했습니다.");
        return true;
    }

    public boolean FireExplosion(){
        System.out.println("익스플로젼을 시전했습니다.");
        return true;
    }

    public boolean FireMeteo(){
        System.out.println("메테오를 시전했습니다.");
        return true;
    }

}
