package 몬스터;

public class Monster {
    public String Name;
    public int Attack;
    public int Defence;
    public int Hp;
    public int HaveGold;
    public int Exp;

    public Monster(String MonsterName, int Attack, int Defence, int Hp, int HavaCash, int Exp){
        this.Name = MonsterName;
        this.Attack = Attack;
        this.Defence = Defence;
        this.Hp = Hp;
        this.HaveGold = HavaCash;
        this.Exp = Exp;
    }
}
