package Mage;

public class WaterMageClass {
    public String name;
    public int MagicAttack = 10;
    public int Defence = 10;
    public int Hp = 80;
    public int Mp = 20;
    public int Experience;

    public WaterMageClass(String MageName) {
        this.name = MageName;
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
