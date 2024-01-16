package 마을.무기상점.무기.일반무기;

import 마을.무기상점.무기.Weapon;

public class 휘어진지팡이 extends Weapon {
    protected String  Name = "휘어진 지팡이";
    protected int Price = 500;
    //protected int PhysicalAttack = 10;
    protected int MagicAttack = 10;
    protected String WeaponType = "마법사";
    protected String EquipStatus = "<<미착용>>";

    @Override
    public void WeaponSkill(){
        System.out.println("일반 무기는 무기 스킬이 없습니다.");
    }

    @Override
    public String getName() { return Name; }
    @Override
    public int getPrice() { return Price; }
    @Override
    public int getPhysicalAttack() { return 0; }
    @Override
    public int getMagicAttack() { return MagicAttack; }
    @Override
    public String getWeaponType() { return WeaponType; }
    @Override
    public String getEquipStatus() { return EquipStatus; }
    @Override
    public void setEquipStatus(String str) { this.EquipStatus = str; }
}
