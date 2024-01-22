package 몬스터;

public class Monster {
    public String name;
    public int Attack;
    public int Defence;
    public int Hp;
    public int HaveCash;
    public int Exp;

    public Monster(String MonsterName, int Attack, int Defence, int Hp, int HavaCash, int Exp){
        this.name = MonsterName;
        this.Attack = Attack;
        this.Defence = Defence;
        this.Hp = Hp;
        this.HaveCash = HavaCash;
        this.Exp = Exp;
    }
}
